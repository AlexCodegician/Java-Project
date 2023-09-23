package Entities;
import java.time.LocalDate;
public class Order {
    private int id = 1;
    private Customer customer;
    private Product product;
    private LocalDate orderDate;

    public Order(Customer customer, Product product, LocalDate orderDate) {
        this.id++;
        this.customer = customer;
        this.product = product;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

}