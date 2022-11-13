package dados;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {

    public static Connection conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/url";
        String user = "root";
        String password = "admin123";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception exception) {
            return null;
        }
    }
}
