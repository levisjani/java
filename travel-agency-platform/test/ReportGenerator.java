import java.util.List;
import java.util.Map;

import java.io.IOException;
import java.io.File;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileWriter;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;

import com.ibm.nmon.util.ParserLog;

import com.ibm.nmon.interval.Interval;

import com.ibm.nmon.data.DataSet;
import com.ibm.nmon.data.ProcessDataSet;

import com.ibm.nmon.gui.chart.data.DataTupleDataset;

import com.ibm.nmon.gui.chart.ChartFactory;
import com.ibm.nmon.report.ReportCache;
import com.ibm.nmon.chart.definition.BaseChartDefinition;

import com.ibm.nmon.util.CSVWriter;

import com.ibm.nmon.util.GranularityHelper;

import com.ibm.nmon.util.TimeFormatCache;
import com.ibm.nmon.util.TimeHelper;

import com.ibm.nmon.util.FileHelper;
import com.ibm.nmon.file.CombinedFileFilter;

public final class ReportGenerator extends NMONVisualizerApp {
    private static final SimpleDateFormat FILE_TIME_FORMAT = new SimpleDateFormat("HHmmss");

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("no path(s) to parse specified");
            return;
        }

        // ensure the Swing GUI does not pop up or cause XWindows errors
        System.setProperty("java.awt.headless", "true");

        try {
            // initialize logging from the classpath properties file
            java.util.logging.LogManager.getLogManager().readConfiguration(
                    ReportGenerator.class.getResourceAsStream("/cmdline.logging.properties"));
        }
        catch (IOException ioe) {
            System.err.println("cannot initialize logging, will output to System.out");
            ioe.printStackTrace();
        }

        List<String> paths = new java.util.ArrayList<String>();

        List<String> customDataCharts = new java.util.ArrayList<String>();
        List<String> customSummaryCharts = new java.util.ArrayList<String>();
        List<String> multiplexedFieldCharts = new java.util.ArrayList<String>();
        List<String> multiplexedTypeCharts = new java.util.ArrayList<String>();

        String intervalsFile = "";

        boolean summaryCharts = true;
        boolean dataSetCharts = true;

        long startTime = Interval.DEFAULT.getStart();
        long endTime = Interval.DEFAULT.getEnd();

        boolean writeRawData = false;
        boolean writeChartData = false;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            char c = arg.charAt(0);

            if (c == '-') {
                nextarg: for (int j = 1; j < arg.length(); j++) {
                    c = arg.charAt(j);

                    switch (c) {
                    case 's':
                        try {
                            startTime = parseTime(args, ++i, 's');
                            break nextarg;

                        }
                        catch (IllegalArgumentException iae) {
                            System.err.println(iae.getMessage());
                            return;
                        }
                    case 'e':
                        try {
                            endTime = parseTime(args, ++i, 'e');
                            break nextarg;
                        }
                        catch (IllegalArgumentException iae) {
                            System.err.println(iae.getMessage());
                            return;
                        }
                    case 'd': {
                        ++i;

                        if (i > args.length) {
                            System.err.println("file must be specified for " + '-' + 'd');
                            return;
                        }

                        customDataCharts.add(args[i]);
                        break nextarg;
                    }
                    case 'a': {
                        ++i;

                        if (i > args.length) {
                            System.err.println("file must be specified for " + '-' + 'a');
                            return;
                        }

                        customSummaryCharts.add(args[i]);
                        break nextarg;

                    }
                    case 'i': {
                        ++i;

                        if (i > args.length) {
                            System.err.println("file must be specified for " + '-' + 's');
                            return;
                        }

                        intervalsFile = args[i];
                        break nextarg;
                    }
                    case '-': {
                        if (j == 1) { // --param
                            String param = arg.substring(2);

                            if ("nodata".equals(param)) {
                                dataSetCharts = false;
                            }
                            else if ("nosummary".equals(param)) {
                                summaryCharts = false;
                            }
                            else if ("mf".equals(param)) {
                                ++i;

                                if (i > args.length) {
                                    System.err.println("file must be specified for " + '-' + '-' + "mf");
                                    return;
                                }

                                multiplexedFieldCharts.add(args[i]);
                            }
                            else if ("mt".equals(param)) {
                                ++i;

                                if (i > args.length) {
                                    System.err.println("file must be specified for " + '-' + '-' + "mt");
                                    return;
                                }

                                multiplexedTypeCharts.add(args[i]);
                            }
                            else if ("rawdata".equals(param)) {
                                writeRawData = true;
                            }
                            else if ("chartdata".equals(param)) {
                                writeChartData = true;
                            }
                            else {
                                System.err.println("ignoring " + "unknown parameter " + '-' + '-' + param);
                            }

                            break nextarg;
                        }
                        else {
                            System.err.println("ignoring " + "misplaced dash in " + arg);
                            break;
                        }
                    }
                    default:
                        System.err.println("ignoring " + "unknown parameter " + '-' + c);
                    }
                }
            }
            else {
                // arg does not start with '-', assume file / directory
                paths.add(arg);
            }
        }

        boolean createCharts = true;

        if (!summaryCharts && !dataSetCharts && customDataCharts.isEmpty() && customSummaryCharts.isEmpty()) {
            System.out.println("--" + "nodata" + ", " + "--" + "nosummary"
                    + " were specifed and no custom chart definitions (-d or -a) were given: no charts will be output");
            createCharts = false;
        }

        if (paths.isEmpty()) {
            System.err.println("no path(s) to parse specified");
            return;
        }

        List<String> filesToParse = new java.util.ArrayList<String>();

        // find all NMON files
        for (String path : paths) {
            File pathToParse = new File(path);

            FileHelper.recurseDirectories(java.util.Collections.singletonList(pathToParse),
                    CombinedFileFilter.getInstance(false), filesToParse);

            if (filesToParse.isEmpty()) {
                System.err.println('\'' + pathToParse.toString() + "' contains no parsable files");
                return;
            }
        }

        ReportGenerator generator = new ReportGenerator(customSummaryCharts, customDataCharts, multiplexedFieldCharts,
                multiplexedTypeCharts);

        File outputDirectory = null;

        if (paths.size() == 1) {
            // all subsequent output goes into the directory given by the user
            outputDirectory = new File(paths.get(0));
        }
        else {
            // otherwise, use the current working directory
            outputDirectory = new File(System.getProperty("user.dir"));
        }

        generator.outputDirectory = outputDirectory.isDirectory() ? outputDirectory : outputDirectory.getParentFile();
        generator.writeChartData = writeChartData;

        // parse files
        generator.parse(filesToParse);

        // parse intervals
        if (!"".equals(intervalsFile)) {
            try {
                generator.getIntervalManager().loadFromFile(new File(intervalsFile), 0);
            }
            catch (IOException ioe) {
                System.err.println("cannot load intervals from '" + intervalsFile + "'");
                ioe.printStackTrace();
            }
        }

        // set interval after parse so min and max system times are set
        generator.createIntervalIfNecessary(startTime, endTime);

        if (createCharts) {
            if (generator.getIntervalManager().getIntervalCount() != 0) {
                // create charts for all intervals
                for (Interval interval : generator.getIntervalManager().getIntervals()) {
                    generator.createReport(interval, summaryCharts, dataSetCharts);
                }
            }
            else {
                generator.createReport(Interval.DEFAULT, summaryCharts, dataSetCharts);
            }

            System.out.println("Charts complete!");
        }

        if (writeRawData) {
            if (createCharts) {
                System.out.println();
            }

            if (generator.getIntervalManager().getIntervalCount() != 0) {
                // write data for all intervals
                for (Interval interval : generator.getIntervalManager().getIntervals()) {
                    generator.writeRawData(interval);
                }
            }
            else {
                generator.writeRawData(Interval.DEFAULT);
            }

            System.out.println("Raw data complete!");

        }
    }

    private static long parseTime(String[] args, int index, char param) {
        if (index > args.length) {
            throw new IllegalArgumentException("time must be specified for " + '-' + param);
        }

        try {
            return TimeHelper.TIMESTAMP_FORMAT_ISO.parse(args[index]).getTime();
        }
        catch (ParseException pe) {
            throw new IllegalArgumentException("time specified for " + '-' + param + " (" + args[index]
                    + ") is not valid");
        }
    }

    private final GranularityHelper granularityHelper;

    private final ChartFactory factory;
    private final ReportCache cache;

    private final List<String> customSummaryCharts;
    private final List<String> customDataCharts;
    private final List<String> multiplexedFieldCharts;
    private final List<String> multiplexedTypeCharts;

    private File outputDirectory;

    private boolean writeChartData = false;

    private ReportGenerator(List<String> customSummaryCharts, List<String> customDataCharts,
            List<String> multiplexedFieldCharts, List<String> multiplexedTypeCharts) {
        factory = new ChartFactory(this);
        cache = new ReportCache();

        granularityHelper = new GranularityHelper(this);
        granularityHelper.setAutomatic(true);

        this.customSummaryCharts = customSummaryCharts;
        this.customDataCharts = customDataCharts;
        this.multiplexedFieldCharts = multiplexedFieldCharts;
        this.multiplexedTypeCharts = multiplexedTypeCharts;

        // load chart definitions
        for (String file : customSummaryCharts) {
            parseChartDefinition(file);
        }

        for (String file : customDataCharts) {
            parseChartDefinition(file);
        }

        for (String file : multiplexedFieldCharts) {
            parseChartDefinition(file);
        }

        for (String file : multiplexedTypeCharts) {
            parseChartDefinition(file);
        }
    }

    private void parse(List<String> filesToParse) {
        // avoid logging parsing errors to console
        ParserLog log = ParserLog.getInstance();
        java.util.logging.Logger.getLogger(log.getLogger().getName()).setUseParentHandlers(false);

        Map<String, String> errors = new java.util.LinkedHashMap<String, String>();

        System.out.println("Parsing NMON files...");

        for (String fileToParse : filesToParse) {
            System.out.print("\t" + fileToParse + "... ");
            System.out.flush();

            log.setCurrentFilename(fileToParse);

            try {
                parse(fileToParse, getDisplayTimeZone());

                if (log.hasData()) {
                    System.out.println("Complete with errors!");
                }
                else {
                    System.out.println("Complete");
                }
            }
            catch (Exception e) {
                log.getLogger().error("could not parse " + fileToParse, e);
                System.out.println("Complete with errors!");
                // continue parsing other files
            }

            if (log.hasData()) {
                errors.put(log.getCurrentFilename(), log.getMessages());
            }
        }

        System.out.println("Parsing complete!");

        if (!errors.isEmpty()) {
            File errorFile = new File(outputDirectory, "ReportGenerator_"
                    + new SimpleDateFormat("yyyyMMdd_HHmmss").format(System.currentTimeMillis()) + ".log");

            PrintStream out = null;
            try {
                out = new PrintStream(new FileOutputStream(errorFile));
            }
            catch (IOException io) {
                System.err.println("could not create error log file '" + errorFile.getAbsolutePath()
                        + "'; no output will be logged");
                return;
            }
            for (String filename : errors.keySet()) {
                out.print(filename);
                out.println(':');
                out.println(errors.get(filename));
            }

            out.close();

            System.out.println();
            System.out.println("Errors written to " + errorFile);
        }

        // reset specifically so errors in ChartDefinitionParser _will_ go to the console
        java.util.logging.Logger.getLogger(ParserLog.getInstance().getLogger().getName()).setUseParentHandlers(true);
    }

    private void parseChartDefinition(String definitionFile) {
        try {
            // use the file name as the key
            cache.addReport(definitionFile, definitionFile);
        }
        catch (IOException ioe) {
            System.err.println("cannot parse chart definition " + definitionFile);
            ioe.printStackTrace();
        }
    }

    private void createIntervalIfNecessary(long startTime, long endTime) {
        if (startTime == Interval.DEFAULT.getStart()) {
            startTime = getMinSystemTime();
        }

        if (endTime == Interval.DEFAULT.getEnd()) {
            endTime = getMaxSystemTime();
        }

        Interval toChart = null;

        if ((startTime == getMinSystemTime() && (endTime == getMaxSystemTime()))) {
            toChart = Interval.DEFAULT;
        }
        else {
            try {
                toChart = new Interval(startTime, endTime);
            }
            catch (Exception e) {
                System.err.println("invalid start and end times: " + e.getMessage());
                System.err.println("The default interval will be used instead");
                toChart = Interval.DEFAULT;
            }
        }

        getIntervalManager().addInterval(toChart);
    }

    private void createReport(Interval interval, boolean summaryCharts, boolean dataSetCharts) {
        System.out.println();

        getIntervalManager().setCurrentInterval(interval);

        System.out.println("Charting interval " + TimeFormatCache.formatInterval(interval));

        File chartsDirectory = createSubdirectory("charts", interval);

        int chartsCreated = 0;

        System.out.println("Writing charts to " + chartsDirectory.getAbsolutePath());

        if (summaryCharts) {
            chartsCreated += createSummaryCharts("Creating summary charts", ReportCache.DEFAULT_SUMMARY_CHARTS_KEY,
                    chartsDirectory);
        }

        if (dataSetCharts) {
            for (DataSet data : getDataSets()) {
                chartsCreated += createDataSetCharts("Creating charts for " + data.getHostname(),
                        ReportCache.DEFAULT_DATASET_CHARTS_KEY, chartsDirectory, data);
            }
        }

        for (String file : customSummaryCharts) {
            chartsCreated += createSummaryCharts("Creating  charts for " + file, file, chartsDirectory);
        }

        for (String file : customDataCharts) {
            for (DataSet data : getDataSets()) {
                chartsCreated += createDataSetCharts("Creating charts for " + file + " (" + data.getHostname() + ")",
                        file, chartsDirectory, data);
            }
        }

        for (String file : multiplexedFieldCharts) {
            for (DataSet data : getDataSets()) {
                chartsCreated += multiplexChartsAcrossFields(
                        "Multiplexing charts for " + file + " (" + data.getHostname() + ") across " + "fields", file,
                        chartsDirectory, data);
            }
        }

        for (String file : multiplexedTypeCharts) {
            for (DataSet data : getDataSets()) {
                chartsCreated += multiplexChartsAcrossTypes(
                        "Multiplexing charts for " + file + " (" + data.getHostname() + ") across " + "types", file,
                        chartsDirectory, data);
            }
        }

        // remove charts directory if nothing was output
        if (chartsCreated == 0) {
            chartsDirectory.delete();
        }
    }

    private int createSummaryCharts(String message, String key, File chartsDirectory) {
        int chartsCreated = 0;

        Iterable<? extends DataSet> dataSets = getDataSets();
        List<BaseChartDefinition> report = cache.getReport(key, dataSets);

        if (!report.isEmpty()) {
            System.out.print("\t" + message + " ");
            System.out.flush();

            for (BaseChartDefinition definition : report) {
                if (saveChart(definition, dataSets, chartsDirectory)) {
                    ++chartsCreated;
                }
            }

            System.out.println(" Complete (" + chartsCreated + '/' + report.size() + ")");
        }

        return chartsCreated;
    }

    private int createDataSetCharts(String message, String key, File chartsDirectory, DataSet data) {
        int chartsCreated = 0;

        Iterable<? extends DataSet> dataSets = java.util.Collections.singletonList(data);
        List<BaseChartDefinition> report = cache.getReport(key, dataSets);

        if (!report.isEmpty()) {
            System.out.print("\t" + message + " ");
            System.out.flush();

            File datasetDirectory = new File(chartsDirectory, data.getHostname());
            datasetDirectory.mkdir();

            for (BaseChartDefinition definition : report) {
                if (saveChart(definition, dataSets, datasetDirectory)) {
                    ++chartsCreated;
                }
            }

            if (chartsCreated == 0) {
                datasetDirectory.delete();
            }

            System.out.println(" Complete (" + chartsCreated + '/' + report.size() + ")");
        }

        return chartsCreated;
    }

    private int multiplexChartsAcrossTypes(String message, String key, File chartsDirectory, DataSet data) {
        int chartsCreated = 0;

        List<BaseChartDefinition> report = cache.multiplexChartsAcrossTypes(key, data, true);

        if (!report.isEmpty()) {
            System.out.print("\t" + message + " ");
            System.out.flush();

            Iterable<? extends DataSet> dataSets = java.util.Collections.singletonList(data);
            File datasetDirectory = new File(chartsDirectory, data.getHostname());
            datasetDirectory.mkdir();

            for (BaseChartDefinition definition : report) {
                if (saveChart(definition, dataSets, datasetDirectory)) {
                    ++chartsCreated;
                }
            }

            if (chartsCreated == 0) {
                datasetDirectory.delete();
            }

            System.out.println(" Complete (" + chartsCreated + '/' + report.size() + ")");
        }

        return chartsCreated;
    }

    private int multiplexChartsAcrossFields(String message, String key, File chartsDirectory, DataSet data) {
        int chartsCreated = 0;

        List<BaseChartDefinition> report = cache.multiplexChartsAcrossFields(key, data, true);

        if (!report.isEmpty()) {
            System.out.print("\t" + message + " ");
            System.out.flush();

            Iterable<? extends DataSet> dataSets = java.util.Collections.singletonList(data);
            File datasetDirectory = new File(chartsDirectory, data.getHostname());
            datasetDirectory.mkdir();

            for (BaseChartDefinition definition : report) {
                if (saveChart(definition, dataSets, datasetDirectory)) {
                    ++chartsCreated;
                }
            }

            if (chartsCreated == 0) {
                datasetDirectory.delete();
            }

            System.out.println(" Complete (" + chartsCreated + '/' + report.size() + ")");
        }

        return chartsCreated;
    }

    private boolean saveChart(BaseChartDefinition definition, Iterable<? extends DataSet> dataSets, File saveDirectory) {
        JFreeChart chart = factory.createChart(definition, dataSets);

        if (chartHasData(chart)) {
            File chartFile = new File(saveDirectory, definition.getShortName() + ".png");

            try {
                ChartUtilities.saveChartAsPNG(chartFile, chart, definition.getWidth(), definition.getHeight());
            }
            catch (IOException ioe) {
                System.err.println("cannot create chart " + chartFile.getName());
            }

            if (writeChartData) {
                writeChartData(chart, definition, saveDirectory);
            }

            System.out.print('.');
            System.out.flush();

            return true;
        }
        else {
            return false;
        }
    }

    private void writeRawData(Interval interval) {
        System.out.println("Writing data for interval " + TimeFormatCache.formatInterval(interval));

        File rawDirectory = createSubdirectory("rawdata", interval);

        System.out.println("Writing CSV files to " + rawDirectory.getAbsolutePath());

        for (DataSet data : getDataSets()) {
            if (data.getRecordCount(interval) == 0) {
                System.out.println("\tNo data for " + data.getHostname() + " during the interval");
                continue;
            }

            System.out.print("\tWriting CSV for " + data.getHostname() + " ... ");
            System.out.flush();

            File dataFile = new File(rawDirectory, data.getHostname() + ".csv");
            FileWriter writer = null;

            try {
                writer = new FileWriter(dataFile);

                CSVWriter.write(data, interval, writer);

                System.out.println("Complete");
            }
            catch (IOException ioe) {
                System.err.println("could not output raw data to " + dataFile.getName());
            }
            finally {
                if (writer != null) {
                    try {
                        writer.close();
                    }
                    catch (IOException ioe) {
                        // ignore
                    }
                }
            }

            if (data instanceof ProcessDataSet) {
                ProcessDataSet processData = (ProcessDataSet) data;

                if (processData.getProcessCount() == 0) {
                    continue;
                }

                dataFile = new File(rawDirectory, data.getHostname() + "_processes" + ".csv");
                writer = null;

                try {
                    writer = new FileWriter(dataFile);

                    CSVWriter.writeProcesses(data, writer);

                    System.out.println("Complete");
                }
                catch (IOException ioe) {
                    System.err.println("could not output raw data to " + dataFile.getName());
                }
                finally {
                    if (writer != null) {
                        try {
                            writer.close();
                        }
                        catch (IOException ioe) {
                            // ignore
                        }
                    }
                }
            }
        }
    }

    private void writeChartData(JFreeChart chart, BaseChartDefinition definition, File saveDirectory) {
        File csvFile = new File(saveDirectory, definition.getShortName() + ".csv");
        FileWriter writer = null;

        Plot plot = chart.getPlot();
        DataTupleDataset dataset = null;

        if (plot instanceof CategoryPlot) {
            CategoryPlot cPlot = (CategoryPlot) plot;
            dataset = (DataTupleDataset) cPlot.getDataset();
        }
        else if (plot instanceof XYPlot) {
            XYPlot xyPlot = (XYPlot) plot;
            dataset = (DataTupleDataset) xyPlot.getDataset();
        }
        else {
            System.err.println("unknown plot type " + plot.getClass() + " for chart " + chart.getTitle());
        }

        if (dataset != null) {
            try {
                writer = new FileWriter(csvFile);

                CSVWriter.write(dataset, writer);
            }
            catch (IOException ioe) {
                System.err.println("could not output raw data to " + csvFile.getName());
            }
            finally {
                if (writer != null) {
                    try {
                        writer.close();
                    }
                    catch (IOException ioe) {
                        // ignore
                    }
                }
            }
        }
    }

    private File createSubdirectory(String subDirName, Interval interval) {
        File toCreate = null;

        // put in base charts directory if the default interval or there is only a single interval
        if (getIntervalManager().getIntervalCount() <= 1) {
            toCreate = new File(outputDirectory, subDirName);
        }
        else {
            // use the interval name if possible
            if ("".equals(interval.getName())) {
                toCreate = new File(outputDirectory, subDirName + '/'
                        + FILE_TIME_FORMAT.format(new Date(interval.getStart())) + '-'
                        + FILE_TIME_FORMAT.format(new Date(interval.getEnd())));
            }
            else {
                toCreate = new File(outputDirectory, subDirName + '/' + interval.getName());
            }
        }

        toCreate.mkdirs();

        return toCreate;
    }

    private boolean chartHasData(JFreeChart chart) {
        boolean hasData = false;

        // determine if there will really be any data to display
        // do not output a chart if there is no data
        Plot plot = chart.getPlot();

        if (plot instanceof CategoryPlot) {
            CategoryPlot cPlot = (CategoryPlot) plot;

            outer: for (int i = 0; i < cPlot.getDatasetCount(); i++) {
                for (int j = 0; j < cPlot.getDataset(i).getRowCount(); j++) {
                    for (int k = 0; k < cPlot.getDataset(i).getColumnCount(); k++) {
                        Number value = cPlot.getDataset(0).getValue(j, k);

                        if ((value != null) && !Double.isNaN(value.doubleValue())) {
                            hasData = true;
                            break outer;
                        }
                    }
                }

            }
        }
        else if (plot instanceof XYPlot) {
            XYPlot xyPlot = (XYPlot) plot;

            for (int i = 0; i < xyPlot.getDatasetCount(); i++) {
                if (xyPlot.getDataset(i).getSeriesCount() > 0) {
                    hasData = true;
                    break;
                }
            }
        }
        else {
            System.err.println("unknown plot type " + plot.getClass() + " for chart " + chart.getTitle());
        }

        return hasData;
    }

    @Override
    public void currentIntervalChanged(Interval interval) {
        super.currentIntervalChanged(interval);

        granularityHelper.recalculate();

        factory.setInterval(interval);
        factory.setGranularity(granularityHelper.getGranularity());
    }
}
