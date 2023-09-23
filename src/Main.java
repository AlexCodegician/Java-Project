import Entities.*;
import Services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Database.Repositories.*;

public class Main {
    public static void main(String[] args) {

        WriteSingleton write = WriteSingleton.getWrite();
        ReadSingleton read = ReadSingleton.getRead();
        AuditService audit = AuditService.getAuditService();


        BrandRepo brandRepo = BrandRepo.getBrandRepo();
        brandRepo.createTable();

        CustomerRepo customerRepo = CustomerRepo.getCustomerRepo();
        customerRepo.createTable();

        ProductRepo productRepo = ProductRepo.getProductRepo();
        productRepo.createTable();

        ShopRepo shopRepo = ShopRepo.getShopRepo();
        shopRepo.createTable();

        EmployeeRepo employeeRepo = EmployeeRepo.getEmployeeRepo();
        employeeRepo.createTable();


        Scanner scanner = new Scanner(System.in);

        System.out.println("Bine ati venit la magazinul nostru!");

        Service service = new Service();

        List<Order> orders = new ArrayList<>();

        String raspuns;

        while (true) {
            System.out.println();
            System.out.println("Alegeti o optiune:");
            System.out.println("1. Adaugare produs");
            System.out.println("2. Afisare produse");
            System.out.println("3. Adaugare brand");
            System.out.println("4. Afisare branduri");
            System.out.println("5. Adaugare client");
            System.out.println("6. Afisare clienti");
            System.out.println("7. Adaugare magazin");
            System.out.println("8. Afisare magazine");
            System.out.println("9. Adaugare angajat");
            System.out.println("10. Afisare angajati");
            System.out.println("11. Plasare comanda");
            System.out.println("12. Afisare comenzi");
            System.out.println("X. Iesire");

            raspuns = scanner.nextLine();
            if (raspuns.equals("1")) {
                System.out.println("Introduceti numele produsului: ");
                String nume = scanner.nextLine();
                System.out.println("Introduceti pretul produsului: ");
                Integer pret = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduceti marimea produsului: ");
                String marime = scanner.nextLine();
                System.out.println("Introduceti capacitatea stocului a produsului: ");
                Integer stoc = scanner.nextInt();
                productRepo.insert(nume, pret, marime, stoc);
                Product p = ActionsService.creareProduct(nume, pret, marime, stoc);
                write.writeProduct(p);
            } else if (raspuns.equals("2")) {
                for (Product p : ReadSingleton.readProducts())
                    System.out.println(p.getName() + " ");
            } else if (raspuns.equals("3")) {
                System.out.println("Introduceti numele brandului: ");
                String nume = scanner.nextLine();
                System.out.println("Introduceti tara de origine a brandului: ");
                String taraOrigine = scanner.nextLine();
                System.out.println("Introduceti cifra de afacere a brandului: ");
                Integer cifraAfaceri = scanner.nextInt();
                scanner.nextLine();
                brandRepo.insert(nume, taraOrigine, cifraAfaceri);
                Brand b = ActionsService.creareBrand(nume, taraOrigine, cifraAfaceri);
                write.writeBrand(b);
            } else if (raspuns.equals("4")) {
                for (Brand b : ReadSingleton.readBrands())
                    System.out.println(b.getName() + " ");
            } else if (raspuns.equals("5")) {
                System.out.println("Introduceti prenumele clientului: ");
                String prenume = scanner.nextLine();
                System.out.println("Introduceti numele clientului: ");
                String nume = scanner.nextLine();
                System.out.println("Introduceti nr. de telefon: ");
                String nr_de_telefon = scanner.nextLine();
                customerRepo.insert(prenume, nume, nr_de_telefon);
                Customer c = ActionsService.creareCustomer(prenume, nume, nr_de_telefon);
                write.writeCustomer(c);
            } else if (raspuns.equals("6")) {
                for (Customer c : ReadSingleton.readCustomers())
                    System.out.println(c.getFirstName() + " " + c.getLastName());
            } else if (raspuns.equals("7")) {
                System.out.println("Introduceti codul magazinului: ");
                Integer cod = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduceti strada magazinului: ");
                String strada = scanner.nextLine();
                System.out.println("Introduceti orasul magazinului: ");
                String oras = scanner.nextLine();
                System.out.println("Introduceti judetul magazinului: ");
                String judet = scanner.nextLine();
                System.out.println("Introduceti codul postal al magazinului: ");
                String codPostal = scanner.nextLine();
                System.out.println("Introduceti suprafata magazinului: ");
                Float suprafata = scanner.nextFloat();
                scanner.nextLine();
                shopRepo.insert(cod, strada, oras, judet, codPostal, suprafata);
                Shop s = ActionsService.creareShop(strada, oras, judet, codPostal, suprafata);
                write.writeShop(s);
            } else if (raspuns.equals("8")) {
                for (Shop s : ReadSingleton.readShops())
                    System.out.println(s.getStreet() + " " + s.getCity());
            } else if (raspuns.equals("9")) {
                System.out.println("Introduceti prenumele angajatului: ");
                String prenume = scanner.nextLine();
                System.out.println("Introduceti numele angajatului: ");
                String nume = scanner.nextLine();
                System.out.println("Introduceti salariul angajatului: ");
                Integer salariu = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduceti functia angajatului: ");
                String functie = scanner.nextLine();
                employeeRepo.insert(prenume, nume, salariu, functie);
                Employee emp = ActionsService.creareEmployee(prenume, nume, salariu, functie);
                write.writeEmployee(emp);
            } else if (raspuns.equals("10")) {
                for (Employee emp : ReadSingleton.readEmployees())
                    System.out.println(emp.getFirstName() + " " + emp.getLastName());
            } else if (raspuns.equals("11")) {
                List<Customer> clienti = read.readCustomers();
                List<Product> produse = read.readProducts();
                System.out.println("Introduceti indexul clientului care face comanda: ");
                Integer indexClient = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduceti indexul produsului pe care il comanda clientul: ");
                Integer indexProdus = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduceti ziua comenzii: ");
                Integer zi = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduceti luna comenzii: ");
                Integer luna = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduceti anul comenzii: ");
                Integer an = scanner.nextInt();
                scanner.nextLine();
                Order o = new Order(clienti.get(indexClient), produse.get(indexProdus), LocalDate.of(an, luna, zi));
                orders.add(o);
            } else if (raspuns.equals("12")) {
                for (Order ord : orders)
                    System.out.println(ord.getCustomer().getLastName() + " " + ord.getProduct().getName());
            } else if (raspuns.equals("X")) {
                System.out.println("La revedere !");
                break;
            }
        }
    }
}
