package br.com.fiap.api27092026.dao;

import br.com.fiap.api27092026.model.Produto;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoDao {

    private final DataSource dataSource;
    //    Criação dos comandos SQL
    String SQLinsert = "insert into t_api_motopecas (id_produto, nome_produto, quantidade_produto, valor_produto, fornecedor_produto) values (sq_t_api_motopecas.nextval, ?, ?, ?, ?)";
    String SQLupdate = "update t_api_motopecas set NOME_PRODUTO = ?, QUANTIDADE_PRODUTO = ?, VALOR_PRODUTO = ?, FORNECEDOR_PRODUTO = ? where ID_PRODUTO = ?";
    String SQLdelete = "delete from t_api_motopecas where ID_PRODUTO = ?";
    String SQLread = "select * from t_api_motopecas";
    String SQLreadByName = "select * from t_api_motopecas where NOME_PRODUTO = ?";

    public ProdutoDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void cadastrar(Produto produto) throws SQLException {
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement statement = conexao.prepareStatement(SQLinsert, new String[]{"ID_PRODUTO"});
                ResultSet resultado = statement.getGeneratedKeys()
        ) {
//            Atribuir valores ao comando SQL
            statement.setString(1, produto.getNome());
            statement.setInt(2, produto.getQuantidade());
            statement.setDouble(3, produto.getValor());
            statement.setString(4, produto.getFornecedor());
            statement.executeUpdate();

            if (resultado.next()) {
                produto.setCodigo(resultado.getInt(1));
            }
        }
    }

    public void update(Produto produto) throws SQLException {
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement statement = conexao.prepareStatement(SQLupdate);
        ) {
            statement.setString(1, produto.getNome());
            statement.setInt(2, produto.getQuantidade());
            statement.setDouble(3, produto.getValor());
            statement.setString(4, produto.getFornecedor());
            statement.setInt(5, produto.getCodigo());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement statement = conexao.prepareStatement(SQLdelete);
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<Produto> read() throws SQLException {
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement statement = conexao.prepareStatement(SQLread)
        ) {
            List<Produto> lista = new ArrayList<>();
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                lista.add(new Produto(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getInt(3),
                        resultado.getDouble(4),
                        resultado.getString(5)
                ));
            }

            return lista;
        }
    }

    public List<Produto> readByName(String name) throws SQLException {
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement statement = conexao.prepareStatement(SQLreadByName)
        ) {
            statement.setString(1, name);
            ResultSet resultado = statement.executeQuery();

            List<Produto> lista = new ArrayList<>();
            while (resultado.next()) {
                lista.add(new Produto(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getInt(3),
                        resultado.getDouble(4),
                        resultado.getString(5)
                ));
            }

            return lista;
        }
    }

}
