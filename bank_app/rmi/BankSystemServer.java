import java.awt.BorderLayout;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BankSystemServer extends JFrame{

    	private JPanel contentPane;
	private JButton buttonConnect;
	private JButton buttonDisconnect;
	private JLabel labelState;
	private boolean connected;
	private BankManagerImpl BM;

	//private JButton buttonExit = null;

  // public No-argument constructor
  public BankSystemServer() {

    super();
    this.setSize(302, 149);
    this.setMinimumSize(new Dimension(265, 125));
    this.setPreferredSize(new Dimension(265, 125));
    this.setResizable(false);
    contentPane = new JPanel();
    this.setContentPane(contentPane);
    this.setTitle("Bank Manager Server");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    labelState = new JLabel();
    labelState.setText("Pending to Start RMI Server...");
    buttonConnect = new JButton();
    buttonConnect.setText("Connect");
    buttonConnect.setPreferredSize(new Dimension(110, 25));
    buttonConnect.setMaximumSize(new Dimension(100, 25));
    buttonConnect.setMinimumSize(new Dimension(100, 25));
    buttonConnect.setSize(new Dimension(80, 25));
    buttonConnect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    buttonConnect_mouseClicked(e);
            }
    });
    buttonConnect.setEnabled(true);
    buttonDisconnect = new JButton();
    buttonDisconnect.setText("Disconnect");
    buttonDisconnect.setPreferredSize(new Dimension(110, 25));
    buttonDisconnect.setMaximumSize(new Dimension(100, 25));
    buttonDisconnect.setMinimumSize(new Dimension(100, 25));
    buttonDisconnect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    buttonDisconnect_mouseClicked(e);
            }
    });
		buttonDisconnect.setEnabled(false);
		contentPane.setLayout(new BorderLayout());
		contentPane.setSize(new Dimension(260, 100));
		contentPane.setPreferredSize(new Dimension(260, 100));
		contentPane.setMinimumSize(new Dimension(260, 100));
		contentPane.setMaximumSize(new Dimension(260, 100));

                JPanel panelbutton1 = new JPanel();
                panelbutton1.add(buttonConnect);

                JPanel panelbutton2 = new JPanel();
                panelbutton1.add(buttonDisconnect);

                contentPane.add(labelState,"North");
                contentPane.add(panelbutton1,"Center");
		//contentPane.add(panelbutton2,"Center");
                
                this.setVisible(true);

  }

  	public void buttonDisconnect_mouseClicked(MouseEvent e) {
		if (connected) {
			disconnectServer();
		}
	}

	public void buttonConnect_mouseClicked(MouseEvent e) {
		if (!connected) {
			connectServer();
		}
	}

   private void connectServer() {
try {
        BM = new BankManagerImpl();

        Naming.rebind("rmi://localhost/BankSystem", BM);
        connected = true;
} catch (MalformedURLException err) {
        System.out.println(err.getMessage());
        err.printStackTrace();
} catch (RemoteException err) {
        System.out.println(err.getMessage());
        err.printStackTrace();
}
if(connected) {
        buttonDisconnect.setEnabled(true);
        buttonConnect.setEnabled(false);
        labelState.setText("RMI Server started");
        System.out.println("Server Connected.");
} else {
        buttonDisconnect.setEnabled(false);
        buttonConnect.setEnabled(true);
        labelState.setText("Pending to start RMi Server...");
        System.out.println("Server Disconnected.");
}
	}

  private void disconnectServer() {
		BM = null;
		try {
			Naming.unbind("BankSystem");
			connected = false;
		} catch (RemoteException err) {
			System.out.println(err.getMessage());
			err.printStackTrace();
		} catch (NotBoundException err) {
			connected = false;
			System.out.println(err.getMessage());
			err.printStackTrace();
		} catch (MalformedURLException err) {
			System.out.println(err.getMessage());
			err.printStackTrace();
		}
		if(connected) {
			buttonDisconnect.setEnabled(true);
			buttonConnect.setEnabled(false);
			labelState.setText("RMI Server started");
			System.out.println("Server Connected.");
		} else {
			buttonDisconnect.setEnabled(false);
			buttonConnect.setEnabled(true);
			labelState.setText("Pending to start RMi Server...");
			System.out.println("Server Disconnected.");
		}
	}


  public static void main(String args[]) {
    new BankSystemServer();

//    BankManager bm = null;
//
//    try {
//      // Create a BankManager object
//      bm = new BankManagerImpl();
//
//      // Export it to RMI
//      UnicastRemoteObject.exportObject( bm );
//    } catch (RemoteException remoteException) {
//      System.err.println(
//        "Failure during object export to RMI: " +
//         remoteException);
//    }
//
//    // Register an external name for the service
//    try {
//      Naming.rebind("//localhost/BankSystem", bm);
//    } catch (RemoteException remoteException) {
//      System.err.println(
//        "Failure during Name registration: " +
//        remoteException);
//    } catch (MalformedURLException malformedException) {
//      System.err.println(
//        "Failure during Name registration: " +
//        malformedException);
//    }
//
//    System.out.println("Server started.");
//    System.out.println("Enter <CR> to end.");
//    try {
//       int i = System.in.read();
//    } catch (IOException ioException) {
//    }
//    System.exit(0);
  }
}

