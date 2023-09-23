package Services;

import Entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadSingleton {
    public static ReadSingleton read;

    private ReadSingleton() {}

    public static ReadSingleton getRead() {
        if (read == null)
            read = new ReadSingleton();
        return read;
    }

    public static List<Brand> readBrands(){
        List<Brand> brands = new ArrayList<>();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\brand.csv"));
            String line = buffer.readLine();

            while (line != null) {
                String[] arg = line.split(",");
                String name = arg[0];
                String countryOfResidence = arg[1];
                int netWorth =  Integer.parseInt(arg[2]);
                Brand brand = new Brand(name, countryOfResidence, netWorth);
                brands.add(brand);
                line = buffer.readLine();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return brands;
    }

    public static List <Product> readProducts(){
        List<Product> products = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\product.csv"));
            String line = buffer.readLine();

            while(line != null) {
                String[] arg = line.split(",");
                String name = arg[0];
                int price =  Integer.parseInt(arg[1]);
                String size = arg[2];
                int stock =  Integer.parseInt(arg[3]);

                Product product = new Product(name, price, size, stock);
                products.add(product);
                line = buffer.readLine();
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        return products;
    }

    public static List <Shop> readShops(){
        List<Shop> shops = new ArrayList<>();
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\shop.csv"));
            String line = buffer.readLine();

            while(line != null) {
                String[] arg = line.split(",");
                String street = arg[0];
                String city = arg[1];
                String county = arg[2];
                String postalCode = arg[3];
                float surface = Float.parseFloat(arg[4]);

                Shop shop = new Shop(street, city, county, postalCode, surface);
                shops.add(shop);
                line = buffer.readLine();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return shops;
    }

    public static List <Customer> readCustomers(){
        List<Customer> customers = new ArrayList<>();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\customer.csv"));
            String line = buffer.readLine();

            while (line != null) {
                String[] arg = line.split(",");
                String firstName = arg[0];
                String lastName = arg[1];
                String phoneNumber = arg[2];

                Customer customer = new Customer(firstName, lastName, phoneNumber);
                customers.add(customer);
                line = buffer.readLine();
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        return customers;
    }
    public static List <Employee> readEmployees(){
        List<Employee> employees = new ArrayList<>();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\employee.csv"));
            String line = buffer.readLine();

            while (line != null) {
                String[] arg = line.split(",");
                String firstName = arg[0];
                String lastName = arg[1];
                int salary = Integer.parseInt(arg[2]);
                String job = arg[3];

                Employee employee = new Employee(firstName, lastName, salary, job);
                employees.add(employee);
                line = buffer.readLine();
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        return employees;
    }
}
