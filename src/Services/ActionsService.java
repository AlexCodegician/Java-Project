package Services;

import Entities.*;

public class ActionsService {
    private static AuditService audit = AuditService.getAuditService();

    public static Brand creareBrand(String name, String countryOfResidence, int netWorth){
        audit.writeAction("Creare brand");
        return new Brand(name, countryOfResidence, netWorth);
    }

    public static Product creareProduct(String name, int price, String size, int stock){
        audit.writeAction("Creare product");
        return new Product(name, price, size, stock);
    }

    public static Shop creareShop(String street, String city, String county, String postalCode, float surface){
        audit.writeAction("Creare shop");
        return new Shop(street, city, county, postalCode, surface);
    }

    public static Customer creareCustomer(String firstName, String lastName, String phoneNumber){
        audit.writeAction("Creare customer");
        return new Customer(firstName, lastName, phoneNumber);
    }

    public static Employee creareEmployee(String firstName, String lastName, int salary, String job){
        audit.writeAction("Creare employee");
        return new Employee(firstName, lastName, salary, job);
    }
}
