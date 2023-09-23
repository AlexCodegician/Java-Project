package Entities;

public class Customer {
    protected int customerID;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;

    /*public Customer() {
    }*/

    public Customer(int customerID, String firstName, String lastName, String phoneNumber){
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void setCustomerID (int customerID) {
        this.customerID = customerID;
    }
    public int getCustomerID () {
        return customerID;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
