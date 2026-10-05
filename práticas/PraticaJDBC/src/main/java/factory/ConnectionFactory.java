package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    Connection conexao = DriverManager.getConnection(
            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
            "rm572262",
            "061101"
    )

    public ConnectionFactory() throws SQLException {
    }
}
