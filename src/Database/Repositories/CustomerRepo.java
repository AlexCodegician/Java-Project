package Database.Repositories;

import Database.Configuration.Configuration;
import Entities.Brand;
import Entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private static CustomerRepo customerRepo;

    private CustomerRepo() {

    }

    public static CustomerRepo getCustomerRepo() {
        if (customerRepo == null) {
            customerRepo = new CustomerRepo();
        }
        return customerRepo;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS customer" +
                "(id int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), phoneNumber varchar(30) )";

        Connection connection = Configuration.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String firstName, String lastName, String phoneNumber){
        String insertSql = "INSERT INTO Customer(firstName, lastName, phoneNumber) VALUES(?, ?, ?)";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> select() {
        String selectSql = "SELECT * FROM customer";

        Connection connection = Configuration.getConnection();

        List<Customer> customers = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public void update(String phoneNumber, int id) {
        String updateSql = "UPDATE customer SET phoneNumber=? WHERE id=?";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String deleteSql = "DELETE FROM customer WHERE id=?";

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
        String deleteSql = "DELETE FROM customer";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String deleteSql = "DROP TABLE customer";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
