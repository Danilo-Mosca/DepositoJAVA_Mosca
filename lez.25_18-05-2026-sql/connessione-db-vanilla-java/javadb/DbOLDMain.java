import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DbOLDMain {
    public static void main(String[] args) {

        Properties dbProperties = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {

            dbProperties.load(input);
            String DB_DRIVER = dbProperties.getProperty("DB_DRIVER");
            String DB_URL = dbProperties.getProperty("DB_URL");
            String DB_USERNAME = dbProperties.getProperty("DB_USERNAME");
            String DB_PASSWORD = dbProperties.getProperty("DB_PASSWORD");

            Class.forName(DB_DRIVER);

            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (conn != null)

                System.out.println("Successfully connected.");

            else

                System.out.println("Failed to connect.");

            // Esecuzione delle query
            String QUERY = "SELECT * FROM city ORDER BY city.name DESC LIMIT 10;"; // query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}