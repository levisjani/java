import java.io.Serializable;
import java.rmi.RemoteException;

public class ClientImpl implements Client, Serializable {

  private BankManager bankManager;
  private String      clientName;

  // public constructor
  public ClientImpl(BankManager bm, String name) {
    this.bankManager = bm;
    this.clientName  = name;
  }

  public BankManager getBankManager() 
      throws RemoteException {
    return bankManager;
  }

  public String getName() 
      throws RemoteException {
    return clientName;
  }
}
    
