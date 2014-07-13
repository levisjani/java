import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BankManager extends Remote {

  // Add method to return an Account service
  public Account getAccount(String accountNumber)
       throws RemoteException;

  // Add method to return a Client service
  public Client getClient(String clientName)
       throws RemoteException;

  //public int getCustomerId(int accountId)
  //   throws RemoteException;

  public void deposit(String idAccount, float Amount)
         throws RemoteException;

  public void withdraw(String idAccount, float Amount)
         throws RemoteException;
}
