package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author deerfox@debian
 */

public class Conexion {
    public static Connection realizarConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/eurekabank?useSSL=false";
        String user = "root";
        String password = "correct-horse-battery-staple";
        return DriverManager.getConnection(url, user, password);
    }
}