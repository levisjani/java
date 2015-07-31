package Iterator;

import BuilderPattern.*;
import FactoryMethod.*;
import java.util.HashMap;
import java.util.Iterator;


public class CollectionImpl implements Collection{
    
     HashMap<Integer,Customer> customers;
     HashMap<Integer,Reservation> reservations;       
     
     public CollectionImpl()
     {
         customers= new HashMap();
         reservations= new HashMap();
         
     }
     
     @Override
     public void addCustomer(Customer customer)
     {
         customers.put(customer.getCustomerId(),customer);
         
     }
     
     public void addReservation(Reservation reservation)
     {
         reservations.put(reservation.getReservationId(), reservation);
     }

    public HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

    public HashMap<Integer, Reservation> getReservations() {
        return reservations;
    }
    

}
