package FactoryMethod;

import java.util.HashMap;

public class CustomerFactory {
    
    public static HashMap generateCustomers()
    {
        HashMap<Integer,Customer> cust= new HashMap();
        
        cust.put(1,new Customer(1,"Jeff","Buckley","30","Memphis"));
        cust.put(2,new Customer(2,"Thom","Yorke","50","London"));
        cust.put(3,new Customer(3,"Jack","Black","15","Toronto"));
        cust.put(4,new Customer(4,"John","Doe","27","Tirane"));
        cust.put(5,new Customer(5,"Jane","Doe","25","NY"));
        return cust;
    }
    
}
