package Iterator;

import BuilderPattern.Reservation;
import FactoryMethod.Customer;
import java.util.HashMap;

public interface Collection {
    
    public void addCustomer(Customer customer);
    public void addReservation(Reservation reservation);    
    public HashMap<Integer,Customer> getCustomers();
    public HashMap<Integer,Reservation> getReservations();
}
