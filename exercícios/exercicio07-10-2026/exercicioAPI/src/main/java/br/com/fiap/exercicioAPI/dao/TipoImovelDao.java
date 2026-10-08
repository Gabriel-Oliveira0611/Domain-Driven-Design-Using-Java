package br.com.fiap.exercicioAPI.dao;

import br.com.fiap.exercicioAPI.exception.RegistroNaoEncontradoException;
import br.com.fiap.exercicioAPI.model.TipoImovel;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TipoImovelDao {

    private final DataSource dataSource;

    public TipoImovelDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static final String SQL_INSERT = """
            insert into T_API_TIPO_IMOVEL (CD_TIPO, NM_TIPO, DT_CADASTRO)
            values (SQ_T_API_TIPO_IMOVEL.nextval, ?, ?)
            """;

    private static final String SQL_READ = """
            select CD_TIPO,
                   NM_TIPO,
                   DT_CADASTRO
            from T_API_TIPO_IMOVEL;
            """;

    private static final String SQL_READ_BY_ID = """
            select CD_TIPO,
                   NM_TIPO,
                   DT_CADASTRO
            from T_API_TIPO_IMOVEL WHERE CD_TIPO = ?
            """;

    private static final String SQL_UPDATE = """
            update T_API_TIPO_IMOVEL
            set NM_TIPO = ?,
                DT_CADASTRO = ?
            where CD_TIPO = ?;
            """;

    private static final String SQL_DELETE = """
            delete
            from T_API_TIPO_IMOVEL
            where CD_TIPO = ?;
            """;

    //    Create
    public void create(TipoImovel tipoImovel) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        SQL_INSERT, new String[]{"cd_tipo"}
                )
        ) {
            statement.setString(1, tipoImovel.getNome());
            statement.setTimestamp(2, Timestamp.valueOf(tipoImovel.getDataDeCadastro()));
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                tipoImovel.setId(resultSet.getInt(1));
            }
        }
    }

    //    Read
    public List<TipoImovel> read() throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_READ);
                ResultSet resultSet = statement.executeQuery()
        ) {

            List<TipoImovel> tiposImoveis = new ArrayList<>();

            while (resultSet.next()) {
                tiposImoveis.add(
                        new TipoImovel(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getTimestamp(3).toLocalDateTime()
                        )
                );
            }

            if (tiposImoveis.isEmpty()) {
                throw new RegistroNaoEncontradoException(
                        "Não foi encontrado nenhum registro."
                );
            } else {
                return tiposImoveis;
            }
        }
    }

    public TipoImovel readById(int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_READ_BY_ID)
                ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new TipoImovel(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getTimestamp(3).toLocalDateTime()
                );
            } else throw new RegistroNaoEncontradoException(
                    "Nenhum registro contém esse ID."
            );
        }
    }

//    Update
    public void update(TipoImovel tipoImovel, int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)
                ){
            statement.setString(1, tipoImovel.getNome());
            statement.setTimestamp(2, Timestamp.valueOf(tipoImovel.getDataDeCadastro()));
            statement.setInt(3, id);
            statement.executeUpdate();

            int linhas = statement.getUpdateCount();
            if (linhas == 0) {
                throw new RegistroNaoEncontradoException(
                        "Não existe nenhum registro com esse ID"
                );
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
                throw new RegistroNaoEncontradoException(
                        "Não existe nenhum registro com esse ID."
                );
            }
        }
    }
}
