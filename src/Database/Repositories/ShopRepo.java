package Database.Repositories;

import Database.Configuration.Configuration;
import Entities.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopRepo {

    private static ShopRepo shopRepo;

    private ShopRepo() {
    }

    public static ShopRepo getShopRepo() {
        if (shopRepo == null) {
            shopRepo = new ShopRepo();
        }
        return shopRepo;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS shop" +
                "(address_id int, street varchar(30), city varchar(30), county varchar(30), postal_code varchar(30), shop_id int PRIMARY KEY AUTO_INCREMENT, surface float(10) )";

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
    public void insert(int address_id, String street, String city, String county, String postal_code, float surface) {
        String insertSql = "INSERT INTO shop(address_id, street, city, county, postal_code, surface) VALUES(?, ?, ?, ?, ?, ?)";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1, address_id);
            preparedStatement.setString(2, street);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4,county);
            preparedStatement.setString(5, postal_code);
            preparedStatement.setFloat(6, surface);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public List<Shop> select() {
        String selectSql = "SELECT * FROM shop";

        Connection connection = Configuration.getConnection();

        List<Shop> shops = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                shops.add(new Shop(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getFloat(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shops;
    }

    // UPDATE
    public void update(int id, float surface) {
        String updateSql = "UPDATE shop SET surface=? WHERE shop_id=?";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setFloat(1, surface);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String deleteSql = "DELETE FROM shop WHERE shop_id=?";

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
        String deleteSql = "DELETE FROM shop";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String deleteSql = "DROP TABLE shop";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

