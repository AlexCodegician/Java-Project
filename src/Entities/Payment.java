package Entities;

import java.util.HashMap;

public class Payment {
    private int paymentID = 1;
    private HashMap <Order, Integer> orders;
    private String paymentMethod;
    private String bankName;

    public Payment(String paymentMethod, String bankName){
        this.paymentID ++;
        this.paymentMethod = paymentMethod;
        this.bankName = bankName;
        this.orders = new HashMap<Order, Integer>();
    }

    public int getPaymentID() {
        return paymentID;
    }

    public HashMap<Order, Integer> getOrders() {return orders;}

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankName() {
        return bankName;
    }
}
