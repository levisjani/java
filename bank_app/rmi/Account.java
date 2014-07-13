import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Account extends Remote {
  // Add method to return master BankManager
  public BankManager getBankManager()
       throws RemoteException;

  // Add method to return Client of this account
  public Client getClient()
       throws RemoteException;

  // Add method to return balance of this account
  public float getBalance()
       throws RemoteException;

    // Add method to return balance of this account
  public void setBalance(float bal)
       throws RemoteException;

  // Add method to withdraw cash from this account
  public long getCash (long amount)
       throws NoCashAvailableException, RemoteException;

  public void deposit(float amount)
    throws RemoteException;

    public void withdraw(float amount)
    throws RemoteException;
}

