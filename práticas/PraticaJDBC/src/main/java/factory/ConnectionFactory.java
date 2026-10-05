package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

<<<<<<< HEAD
    Connection conexao = DriverManager.getConnection(
            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
            "rm572262",
            "061101"
    )

    public ConnectionFactory() throws SQLException {
=======
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                "rm572262",
                "061101"
        );

        return conexao;
>>>>>>> 8d3bd0aba2a19f56c06e66457c4360b89d10194c
    }
}
