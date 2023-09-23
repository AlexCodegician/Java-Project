package Entities;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private int salary;
    private String job;

    public Employee(int employeeID, String firstName, String lastName, int salary, String job){
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.job = job;
    }

    public Employee(String firstName, String lastName, int salary, String job){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.job = job;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public int getEmployeeID() {
        return employeeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getSalary() {
        return salary;
    }

    public void setJob(String hireDate) {
        this.job = job;
    }
    public String getJob() {
        return job;
    }

    public static void displayAllEmployees(Employee[] employees) {
        for(Employee employee : employees){
            System.out.println("Employee ID: " + employee.getEmployeeID());
            System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("job: " + employee.getJob());
            System.out.println("--------------------------------------------");
        }
    }
}

