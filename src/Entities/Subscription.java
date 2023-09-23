package Entities;
import java.time.LocalDate;
public class Subscription extends Customer {
    private int subscriptionId;
    private LocalDate expiryDate;

    public Subscription(int customerID, String firstName, String lastName, String phoneNumber, int subscriptionId, LocalDate expiryDate){
        super(customerID, firstName, lastName, phoneNumber);
        this.subscriptionId = subscriptionId;
        this.expiryDate = expiryDate;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    public int getSubscriptionId() {return subscriptionId;}

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    public LocalDate getExpiryDate() {return expiryDate;}
}
