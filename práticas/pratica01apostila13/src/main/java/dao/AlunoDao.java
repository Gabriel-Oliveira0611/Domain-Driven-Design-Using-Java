package dao;

import factory.ConnectionFactory;
import model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private Connection conexao;

    public AlunoDao() throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Aluno aluno) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement(
                "insert into tb_aluno (id_aluno, rm_aluno, nome_aluno, ativo_aluno, nota1, nota2) values (?,?,?,?,?,?)"
        );

        stmt.setInt(1, aluno.getId());
        stmt.setString(2, aluno.getRm());
        stmt.setString(3, aluno.getNome());
        stmt.setBoolean(4, aluno.isAtivo());
        stmt.setDouble(5, aluno.getNota1());
        stmt.setDouble(6, aluno.getNota2());

        stmt.executeUpdate();
        stmt.close();
    }

    public List<Aluno> listar() throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement(
                "select * from tb_aluno"
        );

        ResultSet result = stmt.executeQuery();

        List<Aluno> lista = new ArrayList<>();

        while (result.next()) {
            Aluno alunoBuscado = new Aluno(
                    result.getInt("id_aluno"),
                    result.getString("rm_aluno"),
                    result.getString("nome_aluno"),
                    result.getBoolean("ativo_aluno"),
                    result.getDouble("nota1"),
                    result.getDouble("nota2")
            );

            lista.add(alunoBuscado);
        }

        return lista;
    }

}
