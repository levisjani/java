package FactoryMethod;

import BuilderPattern.Reservation;
import Interface.ReservationInterface;
import Iterator.Collection;
import Iterator.CollectionImpl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TravelAgencyMain {
    private static HashMap<Integer,Customer> customers = new HashMap();
    private static HashMap<String,Location> locations = new HashMap();
    static Collection collections;
    public static void main(String[] args){
        
        customers=CustomerFactory.generateCustomers();     
        locations=LocationFactory.generateLocations();
        
        ReservationInterface reservationInt= ReservationInterface.getInstance();
        reservationInt.setVisible(true);
    }
    
    
    
    public static Customer getCustomerbyId(int id)
    {
        if (customers.containsKey(id))
        {
            return customers.get(id);
            
        }
        else
            return null;        
    }
        
    public static Location getLocationbyName(String name)
    {
        if (locations.containsKey(name))
        {
            return locations.get(name);
            
        }
        else
            return null;        
    }
    
    
    
    public static Iterator getCustomerIterator()
    {
        return customers.values().iterator();

    }
    
    public static void createCustomer(Integer id, Customer cus)
    {
        customers.put(id,cus);
    }
    
    
    public static Iterator getLocationIterator()
    {
        return locations.values().iterator();

    }
    
    
    public static Iterator getCustomerIterator(Collection collections)
    {
        return collections.getCustomers().values().iterator();

    }

    public static Collection getCollections() {
        return collections;
    }

    public static void setCollections(Collection collections) {
        TravelAgencyMain.collections = collections;
    }
    
    public static Iterator getReservationIterator(Collection collections)
    {
        return collections.getReservations().values().iterator();

    }
    

    public static Collection populateCollections()
    {
        DateFormat sdf= new SimpleDateFormat("yyy-MM-dd");
        Collection collections= new CollectionImpl();
        
        collections.addCustomer(new Customer(1,"Jeff","Buckley","30","Memphis"));
        collections.addCustomer(new Customer(2,"Thom","Yorke","50","London"));
        collections.addCustomer(new Customer(3,"Jack","Black","15","Toronto"));
        collections.addCustomer(new Customer(4,"John","Doe","27","Tirane"));
        collections.addCustomer(new Customer(5,"Jane","Doe","25","NY"));
        try
        {
        collections.addReservation(new Reservation(1,"Viena",(Date)sdf.parse("2013-12-12"),sdf.parse("2013-12-20"),100,true));
        collections.addReservation(new Reservation(1,"Paris",(Date)sdf.parse("2013-06-12"),sdf.parse("2013-06-20"),200,true));
        collections.addReservation(new Reservation(1,"Lisbon",(Date)sdf.parse("2012-08-12"),sdf.parse("2012-08-20"),300,true));
        collections.addReservation(new Reservation(1,"Berlin",(Date)sdf.parse("2010-12-12"),sdf.parse("2010-12-20"),300,true));
        collections.addReservation(new Reservation(1,"London",sdf.parse("2013-11-12"),sdf.parse("2013-11-20"),400,true));
        collections.addReservation(new Reservation(1,"Paris",(Date)sdf.parse("2010-11-12"),sdf.parse("2010-11-20"),400,true));
        collections.addReservation(new Reservation(1,"Paris",(Date)sdf.parse("2013-01-12"),sdf.parse("2013-01-20"),400,true));
        collections.addReservation(new Reservation(2,"Viena",(Date)sdf.parse("2013-12-10"),sdf.parse("2013-12-20"),200,true));
        collections.addReservation(new Reservation(2,"Paris",(Date)sdf.parse("2013-06-12"),sdf.parse("2013-06-20"),200,true));
        collections.addReservation(new Reservation(2,"Paris",(Date)sdf.parse("2012-08-12"),sdf.parse("2012-08-25"),500,true));
        collections.addReservation(new Reservation(2,"Berlin",(Date)sdf.parse("2010-12-12"),sdf.parse("2010-12-20"),300,true));
        collections.addReservation(new Reservation(2,"London",(Date)sdf.parse("2013-11-12"),sdf.parse("2013-11-20"),400,true));
        collections.addReservation(new Reservation(2,"Paris",(Date)sdf.parse("2010-11-12"),sdf.parse("2010-11-28"),600,true));
        
        
        collections.addReservation(new Reservation(3,"Viena",(Date)sdf.parse("2013-11-10"),sdf.parse("2013-12-20"),1200,true));
        collections.addReservation(new Reservation(3,"Paris",(Date)sdf.parse("2013-06-12"),sdf.parse("2013-06-20"),200,true));
        collections.addReservation(new Reservation(3,"Paris",(Date)sdf.parse("2012-08-12"),sdf.parse("2012-08-25"),1500,true));
        collections.addReservation(new Reservation(3,"Berlin",(Date)sdf.parse("2010-11-12"),sdf.parse("2010-12-20"),300,true));
        collections.addReservation(new Reservation(3,"London",(Date)sdf.parse("2013-11-12"),sdf.parse("2013-11-20"),400,true));
        collections.addReservation(new Reservation(3,"Paris",(Date)sdf.parse("2010-11-12"),sdf.parse("2010-11-28"),1600,true));
        collections.addReservation(new Reservation(3,"Paris",(Date)sdf.parse("2013-01-12"),sdf.parse("2013-01-20"),400,true));
        
        collections.addReservation(new Reservation(4,"Viena",(Date)sdf.parse("2013-11-10"),sdf.parse("2013-11-20"),200,true));
        collections.addReservation(new Reservation(4,"Paris",(Date)sdf.parse("2013-06-12"),sdf.parse("2013-06-20"),200,true));
        collections.addReservation(new Reservation(4,"Paris",(Date)sdf.parse("2012-08-12"),sdf.parse("2012-08-25"),700,true));
        collections.addReservation(new Reservation(4,"Berlin",(Date)sdf.parse("2010-11-12"),sdf.parse("2010-12-20"),300,true));
        collections.addReservation(new Reservation(4,"London",(Date)sdf.parse("2013-11-12"),sdf.parse("2013-11-20"),400,true));
        collections.addReservation(new Reservation(4,"Paris",(Date)sdf.parse("2010-11-12"),sdf.parse("2010-11-28"),1600,true));
        collections.addReservation(new Reservation(4,"Berlin",(Date)sdf.parse("2013-01-12"),sdf.parse("2013-01-20"),400,true));
        collections.addReservation(new Reservation(4,"Prague",(Date)sdf.parse("2013-02-12"),sdf.parse("2013-02-20"),600,true));
        
        collections.addReservation(new Reservation(5,"Viena",(Date)sdf.parse("2013-11-01"),sdf.parse("2013-11-20"),2200,true));
        collections.addReservation(new Reservation(5,"Paris",(Date)sdf.parse("2013-06-12"),sdf.parse("2013-06-20"),200,true));
        collections.addReservation(new Reservation(5,"Paris",(Date)sdf.parse("2012-08-12"),sdf.parse("2012-08-25"),700,true));
        collections.addReservation(new Reservation(5,"Berlin",(Date)sdf.parse("2010-08-12"),sdf.parse("2010-08-20"),900,true));
        collections.addReservation(new Reservation(5,"London",(Date)sdf.parse("2013-11-12"),sdf.parse("2013-11-20"),400,true));
        collections.addReservation(new Reservation(5,"Paris",(Date)sdf.parse("2010-11-12"),sdf.parse("2010-11-28"),1600,true));
        collections.addReservation(new Reservation(5,"Viena",(Date)sdf.parse("2013-01-12"),sdf.parse("2013-01-20"),400,true));
        }
        catch
                (ParseException ex){};
        return collections;
    }
    
    
    public HashMap<String,Integer> getFrequencies(Collection collections) {
        
    HashMap<String, Integer> frequencies = new HashMap();
    Iterator reservationIterator = TravelAgencyMain.getReservationIterator(collections);
    while(reservationIterator.hasNext())
            {
                Reservation res=(Reservation)reservationIterator.next();
                int count;            
                if(frequencies.containsKey(res.getDestination())) {
                    count = frequencies.get(res.getDestination());
                } else 
                {
                   count = 0;
                }
                 frequencies.put(res.getDestination(),count+1);  
            }
    
    return frequencies;

}
    
    public Map.Entry<String,Integer> getPreferredDestination(HashMap<String,Integer> frequencies)
    {
       
        
        Map.Entry<String,Integer> mostFrequent = null;

        for(Map.Entry<String,Integer> entry : frequencies.entrySet()) {
            if (mostFrequent == null || entry.getValue() > mostFrequent.getValue()) {
            mostFrequent = entry;
        }
        }      
        return mostFrequent;
    }
    
    
    public HashMap<Integer,Double> getClientFrequencies(Collection collections) {
        
    HashMap<Integer, Double> frequencies = new HashMap();
    Iterator reservationIterator = TravelAgencyMain.getReservationIterator(collections);
                    
    while(reservationIterator.hasNext())
            {
                double totalSum;
                Reservation res=(Reservation)reservationIterator.next();
           
                if(frequencies.containsKey(res.getCustId())) {
                    totalSum = res.getTotalSum()+frequencies.get(res.getCustId());
                } else 
                {
                   totalSum = res.getTotalSum();
                }
                 frequencies.put(res.getCustId(),totalSum);  
            }
    
    return frequencies;

    }   
    
    public Map.Entry<Integer,Double> getBestClient(HashMap<Integer,Double> frequencies)
    {
    
        
        Map.Entry<Integer,Double> mostFrequent = null;

        for(Map.Entry<Integer,Double> entry : frequencies.entrySet()) {
            if (mostFrequent == null || entry.getValue() > mostFrequent.getValue()) {
            mostFrequent = entry;
        }
        }      
        return mostFrequent;
    }
    
    
}
