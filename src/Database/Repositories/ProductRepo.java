package Database.Repositories;

import Database.Configuration.Configuration;
import Entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    private static ProductRepo productRepo;

    private ProductRepo() {
    }

    public static ProductRepo getProductRepo() {
        if (productRepo == null) {
            productRepo = new ProductRepo();
        }
        return productRepo;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS product" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), price int, size varchar(30), stock int)";

        Connection connection = Configuration.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //CREATE - INSERT, READ - SELECT, UPDATE, DELETE

    //INSERT
    public void insert(String name, int price, String size, int stock) {
        String insertSql = "INSERT INTO product(name, price, size, stock) VALUES(?, ?, ?, ?)";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3,size);
            preparedStatement.setInt(4, stock);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public List<Product> select() {
        String selectSql = "SELECT * FROM product";

        Connection connection = Configuration.getConnection();

        List<Product> products = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()){
                products.add(new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // UPDATE
    public void update(int id, int price) {
        String updateSql = "UPDATE product SET price=? WHERE id=?";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String deleteSql = "DELETE FROM product WHERE id=?";

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
        String deleteSql = "DELETE FROM product";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String deleteSql = "DROP TABLE product";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

