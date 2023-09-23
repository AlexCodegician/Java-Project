package Services;

import Entities.Brand;
import Entities.Customer;
import Entities.Product;
import Entities.Shop;
import Entities.Employee;

import java.io.*;

public class WriteSingleton {
    public static WriteSingleton write;

    private WriteSingleton() {}

    public static WriteSingleton getWrite() {
        if (write == null)
            write = new WriteSingleton();
        return write;
    }

    public void writeBrand(Brand brand){
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\brand.csv", true)) {

            fileWriter.append(brand.getName())
                    .append(",")
                    .append(brand.getCountryOfResidence())
                    .append(",")
                    .append(Integer.toString(brand.getNetWorth()))
                    .append("\n");

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeProduct(Product product){
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\product.csv", true)) {

            fileWriter.append(product.getName())
                    .append(",")
                    .append(Integer.toString(product.getPrice()))
                    .append(",")
                    .append(product.getSize())
                    .append(",")
                    .append(Integer.toString(product.getStock()))
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeShop(Shop shop){
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\shop.csv", true)) {

            fileWriter.append(shop.getStreet())
                    .append(",")
                    .append(shop.getCity())
                    .append(",")
                    .append(shop.getCounty())
                    .append(",")
                    .append(shop.getPostalCode())
                    .append(",")
                    .append(Float.toString(shop.getSurface()))
                    .append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeCustomer(Customer customer){
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\customer.csv", true)) {

            fileWriter.append(customer.getFirstName())
                    .append(",")
                    .append(customer.getLastName())
                    .append(",")
                    .append(customer.getPhoneNumber())
                    .append("\n");

            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeEmployee(Employee employee){
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Alex\\OneDrive\\Desktop\\PAO\\Proiect-magazinArticoleSportive\\data\\employee.csv", true)) {

            fileWriter.append(employee.getFirstName())
                    .append(",")
                    .append(employee.getLastName())
                    .append(",")
                    .append(Integer.toString(employee.getSalary()))
                    .append(",")
                    .append(employee.getJob().toString())
                    .append("\n");

            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
