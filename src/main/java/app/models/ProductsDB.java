package app.models;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.entities.Product;

public class ProductsDB {

    static String url = "jdbc:mysql://localhost/products?useSSL=true";
    static String user = "kergma";
    static String password = "P@ssw0rd";

    public static Connection getConnectionDB() throws SQLException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, SecurityException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructors()[0].newInstance();
        return DriverManager.getConnection(url, user, password);
    }

    public static ArrayList<Product> select() {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM prods";

        try (Connection connection = getConnectionDB()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getNString(2);
                int price = resultSet.getInt(3);
                products.add(new Product(id, name, price));
                System.err.println("add product");
            }
        } catch (Exception e) {
            System.err.println("Error connect to db:\n" + e.getMessage());
            System.err.println(e.getStackTrace().toString());
        }
        return products;
    }

    public static Product select(int id) {
        Product product = null;
        String sql = "SELECT * FROM prods WHERE id=? ";

        try (Connection connection = getConnectionDB()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int _id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    product = new Product(_id, name, price);
                }
            } catch (Exception e) {
                System.err.println("Error connect to db:\n" + e.getMessage());
                System.err.println(e.getStackTrace().toString());
            }
        } catch (Exception e) {
            System.err.println("Error connect to db:\n" + e.getMessage());
            System.err.println(e.getStackTrace().toString());
        }
        return product;
    }

    public static int update(Product product) {

        String sql = "UPDATE prods SET name=?, price=? WHERE id=? ";
        int result = -1;
        try (Connection connection = getConnectionDB()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, product.getName());
                statement.setInt(2, product.getPrice());
                statement.setInt(3, product.getId());
                result = statement.executeUpdate();
                System.err.println("Update record");
            } catch (Exception e) {
                System.err.println("Error connect to db:\n" + e.getMessage());
                System.err.println(e.getStackTrace().toString());
            }
        } catch (Exception e) {
            System.err.println("Error connect to db:\n" + e.getMessage());
            System.err.println(e.getStackTrace().toString());
        }
        return result;
    }

    // !
    public static int insert(Product product) {

        String sql = "INSERT INTO prods (name, price) VALUES (?, ?) ";
        int result = -1;
        try (Connection connection = getConnectionDB()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, product.getName());
                statement.setInt(2, product.getPrice());
                result = statement.executeUpdate();
                System.err.println("Insert record");
            } catch (Exception e) {
                System.err.println("Error connect to db:\n" + e.getMessage());
                System.err.println(e.getStackTrace().toString());
            }
        } catch (Exception e) {
            System.err.println("Error connect to db:\n" + e.getMessage());
            System.err.println(e.getStackTrace().toString());
        }
        return result;
    }

    // !
    // ?
    public static int delete(Product product) {

        String sql = "DELETE FROM prods WHERE id=?";
        int result = -1;
        try (Connection connection = getConnectionDB()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, product.getId());
                result = statement.executeUpdate();
                System.err.println("Delete record");
            } catch (Exception e) {
                System.err.println("Error connect to db:\n" + e.getMessage());
                System.err.println(e.getStackTrace().toString());
            }
        } catch (Exception e) {
            System.err.println("Error connect to db:\n" + e.getMessage());
            System.err.println(e.getStackTrace().toString());
        }
        return result;
    }

    // ?
}
