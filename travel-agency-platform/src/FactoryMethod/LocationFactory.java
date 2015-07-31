
package FactoryMethod;

import java.util.HashMap;

public class LocationFactory {
 
    
    public static HashMap generateLocations()
    {
       HashMap<String,Location> loc= new HashMap();
       loc.put("Viena",new Location("Viena",100));
       loc.put("Berlin",new Location("Berlin",150));
       loc.put("Paris",new Location("Paris",200));
       loc.put("Lisbon",new Location("Lisbon",300));
       loc.put("Prague",new Location("Prague",80));
       return loc;
    }
    
    
}
