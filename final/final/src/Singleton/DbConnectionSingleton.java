package Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionSingleton {
    private static DbConnectionSingleton instance;
    private Connection connection;
    private Statement statement;

    private DbConnectionSingleton() {
        initializeConnection();
    }

    public static DbConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new DbConnectionSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    private void initializeConnection() {
        // Инициализация подключения к PostgreSQL
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/soft";
            String user = "postgres";
            String password = "Sxx1LoKxE5baQ";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
}
