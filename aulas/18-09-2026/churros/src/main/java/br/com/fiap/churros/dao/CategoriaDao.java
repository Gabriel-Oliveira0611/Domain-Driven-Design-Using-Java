package br.com.fiap.churros.dao;

import br.com.fiap.churros.model.Categoria;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CategoriaDao {

    private DataSource dataSource;

    private Connection conexao;

    public CategoriaDao(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        conexao = dataSource.getConnection();
    }

    public void cadastrar(Categoria categoria) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement("insert into t_jdbc_categoria (cd_categoria, nm_categoria) " +
                "values (sq_t_jdbc_categoria.nextval, ?)", new String[] {"cd_categoria"});
        stmt.setString(1, categoria.getNome());
        stmt.executeUpdate();
        ResultSet resultSet = stmt.getGeneratedKeys();
        if (resultSet.next())
            categoria.setCodigo(resultSet.getInt(1));
    }
}
