package br.com.fiap.apostila13.dao;

import br.com.fiap.apostila13.exception.EntidadeNaoEncontradaException;
import br.com.fiap.apostila13.factory.ConnectionFactory;
import br.com.fiap.apostila13.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Produto buscar(int id) throws SQLException, EntidadeNaoEncontradaException {
//        Criar o comando sql
        PreparedStatement stmt = conexao.prepareStatement("select * from t_jdbc_produto where cd_produto = ?");
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery(); //Executa comandos de pesquisa

//        Validar se existe um produto no resultado
        if (!resultSet.next()) {
            throw new EntidadeNaoEncontradaException("Produto não encontrado");
        }

//        Recuperar as informações do resultset
        int codigo = resultSet.getInt("cd_produto");
        String nome = resultSet.getString("nm_produto");
        String descricao = resultSet.getString("ds_produto");
        double valor = resultSet.getDouble("vl_produto");
        boolean temEstoque = resultSet.getBoolean("st_estoque");

        return new Produto(codigo, nome, descricao, valor, temEstoque);
    }

    public void update(Produto produto) throws SQLException {
//        Criar o comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "update t_jdbc_produto set cd_produto = ?, nm_produto = ?, ds_produto = ?, vl_produto = ?, st_estoque = ? where cd_produto = ?"
        );

//        Atribuir valor do parâmetro ao comando SQL
        stmt.setInt(1, produto.getCodigo());
        stmt.setString(2, produto.getNome());
        stmt.setString(3, produto.getDescricao());
        stmt.setDouble(4, produto.getValor());
        stmt.setBoolean(5, produto.isTemEstoque());
        stmt.setInt(6, produto.getCodigo());

//        Executar comando
        stmt.executeUpdate();

//        Encerra comando
        stmt.close();
    }

    public void delete (int id) throws SQLException {
//        Criar comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "delete from t_jdbc_produto where cd_produto = ?"
        );

//        Atribuir o valor do parãmetro ao comando SQL
        stmt.setInt(1, id);

        stmt.executeUpdate();
        stmt.close();
    }

    public List<Produto> listar() throws SQLException, EntidadeNaoEncontradaException {
//        Criação da Lista
        List<Produto> lista = new ArrayList<>();

//        Criação do comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "select * from t_jdbc_produto"
        );

//        Guardar valores num ResultSet
        ResultSet resultSet = stmt.executeQuery();

        if (!resultSet.next()) {
            throw new EntidadeNaoEncontradaException("Nenhum produto na lista.");
        }

        while (resultSet.next()) {
            int codigo = resultSet.getInt("cd_produto");
            String nome = resultSet.getString("nm_produto");
            String descricao = resultSet.getString("ds_produto");
            double valor = resultSet.getDouble("vl_produto");
            boolean temEstoque = resultSet.getBoolean("st_estoque");

            lista.add(new Produto(codigo, nome, descricao, valor, temEstoque));
        }

        stmt.close();
        return lista;
    }



}
