package br.com.fiap.api_techstore.dao;

import br.com.fiap.api_techstore.model.Produto;
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

    public ProdutoDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void cadastrar(Produto produto) throws SQLException {
        String sql = "insert into T_TECH_PRODUTO (ID_PRODUTO, NOME_PRODUTO, QUANTIDADE_PRODUTO, VALOR_PRODUTO) values (SQ_T_TECH_PRODUTO.nextval, ?, ?, ?);";
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql, new String[]{"ID_PRODUTO"})
        ) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                produto.setId(rs.getInt(1));
            }
        }
    }

    public Produto buscar(int id) throws SQLException {
        String sql = "select * from T_TECH_PRODUTO where ID_PRODUTO = ?;";
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4)
                );
            }
        }

        return null;
    }

    public List<Produto> listar() throws SQLException {
        String sql = "select * from T_TECH_PRODUTO";
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet resultSet = stmt.executeQuery()
        ) {

            List<Produto> lista = new ArrayList<>();
            while (resultSet.next()) {
                lista.add(new Produto(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4)
                ));
            }

            return lista;
        }
    }

    public void atualizar(Produto produto) throws SQLException {
        String sql = "update T_TECH_PRODUTO set NOME_PRODUTO = ?, QUANTIDADE_PRODUTO = ?, VALOR_PRODUTO = ? where ID_PRODUTO = ?;";
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());
            stmt.setInt(4, produto.getId());

            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from T_TECH_PRODUTO where  ID_PRODUTO = ?;";
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

