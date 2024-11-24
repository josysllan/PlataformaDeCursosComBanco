package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/exemplobd";
    private static final String USER = "root";
    private static final String PASSWORD = "96594110br";

    private static Connection conn;

    public static Connection getConexao() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  // Certifique-se de carregar o driver JDBC
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
