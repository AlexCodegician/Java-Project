package Services;

import Entities.*;

import java.util.ArrayList;
import java.util.HashMap;
public class Service {
    public void addProduct(Shop s, Product p){
        ArrayList<Product>[] products = s.getProducts();
        products[p.getProductID()].add(p);
    }

    public void removeProduct(Shop s, Product p){
        ArrayList<Product>[] products = s.getProducts();
        products[p.getProductID()].remove(p);
    }

    public void showProducts(Shop s){
        ArrayList<Product>[] products = s.getProducts();
        for (int i=0; i < 10; i++)
        {
            for (int j = 0; j < products[i].size(); j++)
            {
                Product p = products[i].get(j);
                System.out.println(p.getName());
            }
        }
    }
    public double increaseSalary(Employee e){
        int Salary = e.getSalary();
        int newSalary = Salary + 500;
        e.setSalary(newSalary);
        return newSalary;
    }

    public static void displayAllShops(Shop[] shops){
        for(Shop shop : shops){
            System.out.println("Shop ID: " + shop.getShopID());
            System.out.println("Address: " + shop.getStreet() + ", " + shop.getCity() + ", " + shop.getCounty() + ", " + shop.getPostalCode());
            System.out.println("Surface: " + shop.getSurface());
            System.out.println("--------------------------------------------");
        }
    }

    public void placeOrder(Payment pay, Order o){
        HashMap <Order, Integer> ord = pay.getOrders();
        if (ord == null) {
            ord = new HashMap<>();
        }
        int quantity = 1;
        ord.put(o, quantity);
    }

    public void displayOrders(Payment pay){
        HashMap <Order, Integer> ord = pay.getOrders();
        for (Order o : ord.keySet()){
            System.out.println("Id: " + o.getId() + "Customer: " + o.getCustomer() + "Product: " + o.getProduct());
        }
    }

    public void removeOrder(Payment pay, Order o) {
        HashMap <Order, Integer> ord = pay.getOrders();
        ord.remove(o);
    }

    public void addEmployee(Shop s, Employee emp){
        ArrayList <Employee>[] employees = s.getEmployees();
        employees[emp.getEmployeeID()].add(emp);
    }
    public void removeEmployee(Shop s, Employee emp){
        ArrayList <Employee>[] employees = s.getEmployees();
        employees[emp.getEmployeeID()].remove(emp);
    }

    public void showEmployees(Shop s){
        ArrayList<Employee>[] employees = s.getEmployees();
        for (int i=0; i < 10; i++)
        {
            for (int j = 0; j < employees[i].size(); j++)
            {
                Employee emp = employees[i].get(j);
                System.out.println(emp.getEmployeeID() + " " + emp.getFirstName() + " " + emp.getLastName());
            }
        }
    }

}








