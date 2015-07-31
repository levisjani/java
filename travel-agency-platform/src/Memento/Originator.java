package Memento;

import BuilderPattern.Reservation;
import FactoryMethod.Customer;
import java.io.*;

public class Originator {
     
    private Customer customer;
    private Reservation reservation;

    
    public Originator(){

	}

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public Reservation getReservation() {
        return this.reservation;
    }

    
    public void saveFileMemento(File f)
    {
        try
        {
            Memento memento = new Memento(customer,reservation);

            if (!f.exists()) 
            {
              f.createNewFile();                 
            } 
            try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(f))) {
                outStream.writeObject(memento);
                outStream.flush();
            }
        }
        catch (IOException e)
        {
        }

    }
    
    public Memento createNewMemento(){
        
      return new Memento(customer,reservation);

    }


    public void loadMemento(File f) throws FileNotFoundException
    {
    try
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));
            Memento memento = (Memento)input.readObject();
            this.customer = memento.customer;
            this.reservation = memento.reservation;
        }
        catch(IOException | ClassNotFoundException ex)
        {
        }

    }    
}
