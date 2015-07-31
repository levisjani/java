package Interface;

import FactoryMethod.*;
import BuilderPattern.*;
import Memento.Originator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import java.io.*;

public class ReservationInterface extends javax.swing.JFrame {

    
    private static ReservationInterface instance;
    AbstractBuilder abstractBuilder;
    Customer cus;
    Reservation res;
    DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
    HashMap<Integer,Reservation> reservations= new HashMap();
    Originator originator= new Originator();
    
    File fileImported;
    
    
    private ReservationInterface() {
        initComponents();
    }
    
    
    public static ReservationInterface getInstance()
    {
        if (instance==null) {
            instance= new ReservationInterface();
            return instance;
        }
        else
        {
            return instance;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbDestination = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtDepartureDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtReturnDate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPriceNight = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnGenerateRaport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultField = new javax.swing.JTextArea();
        btnExport = new javax.swing.JButton();
        getCustomerInfoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnImport = new javax.swing.JButton();
        btnCreateCustomer = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnSaveReservation = new javax.swing.JButton();
        btnUpdateReservation = new javax.swing.JButton();
        getInfoCustomerBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Reservation Area");

        cmbDestination.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cmbDestinationComponentShown(evt);
            }
        });
        cmbDestination.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDestinationItemStateChanged(evt);
            }
        });

        jLabel7.setText("Destination:");

        jLabel9.setText("Departure Date:(yyyy-MM-dd)");

        jLabel10.setText("Return Date:");

        jLabel11.setText("Total Sum");

        jLabel12.setText("Price per Night");

        txtPriceNight.setEditable(false);

        jButton1.setText("Calculate Total Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPriceNight, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(48, 48, 48)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtReturnDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbDestination, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDepartureDate, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPriceNight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1))
        );

        btnGenerateRaport.setText("Generate Raport");
        btnGenerateRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateRaportActionPerformed(evt);
            }
        });

        txtResultField.setColumns(20);
        txtResultField.setRows(5);
        jScrollPane1.setViewportView(txtResultField);

        btnExport.setText("Export File");
        btnExport.setEnabled(false);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer ID");

        jLabel2.setText("Name");

        jLabel3.setText("Surname");

        jLabel4.setText("Age");

        jLabel5.setText("Address");

        txtSurname.setEditable(false);

        txtName.setEditable(false);

        txtAge.setEditable(false);

        txtAddress.setEditable(false);

        javax.swing.GroupLayout getCustomerInfoPanelLayout = new javax.swing.GroupLayout(getCustomerInfoPanel);
        getCustomerInfoPanel.setLayout(getCustomerInfoPanelLayout);
        getCustomerInfoPanelLayout.setHorizontalGroup(
            getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getCustomerInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(txtAge)
                    .addComponent(txtAddress)
                    .addComponent(txtCustomerID)
                    .addComponent(txtName))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        getCustomerInfoPanelLayout.setVerticalGroup(
            getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getCustomerInfoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnImport.setText("Import File");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnCreateCustomer.setText("New Customer");
        btnCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCustomerActionPerformed(evt);
            }
        });

        btnPay.setText("Pay Reservation");
        btnPay.setEnabled(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnSaveReservation.setText("Temp Reservation");
        btnSaveReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveReservationActionPerformed(evt);
            }
        });

        btnUpdateReservation.setText("Update Reservation");
        btnUpdateReservation.setEnabled(false);
        btnUpdateReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateReservationActionPerformed(evt);
            }
        });

        getInfoCustomerBtn1.setText("Get Information for Customer");
        getInfoCustomerBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getInfoCustomerBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getCustomerInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getInfoCustomerBtn1)
                            .addComponent(btnCreateCustomer))
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSaveReservation)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnPay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnExport)
                                        .addGap(64, 64, 64)
                                        .addComponent(btnImport)))
                                .addGap(34, 34, 34)
                                .addComponent(btnUpdateReservation))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGenerateRaport)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreateCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(getCustomerInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(getInfoCustomerBtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerateRaport)
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveReservation)
                            .addComponent(btnPay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExport)
                            .addComponent(btnUpdateReservation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void btnCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {                                                  

        CustomerInterface customerInt= new CustomerInterface();
        customerInt.setVisible(true);
    }                                                 
    
   
    private void cmbDestinationComponentShown(java.awt.event.ComponentEvent evt) {                                              
        
    }                                             

    private void formComponentShown(java.awt.event.ComponentEvent evt) {                                    
        

        Iterator locationIterator = TravelAgencyMain.getLocationIterator();
    
        while(locationIterator.hasNext())
        {
        Location loc = (Location)locationIterator.next();
        cmbDestination.addItem(loc.getDestinationCity());
        }
        
        
    }                                   

    private void cmbDestinationItemStateChanged(java.awt.event.ItemEvent evt) {                                                
        
        String location= cmbDestination.getSelectedItem().toString();
        
        Location loc= TravelAgencyMain.getLocationbyName(location);
        
        txtPriceNight.setText(String.valueOf(loc.getPriceNight()));
        
    }                                               

    private void btnGenerateRaportActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        
        RaportInterface raportInt= RaportInterface.getInstance();
        raportInt.setVisible(true);
        
        
    }                                                 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:

       
        try
        {           

        
        Date depart=(Date)format.parse(txtDepartureDate.getText());
        Date returnD=(Date)format.parse(txtReturnDate.getText());

        long nrDays= TimeUnit.MILLISECONDS.toDays(returnD.getTime())-TimeUnit.MILLISECONDS.toDays(depart.getTime());
               
        Location loc= TravelAgencyMain.getLocationbyName(cmbDestination.getSelectedItem().toString());

        double totalSum= (int)nrDays * loc.getPriceNight();
        
        txtAmount.setText(String.valueOf(totalSum));
        }
        
        catch(ParseException ex)
        {
            ex.printStackTrace();
        }
              
    }                                        

    private void btnSaveReservationActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        abstractBuilder = new Builder();
        
        try
        {

            abstractBuilder.setCustomerId(Integer.parseInt(txtCustomerID.getText()));
            abstractBuilder.setDestination(cmbDestination.getSelectedItem().toString());

            abstractBuilder.setDepartDate((Date)format.parse(txtDepartureDate.getText()));
            abstractBuilder.setReturnDate((Date)format.parse(txtReturnDate.getText()));
            abstractBuilder.setTotalSum(Double.parseDouble(txtAmount.getText()));   
            abstractBuilder.setStatusPayment(false);
            if(abstractBuilder.checkValidation())
            {
                showMessageTextField(TravelAgencyMain.getCustomerbyId(abstractBuilder.getCustomerId()).getName()+"\n"+TravelAgencyMain.getCustomerbyId(abstractBuilder.getCustomerId()).getSurname()+"\n"+abstractBuilder.getDestination()+"\n"+
                abstractBuilder.getDepartDate()+"\n"+abstractBuilder.getReturnDate()+"\n"+abstractBuilder.getTotalSum());
            }
            btnPay.setEnabled(true);
            
        }
        catch(ParseException | ProjectException e) {}
        
        
    }                                                  

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {                                       
       
        abstractBuilder.setStatusPayment(true);
        
        res= abstractBuilder.createReservation();
        reservations.put(res.getReservationId(),res);
        
        if (res !=null)
            {
                showMessageTextField("Reservation Successful");
            }
        else 
            {
                showMessageTextField("Reservation Failed");
            }
        btnExport.setEnabled(true);
    }                                      

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {                                          

            JFileChooser fileChooser= new JFileChooser();
        
        if (fileChooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            File file=fileChooser.getSelectedFile();
            cus=TravelAgencyMain.getCustomerbyId(Integer.parseInt(txtCustomerID.getText()));
            
            originator.setCustomer(cus);
            originator.setReservation(res);
            originator.saveFileMemento(file);
            showMessageTextField(cus.getName()+ " "+ cus.getSurname()+"\n"+ res.getDestination()+"\n"+ format.format(res.getDepartDate())+"\n"
            +format.format(res.getReturnDate())+"\n"+String.valueOf(res.getTotalSum()));
        }
        
    }                                         

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {                                          

        JFileChooser filechooser= new JFileChooser();
        if(filechooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            Originator originator= new Originator();
            try
            {
            originator.loadMemento(filechooser.getSelectedFile());
            cus=originator.getCustomer();
            res=originator.getReservation();
            loadInformationDisplay(cus,res);
            showMessageTextField(cus.getName()+ " "+ cus.getSurname()+"\n"+ res.getDestination()+"\n"+ format.format(res.getDepartDate())+"\n"
            +format.format(res.getReturnDate())+"\n"+String.valueOf(res.getTotalSum()));
            fileImported=filechooser.getSelectedFile();
            }
            catch
                  (FileNotFoundException ex){};
            
        }
        
        btnUpdateReservation.setEnabled(true);
        
    }                                         

    @SuppressWarnings("empty-statement")
    private void btnUpdateReservationActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    
        try
        {

        Reservation reservation= new Reservation(Integer.parseInt(txtCustomerID.getText()),cmbDestination.getSelectedItem().toString(),(Date)format.parse(txtDepartureDate.getText()),(Date)format.parse(txtReturnDate.getText()),Double.parseDouble(txtAmount.getText()),false);     
        
        res=reservation;
        
        originator.setCustomer(cus);
        originator.setReservation(res);
        originator.saveFileMemento(fileImported);
        
        }
        catch
                (ParseException ex) {};
        
    }                                                    

    private void getInfoCustomerBtn1ActionPerformed(java.awt.event.ActionEvent evt) {                                                    
       
         int idCustomer= Integer.parseInt(txtCustomerID.getText());
         
         Customer cus= TravelAgencyMain.getCustomerbyId(idCustomer);
         
         fillInformationCustomer(cus);
    }                                                   

    private void loadInformationDisplay(Customer cus, Reservation res)
    {

        txtName.setText(cus.getName());
        txtSurname.setText(cus.getSurname());
        txtAge.setText(cus.getAge());
        txtAddress.setText(cus.getAddress());
        txtCustomerID.setText(String.valueOf(cus.getCustomerId()));
        cmbDestination.setSelectedItem(res.getDestination());
        txtDepartureDate.setText(format.format(res.getDepartDate()));
        txtReturnDate.setText(format.format(res.getReturnDate()));
        Location loc= TravelAgencyMain.getLocationbyName(cmbDestination.getSelectedItem().toString());
        
        txtPriceNight.setText(String.valueOf(loc.getPriceNight()));
        txtAmount.setText(String.valueOf(res.getTotalSum()));
    }
    //fill the fields with the appropriate information retrieved
    private void fillInformationCustomer(Customer cus)
    {
        txtName.setText(cus.getName());
        txtSurname.setText(cus.getSurname());
        txtAge.setText(cus.getAge());
        txtAddress.setText(cus.getAddress());
    }
    
    
    public void showMessageTextField(String message)
    {
        txtResultField.setText(message + "\n");
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCreateCustomer;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnGenerateRaport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnSaveReservation;
    private javax.swing.JButton btnUpdateReservation;
    private javax.swing.JComboBox cmbDestination;
    private javax.swing.JPanel getCustomerInfoPanel;
    private javax.swing.JButton getInfoCustomerBtn1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtDepartureDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPriceNight;
    private javax.swing.JTextArea txtResultField;
    private javax.swing.JTextField txtReturnDate;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration                   
}
