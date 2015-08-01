import java.lang.reflect.Method;

public final class DelegatingMain {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            com.ibm.nmon.gui.main.NMONVisualizerGui.main(new String[0]);
        }
        else {
            String className = args[0];
            Class clazz = null;

            String[] newArgs = null;

            try {
                clazz = Class.forName(className);

                // remove the class name from the arguments
                newArgs = new String[args.length - 1];
                System.arraycopy(args, 1, newArgs, 0, newArgs.length);
            }
            catch (ClassNotFoundException e) {
                // assume passing arguments to NMONVisualizerGui
                clazz = com.ibm.nmon.gui.main.NMONVisualizerGui.class;

                newArgs = args;
            }

            Method main = clazz.getMethod("main", String[].class);
            main.invoke(DelegatingMain.class, (Object) newArgs);
        }
    }
}
