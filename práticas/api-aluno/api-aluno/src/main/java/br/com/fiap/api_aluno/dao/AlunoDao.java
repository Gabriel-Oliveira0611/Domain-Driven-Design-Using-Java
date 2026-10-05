package br.com.fiap.api_aluno.dao;

import br.com.fiap.api_aluno.model.Aluno;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AlunoDao {

    private final DataSource dataSource;

    public AlunoDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void cadastrar(Aluno aluno) throws SQLException {
        String sql = "insert into T_API_ALUNO (ID_ALUNO, NOME_ALUNO, IDADE_ALUNO, CPF_ALUNO) values (SQ_T_API_ALUNO.nextval, ?, ?, ?)";
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql, new String[]{"id_aluno"})
                ) {

        }
    }
}
