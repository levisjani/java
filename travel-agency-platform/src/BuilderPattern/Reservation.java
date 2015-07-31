package BuilderPattern;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable{
    
    private int reservationId;
    static private int lastReservationId;
    private int custId;
    private String destination;
    private Date departDate;
    private Date returnDate;
    private double totalSum;
    private boolean statusPayment;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId() {
        this.reservationId = lastReservationId+1;
        this.lastReservationId=this.reservationId;
    }

    public int getLastReservationId() {
        return lastReservationId;
    }

    public void setLastReservationId(int lastReservationId) {
        this.lastReservationId = lastReservationId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public boolean isStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(boolean statusPayment) {
        this.statusPayment = statusPayment;
    }
    
    
    public Reservation(int customerId, String destination, Date depart, Date returnDate, double totalSum, boolean statusPayment)
    {
        this.setReservationId();
        this.custId=customerId;
        this.destination=destination;
        this.departDate=depart;
        this.returnDate=returnDate;
        this.totalSum=totalSum;   
        this.statusPayment=statusPayment;
        
    }
    
}
