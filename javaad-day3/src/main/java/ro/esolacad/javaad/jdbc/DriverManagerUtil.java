package ro.esolacad.javaad.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerUtil {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ad_20_07_2020",
                    "postgres", "postgres");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("No connection found");
        }
    }
}
