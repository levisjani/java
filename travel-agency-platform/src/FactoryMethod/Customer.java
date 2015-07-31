package FactoryMethod;

import java.io.Serializable;

public class Customer implements Serializable
{
    
    private int customerId;
    private String name;
    private String surname;
    private String age;
    private String address;
    
    public Customer(int customerId,String name, String surname, String age, String address)
    {
        this.customerId=customerId;
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.address=address;
                
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
            
    
}
