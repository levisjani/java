import java.rmi.*;
import java.net.MalformedURLException;
import java.util.Locale;
import java.text.NumberFormat;
import javax.swing.*;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;

public class BankUser extends JFrame{

  // Interface reference to BankManager
   private BankManager bm;
   private JTextArea printArea;
   private JTextField customerField;
   private JTextField accountField;
   private JButton queryButton;
   private JTextField depositAccountField;
   private JTextField depositAmount;
   private JTextField withdrawAccountField;
   private JTextField withdrawAmount;

  // No-argument constructor
  public BankUser() {

    super();

    final int DEFAULT_FRAME_WIDTH = 430;
    final int DEFAULT_FRAME_HEIGHT = 500;
    setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
    addWindowListener(new WindowCloser());
    setTitle("UNYT - MSc in Computer Science: Bank User Window");
      printArea = new JTextArea(10,10);

      customerField = new JTextField(10);
      accountField = new JTextField(10);

      queryButton = new JButton("Query Database");
      queryButton.addActionListener(new ButtonListener());

      // add components to content pane

      Container contentPane = getContentPane();
      contentPane.setLayout(new GridLayout(4,1));
      contentPane.add(printArea);

      // arrange the label and text field in a panel

      JPanel query1Panel = new JPanel();
      query1Panel.add(new JLabel("Customer ID: "));
      query1Panel.add(customerField);

      JPanel query2Panel = new JPanel();
      query2Panel.add(new JLabel("Account ID: "));
      query2Panel.add(accountField);

      // place the button in a panel

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(queryButton);

      // stack up these two panels in another panel

      JPanel centerPanel = new JPanel();
      centerPanel.setLayout(new GridLayout(3, 1));
      centerPanel.add(query1Panel);
      centerPanel.add(query2Panel);
      centerPanel.add(buttonPanel);

      contentPane.add(centerPanel);


      //// Deposit part

      depositAccountField = new JTextField(10);
      depositAmount = new JTextField(10);

      JPanel query3Panel = new JPanel();
      query3Panel.add(new JLabel("Account ID to deposit: "));
      query3Panel.add(depositAccountField);

      JPanel query4Panel = new JPanel();
      query4Panel.add(new JLabel("Amount to deposit: "));
      query4Panel.add(depositAmount);

      JPanel depositPanel = new JPanel();
      depositPanel.setLayout(new GridLayout(3, 1));
      depositPanel.add(query3Panel);
      depositPanel.add(query4Panel);

      JButton buttonPayment = new JButton("Deposit");
      buttonPayment.addActionListener(new ButtonPaymentListener());
      JPanel query5Panel = new JPanel();
      query5Panel.add(buttonPayment);

      depositPanel.add(query5Panel);
      contentPane.add(depositPanel);

      //// Withdraw part

      withdrawAccountField = new JTextField(10);
      withdrawAmount = new JTextField(10);

      JPanel query6Panel = new JPanel();
      query6Panel.add(new JLabel("Account ID to withdraw: "));
      query6Panel.add(withdrawAccountField);

      JPanel query7Panel = new JPanel();
      query7Panel.add(new JLabel("Amount to withdraw: "));
      query7Panel.add(withdrawAmount);

      JPanel withdrawPanel = new JPanel();
      withdrawPanel.setLayout(new GridLayout(3, 1));
      withdrawPanel.add(query6Panel);
      withdrawPanel.add(query7Panel);

      JButton buttonWithdraw = new JButton("Withdraw");
      buttonWithdraw.addActionListener(new ButtonWithdrawListener());
      JPanel query8Panel = new JPanel();
      query8Panel.add(buttonWithdraw);

      withdrawPanel.add(query8Panel);
      contentPane.add(withdrawPanel);



      setVisible(true);

    try {
      bm = (BankManager)Naming.lookup("rmi://localhost/BankSystem");
    } catch (MalformedURLException malformedException) {
      System.err.println("Bad URL: " + malformedException);
    } catch (NotBoundException notBoundException) {
      System.err.println("Not Bound: " + notBoundException);
    } catch (RemoteException remoteException) {
      System.err.println("Remote Exception: " + remoteException);
    }

    try {
      // Lookup account 4461
      Account account = bm.getAccount("1");



      // Get client for account
      Client client = account.getClient();
      System.out.println("Currently in the database there is this customer with ID 1:" + client.getName());

      // Get name for client
      String name = client.getName();

      // Get balance for account
      //long cash = account.getBalance();

      // Format and display output
     // NumberFormat currencyFormat =
     //   NumberFormat.getCurrencyInstance(Locale.US);
     // String balanceString = currencyFormat.format(cash);
      //System.out.println(name + "'s account has " + balanceString);

    } catch (RemoteException remoteException) {
      System.err.println(remoteException);
    }
  }


     private class WindowCloser extends WindowAdapter
   {  public void windowClosing(WindowEvent event)
      {  System.exit(0);
      }
   }

     private class ButtonPaymentListener implements ActionListener
   {  public void actionPerformed(ActionEvent event)
      {  // get user input from text area
      try{
         if(!depositAccountField.getText().equals("") && !depositAmount.getText().equals("")){
             bm.deposit(depositAccountField.getText(), Float.parseFloat(depositAmount.getText())); 
             Account account = bm.getAccount(depositAccountField.getText());
             printArea.setText("The account was credited \n as follows:" + account.getClient().getName() + "\n Balance: " + account.getBalance());
             }
             }catch (RemoteException remoteException) {
      System.err.println(remoteException);
    }
      }
     }

        private class ButtonWithdrawListener implements ActionListener
   {  public void actionPerformed(ActionEvent event)
      {  // get user input from text area
      try{
         if(!withdrawAccountField.getText().equals("") && !withdrawAmount.getText().equals("")){
             bm.withdraw(withdrawAccountField.getText(), Float.parseFloat(withdrawAmount.getText()));
             Account account = bm.getAccount(withdrawAccountField.getText());
             printArea.setText("The account was credited \n as follows:" + account.getClient().getName() + "\n Balance: " + account.getBalance());
             }
             }catch (RemoteException remoteException) {
      System.err.println(remoteException);
    }
      }
     }

    private class ButtonListener implements ActionListener
   {  public void actionPerformed(ActionEvent event)
      {  // get user input from text area
      try{
         if(!customerField.getText().equals("")){
        System.out.println("opps" + customerField.getText() + "000");
        Client client = bm.getClient(customerField.getText());
        customerField.setText("");
        System.out.println("Currently in the database "
                + "there \n is this customer with the "
                + "requested ID:" + client.getName());
        printArea.setText("Currently in the database "
                + "there \n is this customer with "
                + "the requested ID:" + client.getName());
 }else
             if(!accountField.getText().equals("")){
                Account account = bm.getAccount(accountField.getText());
                accountField.setText("");
                System.out.println("Currently in the database there is \n this account with the requested ID:" + account.getClient().getName());
                printArea.setText("Currently in the database there is \n this account with the requested ID:" + account.getClient().getName() + "\n Balance: " + account.getBalance());

             }
             }catch (RemoteException remoteException) {
      System.err.println(remoteException);
    }
      }
     }
     
  public static void main(String[] args) {
    new BankUser();
  }
}
