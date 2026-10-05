package br.com.fiap.HXF_API.dao;

import br.com.fiap.HXF_API.exception.RegistroNaoEncontradoException;
import br.com.fiap.HXF_API.model.Compactador;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompactadorDao {

    private final DataSource dataSource;

    public CompactadorDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static final String SQL_INSERT = "insert into t_hxf_compactador (id_compactador, nome_compactador, peso_compactador, valor_compactador, base_compactador) values (sq_t_hxf_compactador.nextval, ?, ?, ?, ?)";
    private static final String SQL_READ = "select * from t_hxf_compactador";
    private static final String SQL_READ_BY_ID = "select * from t_hxf_compactador where id_compactador = ?";
    private static final String SQL_UPDATE = "update t_hxf_compactador set nome_compactador = ?, peso_compactador = ?, valor_compactador = ?, base_compactador = ? where id_compactador = ?";
    private static final String SQL_DELETE = "delete from t_hxf_compactador where id_compactador = ?";

    //    Create
    public void create(Compactador compactador) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        SQL_INSERT, new String[]{"id_compactador"}
                )
        ) {
            statement.setString(1, compactador.getNome());
            statement.setDouble(2, compactador.getPeso());
            statement.setDouble(3, compactador.getValor());
            statement.setInt(4, compactador.getBase());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                compactador.setId(resultSet.getInt(1));
            }
        }
    }

    //    Read
    public List<Compactador> read() throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_READ);
                ResultSet resultSet = statement.executeQuery()
        ) {
            List<Compactador> compactadores = new ArrayList<>();
            while (resultSet.next()) {
                compactadores.add(
                        new Compactador(
                                resultSet.getInt("id_compactador"),
                                resultSet.getString("nome_compactador"),
                                resultSet.getDouble("peso_compactador"),
                                resultSet.getDouble("valor_compactador"),
                                resultSet.getInt("base_compactador")
                        )
                );
            }

            if (compactadores.isEmpty()) {
                throw new RegistroNaoEncontradoException("Nenhum registro encontrado.");
            } else {
                return compactadores;
            }
        }
    }

    public Compactador readById(int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_READ_BY_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                throw new RegistroNaoEncontradoException("Nenhum registro contém esse id.");
            } else {
                return new Compactador(
                        resultSet.getInt("id_compactador"),
                        resultSet.getString("nome_compactador"),
                        resultSet.getDouble("peso_compactador"),
                        resultSet.getDouble("valor_compactador"),
                        resultSet.getInt("base_compactador")
                );
            }
        }
    }

//    Update
    public void update(Compactador compactador, int id)
            throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)
        ) {
            statement.setString(1, compactador.getNome());
            statement.setDouble(2, compactador.getPeso());
            statement.setDouble(3, compactador.getValor());
            statement.setInt(4, compactador.getBase());
            statement.setInt(5, id);
            statement.executeUpdate();

            int linhas = statement.getUpdateCount();
            if (linhas == 0) {
                throw new RegistroNaoEncontradoException("Nenhum registro contém esse id.");
            }
        }
    }

//    Delete
    public void delete(int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_DELETE)
                ){
            statement.setInt(1, id);
            statement.executeUpdate();

            int linhas = statement.getUpdateCount();
            if (linhas == 0) {
                throw new RegistroNaoEncontradoException("Nenhum registro contém esse id.");
            }
        }
    }
}
