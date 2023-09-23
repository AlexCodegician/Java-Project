package Entities;

import java.util.ArrayList;
import java.util.Collections;

public class Shop extends Address{
    private int shopID;
    private float surface;
    private ArrayList <Employee>[] employees = new ArrayList[10];
    private ArrayList <Product>[] products = new ArrayList[10];

    public Shop(int addressID, String street, String city, String county, String postalCode, int shopID, float surface){
        super(addressID, street, city, county, postalCode);
        this.shopID = shopID;
        this.surface = surface;
        for(int i = 0; i < 10; i++){
            employees[i] = new ArrayList<Employee>();
        }
        for (int i = 0; i < 10; i++)
        {
            products[i] = new ArrayList<Product>();
        }
    }

    public Shop(String street, String city, String county, String postalCode, float surface){
        super(street, city, county, postalCode);
        this.surface = surface;
        for(int i = 0; i < 10; i++){
            employees[i] = new ArrayList<Employee>();
        }
        for (int i = 0; i < 10; i++)
        {
            products[i] = new ArrayList<Product>();
        }
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }
    public int getShopID() {return shopID;}

    public void setSurface(float surface) {
        this.surface = surface;
    }
    public float getSurface() {return surface;}

    public ArrayList<Employee>[] getEmployees() {return employees;}

    public ArrayList<Product>[] getProducts() {return products;}

    public void sortProductsByPrice(){
        for (int i=0; i<10; i++){
            Collections.sort(products[i], new ProductComparator());
        }
    }

    public Product returnProduct(String name){
        for (int i=0; i<10; i++)
        {
            for (int j=0; j<products[i].size(); j++){
                Product product = products[i].get(j);
                if(product.getName().equalsIgnoreCase(name)){
                    return new Product(product.getProductID(), product.getName(), product.getPrice(), product.getSize(), product.getStock());
                }
            }
        }
        return new Product(1,"Tricou Nike Alb", 100, "M", 10 );
    }
}
