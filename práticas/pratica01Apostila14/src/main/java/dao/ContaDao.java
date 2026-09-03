package dao;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ContaDao {

    private Connection conexao;

    public ContaDao() throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
    }

    public void deposito() {
        
    }
}
