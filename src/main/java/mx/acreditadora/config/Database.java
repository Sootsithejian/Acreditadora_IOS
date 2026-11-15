
package mx.acreditadora.config;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final Dotenv dotenv =
        Dotenv.configure().ignoreIfMissing().load();

    private static String getConfig(String key, String defaultValue) {
        String value = System.getenv(key);

        if (value == null || value.isBlank()) {
            value = dotenv.get(key, defaultValue);
        }

        return value;
    }

    private static final String HOST =
        getConfig("MYSQLHOST", "localhost");

    private static final String PORT =
        getConfig("MYSQLPORT", "3306");

    private static final String DATABASE =
        getConfig("MYSQLDATABASE", "Acreditadora");

    private static final String URL =
        getConfig(
            "DB_URL",
            "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE
                + "?useSSL=false&serverTimezone=UTC"
        );

    private static final String USER =
        getConfig("DB_USER", getConfig("MYSQLUSER", "root"));

    private static final String PASSWORD =
        getConfig("DB_PASSWORD", getConfig("MYSQLPASSWORD", ""));

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
