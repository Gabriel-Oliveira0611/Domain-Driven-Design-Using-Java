package br.com.fiap.apostila13.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

//    Static - método que pertence à classe, e não ao objeto.
//    Static - Não precisa do objeto para chamar o método

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                "rm572262",
                "061101");
        return conexao;
    }

}
