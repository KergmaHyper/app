package app.models;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
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

        String sql = "SELECT * FROM prods;";

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
}
