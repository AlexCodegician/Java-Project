package Entities;

public class Address {
    protected int addressID;
    protected String street;
    protected String city;
    protected String county;
    protected String postalCode;

    public Address(int addressID, String street, String city, String county, String postalCode){
        this.addressID = addressID;
        this.street = street;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
    }

    public Address(String street, String city, String county, String postalCode){
        this.street = street;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
    }

    public void setAddressID(int addressID){
        this.addressID = addressID;
    }
    public int getAddressID(){
        return addressID;
    }

    public void setStreet(String street){
        this.street = street;
    }
    public String getStreet(){
        return street;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return city;
    }

    public void setCounty(String county){
        this.county = county;
    }
    public String getCounty(){
        return county;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    public String getPostalCode(){
        return postalCode;
    }
}
