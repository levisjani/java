package BuilderPattern;

import java.util.Date;

public abstract class AbstractBuilder {
    
    protected int customerId;
    protected String destination;
    protected Date departDate;
    protected Date returnDate;
    protected Double totalSum;
    protected boolean statusPayment;

    public boolean getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(boolean statusPayment) {
        this.statusPayment = statusPayment;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }
    
    public abstract boolean checkValidation() throws ProjectException;
    public abstract Reservation createReservation();


        
}
