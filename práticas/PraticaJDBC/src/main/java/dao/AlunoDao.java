package dao;

import factory.ConnectionFactory;
import model.Aluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDao {

    private Connection conexao;
    public AlunoDao() throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Aluno aluno) throws SQLException {
//        Criar comando SQL
        PreparedStatement stmt = conexao.prepareStatement(
                "insert into T_SCHL_ALUNO (ID_ALUNO, NOME_ALUNO, IDADE_ALUNO, CPF_ALUNO, EMPREGO_ALUNO) values (?, ?, ?, ?, ?);"
        );
        stmt.setInt(1, aluno.getId());
        stmt.setString(2, aluno.getNome());
        stmt.setInt(3, aluno.getIdade());
        stmt.setString(4, aluno.getCpf());
        stmt.setString(5, aluno.getEmprego());

        stmt.execute();
    }

}
