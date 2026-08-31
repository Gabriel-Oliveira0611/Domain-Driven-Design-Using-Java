package br.com.bukan.dao;

import br.com.bukan.exception.InstrutorNaoEncontradoException;
import br.com.bukan.factory.ConnectionFactory;
import br.com.bukan.model.Instrutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDao {

    private Connection conexao;

    public InstrutorDao() throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
    }

//Cadastrar
    public void cadastrar(Instrutor instrutor) throws SQLException {
//        Criar comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "insert into t_bukan_instrutor (id_instrutor, nome_instrutor, cpf_instrutor, idade_instrutor, faixa_instrutor, nivel_instrutor) values (?, ?, ?, ?, ?, ?)"
        );

        stmt.setInt(1, instrutor.getId());
        stmt.setString(2, instrutor.getNome());
        stmt.setString(3, instrutor.getCpf());
        stmt.setInt(4, instrutor.getIdade());
        stmt.setString(5, instrutor.getFaixa());
        stmt.setString(6, instrutor.getNivel());

        stmt.executeUpdate();
        stmt.close();
    }

    public Instrutor buscar(int idBusca) throws SQLException, InstrutorNaoEncontradoException {
//        Criar comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "select * from t_bukan_instrutor where id_instrutor = ?"
        );

//        Atribuir valor do parâmetro ao comando sql
        stmt.setInt(1, idBusca);

//        Guardar o resultado em um ResultSet
        ResultSet rs = stmt.executeQuery();

//        Verificar se existe o registro
        if (!rs.next()) {
            throw new InstrutorNaoEncontradoException("Instrutor não encontrado.");
        }

        stmt.close();

        return new Instrutor(
                rs.getInt("id_instrutor"),
                rs.getString("nome_instrutor"),
                rs.getString("cpf_instrutor"),
                rs.getInt("idade_instrutor"),
                rs.getString("faixa_instrutor"),
                rs.getString("nivel_instrutor")
        );
    }

    public void update(Instrutor instrutor) throws SQLException {
//        Criar comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "update t_bukan_instrutor set nome_instrutor = ?, cpf_instrutor = ?, idade_instrutor = ?, faixa_instrutor = ?, nivel_instrutor = ? where id_instrutor = ?"
        );
        stmt.setString(1, instrutor.getNome());
        stmt.setString(2, instrutor.getCpf());
        stmt.setInt(3, instrutor.getIdade());
        stmt.setString(4, instrutor.getFaixa());
        stmt.setString(5, instrutor.getNivel());
        stmt.setInt(6, instrutor.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    public void delete(int id) throws SQLException {
//        Criação do comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "delete from t_bukan_instrutor where id_instrutor = ?"
        );

//        Atribuir valor do parâmetro ao comando SQL
        stmt.setInt(1, id);

        stmt.executeUpdate();
        stmt.close();
    }

    public List<Instrutor> listar() throws SQLException {
//        Criar comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "select * from t_bukan_instrutor"
        );

//        Guardar o resultado do comando num resultset
        ResultSet resultSet = stmt.executeQuery();

//        Criar lista para conter os registros encontrados
        List<Instrutor> instrutores = new ArrayList<>();

        while (resultSet.next()) {
            Instrutor instrutor = new Instrutor(
                    resultSet.getInt("id_instrutor"),
                    resultSet.getString("nome_instrutor"),
                    resultSet.getString("cpf_instrutor"),
                    resultSet.getInt("idade_instrutor"),
                    resultSet.getString("faixa_instrutor"),
                    resultSet.getString("nivel_instrutor")
            );

            instrutores.add(instrutor);
        }

        return instrutores;
    }
}
