package dao;

import exception.AlunoNaoEncontradoException;
import factory.ConnectionFactory;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private Connection conexao;

    public AlunoDao() throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Aluno aluno) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement(
                "insert into t_fiap_aluno (id_aluno, nome_aluno, email_aluno, idade_aluno) values (?,?,?,?)"
        );

        stmt.setInt(1, aluno.getId());
        stmt.setString(2, aluno.getNome());
        stmt.setString(3, aluno.getEmail());
        stmt.setInt(4, aluno.getIdade());

        stmt.executeUpdate();
        stmt.close();
    }

    public Aluno buscar(int idAluno) throws SQLException, AlunoNaoEncontradoException {
//        Criar comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "select * from t_fiap_aluno where id_aluno = ?"
        );

//        Atribuir valor do parâmetro ao comando sql
        stmt.setInt(1, idAluno);

//        Guardar resoltado da busca em um ResultSet
        ResultSet rs = stmt.executeQuery();

//        Verificar se o aluno existe
        if (!rs.next()) {
            throw new AlunoNaoEncontradoException("Aluno não encontrado!");
        }

//        Criar variáveis do Aluno
        int id = rs.getInt("id_aluno");
        String nome = rs.getString("nome_aluno");
        String email = rs.getString("email_aluno");
        int idade = rs.getInt("idade_aluno");

//        Criar aluno
        return new Aluno(id, nome, email, idade);
    }

    public void update(Aluno aluno) throws SQLException {
//        Criação do comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "update t_fiap_aluno set nome_aluno = ?, email_aluno = ?, idade_aluno = ? where id_aluno = ?"
        );
        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getEmail());
        stmt.setInt(3, aluno.getIdade());
        stmt.setInt(4, aluno.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    public void delete(int idDelete) throws SQLException {
//        Criação do comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "delete from t_fiap_aluno where id_aluno = ?"
        );
        stmt.setInt(1, idDelete);

        stmt.executeUpdate();
        stmt.close();
    }

    public List<Aluno> listar() throws SQLException {
//        Criação da lista
        List<Aluno> alunos = new ArrayList<>();

//        Criação do comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "select * from t_fiap_aluno"
        );
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id_aluno");
            String nome = rs.getString("nome_aluno");
            String email = rs.getString("email_aluno");
            int idade = rs.getInt("idade_aluno");

            alunos.add(new Aluno(id, nome, email, idade));
        }

        return alunos;

    }


}
