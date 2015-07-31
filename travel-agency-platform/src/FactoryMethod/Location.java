package FactoryMethod;

public class Location {
 
    private String destinationCity;
    private double priceNight;
    
    
    public Location(String destination, double priceNight)
    {
        this.destinationCity=destination;
        this.priceNight=priceNight;
    }
    

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public double getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(double priceNight) {
        this.priceNight = priceNight;
    }
     
    
}
