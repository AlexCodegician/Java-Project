package Entities;

import java.util.Comparator;
public class Product {
    private int productID;
    private String name;
    private int price;
    private String size;
    private int stock;

    public Product(int productID, String name, int price, String size, int stock){
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.size = size;
        this.stock = stock;
    }

    public Product(String name, int price, String size, int stock){
        this.name = name;
        this.price = price;
        this.size = size;
        this.stock = stock;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    public int getProductID() {
        return productID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public void setSize(String size){
        this.size = size;
    }
    public String getSize() {
        return size;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getStock() {
        return stock;
    }
}

class ProductComparator implements Comparator<Product> {
    public int compare (Product p1, Product p2){
        return p1.getPrice() - p2.getPrice();
    }
}
