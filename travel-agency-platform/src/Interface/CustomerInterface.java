package Interface;

import FactoryMethod.*;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class CustomerInterface extends javax.swing.JFrame {

    /**
     * Creates new form CustomerInterface2
     */
    public CustomerInterface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        getCustomerInfoPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSurnameCust = new javax.swing.JTextField();
        txtNameCust = new javax.swing.JTextField();
        txtAgeCust = new javax.swing.JTextField();
        txtAddressCust = new javax.swing.JTextField();
        addCustomerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Name");

        jLabel3.setText("Surname");

        jLabel4.setText("Age");

        jLabel5.setText("Address");

        txtNameCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameCustActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout getCustomerInfoPanelLayout = new javax.swing.GroupLayout(getCustomerInfoPanel);
        getCustomerInfoPanel.setLayout(getCustomerInfoPanelLayout);
        getCustomerInfoPanelLayout.setHorizontalGroup(
            getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getCustomerInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSurnameCust, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(txtAgeCust)
                    .addComponent(txtAddressCust)
                    .addComponent(txtNameCust))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        getCustomerInfoPanelLayout.setVerticalGroup(
            getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getCustomerInfoPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNameCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSurnameCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAgeCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(getCustomerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddressCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        addCustomerBtn.setText("Add Customer");
        addCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(getCustomerInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(addCustomerBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(getCustomerInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCustomerBtn)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void addCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {                                               

            try{
            
            String name=txtNameCust.getText();
            String surname=txtSurnameCust.getText();
            String age=txtAgeCust.getText();
            String address=txtAddressCust.getText();  
            int id=CustomerFactory.generateCustomers().size()+1;
            
            TravelAgencyMain.createCustomer(id,new Customer(id, name, surname, age, address));
            
            JOptionPane.showMessageDialog(this, "The new customer was inserted correctly.");
           
            this.setVisible(false);
        }
        catch (Exception ex){ex.printStackTrace();}
        
    }                                              

    private void txtNameCustActionPerformed(java.awt.event.ActionEvent evt) {                                            
       
    }                                           


    // Variables declaration - do not modify                     
    private javax.swing.JButton addCustomerBtn;
    private javax.swing.JPanel getCustomerInfoPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAddressCust;
    private javax.swing.JTextField txtAgeCust;
    private javax.swing.JTextField txtNameCust;
    private javax.swing.JTextField txtSurnameCust;
    // End of variables declaration                   
}
