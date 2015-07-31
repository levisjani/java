package Interface;

import BuilderPattern.Reservation;
import FactoryMethod.Customer;
import FactoryMethod.CustomerFactory;
import FactoryMethod.TravelAgencyMain;
import Iterator.Collection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class RaportInterface extends javax.swing.JFrame {


    
    private static RaportInterface instance;
    static Collection collections;
    DateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    TravelAgencyMain travelAgencyMain= new TravelAgencyMain();
    public RaportInterface() {
        initComponents();
    }
    
    public static RaportInterface getInstance()
    {
        if (instance==null) {
            instance= new RaportInterface();
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

        txtIdCustomer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnGenerateRaport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Insert Customer Id");

        btnGenerateRaport.setText("Generate Raport");
        btnGenerateRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateRaportActionPerformed(evt);
            }
        });

        txtResultField.setColumns(20);
        txtResultField.setRows(5);
        jScrollPane1.setViewportView(txtResultField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerateRaport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerateRaport))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    
    
    private void btnGenerateRaportActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        

        try{
            
            
            travelAgencyMain.setCollections(travelAgencyMain.populateCollections());
            collections=travelAgencyMain.getCollections();
            
            int idCustomer= Integer.parseInt(txtIdCustomer.getText());
            int countRes=0;
            double totalSum=0;
            double twoYearsSum=0;
            Iterator customerIterator=travelAgencyMain.getCustomerIterator(collections);
            Iterator reservationIterator=travelAgencyMain.getReservationIterator(collections);
            
            while(reservationIterator.hasNext())
            {
                
                Reservation res=(Reservation)reservationIterator.next();
                if(res.getCustId()==idCustomer)
                {
                    countRes++;
                    totalSum+=res.getTotalSum();
                   
                    double diffDays=(TimeUnit.MILLISECONDS.toDays(new Date().getTime())-TimeUnit.MILLISECONDS.toDays(res.getDepartDate().getTime()));
                    
                    if((int)diffDays/365 <=2)
                    {
                        twoYearsSum+=res.getTotalSum();
                    }
                }
            }
            
            txtResultField.setText("The customer has "+countRes+" reservations. \n "
                    + "The customer has spent "+totalSum+" Euros with the agency. \n The customer has spent "+twoYearsSum+" Euros within the last two years. \n");

            HashMap<String,Integer> frequencies= new HashMap();
            frequencies=travelAgencyMain.getFrequencies(collections);
            
            Map.Entry mostPreferredDest=travelAgencyMain.getPreferredDestination(frequencies);
            txtResultField.append("The most preferred destination is"+mostPreferredDest.getKey().toString()+ " with number of reservations: "+mostPreferredDest.getValue().toString()+"\n");
            
            HashMap<Integer,Double> frequencyClients=travelAgencyMain.getClientFrequencies(collections);            
            Map.Entry bestClient=travelAgencyMain.getBestClient(frequencyClients);
            txtResultField.append("The best client of the agency is "+ travelAgencyMain.getCustomerbyId(Integer.parseInt(bestClient.getKey().toString())).getName()+" "+travelAgencyMain.getCustomerbyId(Integer.parseInt(bestClient.getKey().toString())).getSurname()+ " with money spent: "+ bestClient.getValue().toString());
        }
        catch (Exception ex){ex.printStackTrace();}

    }                                                 

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RaportInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RaportInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RaportInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RaportInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RaportInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnGenerateRaport;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIdCustomer;
    private javax.swing.JTextArea txtResultField;
    // End of variables declaration                   
}
