package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLData;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://localhost:5432/dbtoodoo";
    public static final String USER = "postgres";
    public static final String PASSWORD = "root";
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        try {
            setConnection(DriverManager.getConnection(URL, USER, PASSWORD));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.connection;
    }
}
