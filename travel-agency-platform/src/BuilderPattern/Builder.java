package BuilderPattern;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import FactoryMethod.*;
import java.text.DateFormat;
import java.text.ParseException;

public class Builder extends AbstractBuilder{
    
    @Override
    
    public Reservation createReservation()
    {
        return new Reservation(customerId, destination, departDate, returnDate, totalSum, statusPayment);
    }
    
    @Override
    public boolean checkValidation() throws ProjectException
    {
        Customer cus= TravelAgencyMain.getCustomerbyId(this.customerId);
        
        if(!validateAlphabetic(cus.getName()) && !validateAlphabetic(cus.getSurname()))
        {
            throw new ProjectException("Name or Surname Invalid");
        }
        if (!validateAddress(cus.getAddress()))
            throw new ProjectException("Address Invalid");
        
        if (!validateAge(cus.getAge()))
        {
            throw new ProjectException("Age must be a positive number less than 100");
        }
        
        if (!validateJourneyLength(returnDate, departDate))
        {
            throw new ProjectException("Journey Length must be more than two days");
        }
     
        return true;
    }
    
    public boolean validateAlphabetic(String variable)
    {
         char[] characters = variable.toCharArray();

         for (char ch : characters) 
        {

                if(!Character.isLetter(ch)) {
                   return false;
                }
        }

        return true;
    }
    
    public boolean validateAge(String age)
    {
        if (!(Integer.parseInt(age)>0 && Integer.parseInt(age)<100 ))
        {
           return false; 
        }
        return true;
    }
    
    public boolean validateAddress(String address)
    {
        char[] characters = address.toCharArray();

         for (char ch : characters) 
        {

                if(!Character.isLetterOrDigit(ch)) {
                   return false;
                }
        }

        return true;
    }
    
    public boolean validateJourneyLength(Date dt1, Date dt2)
    {
        
        long difference=TimeUnit.MILLISECONDS.toDays(dt1.getTime()) - TimeUnit.MILLISECONDS.toDays(dt2.getTime());
        
        if ((int)difference<=2)
        {
            return false;
        }
        return true;
    }
    
    
}
