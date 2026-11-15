package mx.acreditadora.config;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    private static final String URL =
    dotenv.get("DB_URL", "jdbc:mysql://localhost:3306/Acreditadora?useSSL=false&serverTimezone=UTC");

    private static final String USER = dotenv.get("DB_USER", "root");

    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

  public static Connection getConnection() throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);


    return conn;
}
    }
