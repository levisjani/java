package Memento;

import BuilderPattern.Reservation;
import FactoryMethod.Customer;
import java.io.Serializable;

public class Memento implements Serializable{

Reservation reservation;
Customer customer;
         
public Memento(Customer customer, Reservation reservation)
   {
    this.customer = customer;
    this.reservation = reservation;           
   }

}
    

