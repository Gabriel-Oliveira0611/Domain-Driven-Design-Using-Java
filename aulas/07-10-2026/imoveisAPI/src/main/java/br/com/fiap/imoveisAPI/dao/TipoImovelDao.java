package br.com.fiap.imoveisAPI.dao;

import br.com.fiap.imoveisAPI.exception.RegistroNaoEncontradoException;
import br.com.fiap.imoveisAPI.model.TipoImovel;
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

    //    Comandos SQL
    private static final String SQL_INSERT = "insert into t_api_tipo_imovel (cd_tipo, nm_tipo, dt_cadastro) values (sq_t_api_tipo_imovel.nextval, ?, ?)";
    private static final String SQL_READ = "select * from t_api_tipo_imovel";
    private static final String SQL_READ_BY_ID = "select * from t_api_tipo_imovel where cd_tipo = ?";
    private static final String SQL_UPDATE = "update t_api_tipo_imovel set nm_tipo = ?, dt_cadastro = ? where cd_tipo = ?";
    private static final String SQL_DELETE = "delete from t_api_tipo_imovel where cd_tipo = ?";

//    Create
    public void create(TipoImovel tipoImovel) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        SQL_INSERT, new String[]{"cd_tipo"}
                )
                ){
            statement.setString(1, tipoImovel.getNome());
            statement.setTimestamp(2, Timestamp.valueOf(tipoImovel.getDataCadastro()));
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                tipoImovel.setCodigo(resultSet.getInt(1));
            }
        }
    }

//    Read
    public List<TipoImovel> read() throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_READ);
                ResultSet resultSet = statement.executeQuery()
                ){
            List<TipoImovel> imoveis = new ArrayList<>();
            while (resultSet.next()) {
                imoveis.add(
                        new TipoImovel(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getTimestamp(3).toLocalDateTime()
                        )
                );
            }

            if (imoveis.isEmpty()) {
                throw new RegistroNaoEncontradoException(
                        "Nenhum registro existe nessa tabela."
                );
            } else {
                return imoveis;
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
            } else {
                throw new RegistroNaoEncontradoException(
                        "Não existe nenhum registro com esse ID."
                );
            }
        }
    }

//    Update
    public void update(TipoImovel tipoImovel, int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)
                ){
            statement.setString(1, tipoImovel.getNome());
            statement.setTimestamp(2, Timestamp.valueOf(tipoImovel.getDataCadastro()));
            statement.setInt(3, id);
            statement.executeUpdate();

            int linhas = statement.getUpdateCount();
            if (linhas == 0) {
                throw new RegistroNaoEncontradoException(
                        "Nenhum registro foi atualizado."
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
                        "Nenhum registro foi deletado."
                );
            }
        }
    }
}
