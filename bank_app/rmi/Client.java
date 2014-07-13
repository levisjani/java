import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {

  // Add method to return master BankManager
  public BankManager getBankManager()
       throws RemoteException;

  // Add method to return the name of this client
  public String getName()
       throws RemoteException;
}
    
