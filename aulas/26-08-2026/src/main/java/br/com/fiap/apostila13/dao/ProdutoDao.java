package br.com.fiap.apostila13.dao;

import br.com.fiap.apostila13.factory.ConnectionFactory;
import br.com.fiap.apostila13.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDao {

    private Connection conexao;

    public ProdutoDao() throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Produto produto) throws SQLException {
//        Criar comando SQL
        PreparedStatement stmt = conexao.prepareStatement("insert into T_JDBC_PRODUTO " +
                "(cd_produto, nm_produto, ds_produto, vl_produto, st_estoque) " +
                "values (?,?,?,?,?)");
//        Setar os parâmetros no comando SQL
        stmt.setInt(1, produto.getCodigo());
        stmt.setString(2, produto.getNome());
        stmt.setString(3,produto.getDescricao());
        stmt.setDouble(4, produto.getValor());
        stmt.setBoolean(5, produto.isTemEstoque());

//        Execura o comando SQL no banco
        stmt.executeUpdate();
    }

}
