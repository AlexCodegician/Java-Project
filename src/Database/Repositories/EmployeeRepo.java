package Database.Repositories;


import Database.Configuration.Configuration;
import Entities.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmployeeRepo {
    private static EmployeeRepo employeeRepo;
    private EmployeeRepo (){

    }
    public static EmployeeRepo getEmployeeRepo() {
        if (employeeRepo == null){
            employeeRepo = new EmployeeRepo();
        }
        return employeeRepo;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS employee" +
                "(id int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), salary int, job varchar(30))";

        Connection connection = Configuration.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String firstName, String lastName, int salary, String job){
        String insertSql = "INSERT INTO Employee(firstName, lastName, salary, job) VALUES(?, ?, ?, ?)";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, salary);
            preparedStatement.setString(4, job);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> select() {
        String selectSql = "SELECT * FROM Employee";

        Connection connection = Configuration.getConnection();

        List<Employee> employees = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void update(String lastName, int salary) {
        String updateSql = "UPDATE employee SET salary=? WHERE lastName=?";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, salary);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String deleteSql = "DELETE FROM employee WHERE id=?";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        String deleteSql = "DELETE FROM employee";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String deleteSql = "DROP TABLE employee";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
