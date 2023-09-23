package Database.Repositories;

import Database.Configuration.Configuration;
import Entities.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandRepo {
    private static BrandRepo brandRepo;

    private BrandRepo() {

    }

    public static BrandRepo getBrandRepo() {
        if (brandRepo == null) {
            brandRepo = new BrandRepo();
        }
        return brandRepo;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS brand" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), countryOfResidence varchar(30), netWorth int )";

        Connection connection = Configuration.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String name, String countryOfResidence, int netWorth){
        String insertSql = "INSERT INTO Brand(name, countryOfResidence, netWorth) VALUES(?, ?, ?)";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, countryOfResidence);
            preparedStatement.setInt(3, netWorth);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Brand> select() {
        String selectSql = "SELECT * FROM brand";

        Connection connection = Configuration.getConnection();

        List<Brand> brands = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                brands.add(new Brand(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return brands;
    }

    public void update(String name, int netWorth) {
        String updateSql = "UPDATE brand SET netWorth=? WHERE name=?";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, netWorth);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String deleteSql = "DELETE FROM brand WHERE id=?";

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
        String deleteSql = "DELETE FROM brand";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        String deleteSql = "DROP TABLE brand";

        Connection connection = Configuration.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
