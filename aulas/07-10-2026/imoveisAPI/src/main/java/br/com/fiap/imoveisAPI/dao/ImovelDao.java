package br.com.fiap.imoveisAPI.dao;

import br.com.fiap.imoveisAPI.exception.RegistroNaoEncontradoException;
import br.com.fiap.imoveisAPI.model.Imovel;
import br.com.fiap.imoveisAPI.model.TipoImovel;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ImovelDao {

    private final DataSource dataSource;

    public ImovelDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //    Comandos SQL
    private static final String SQL_INSERT = "insert into t_api_imovel (cd_imovel, ds_imovel, nr_dimensao, vl_imovel, t_api_imovel.cd_tipo) values (sq_t_api_imovel.nextval, ?, ?, ?, ?)";
    private static final String SQL_SELECT = "select * from t_api_imovel";
    private static final String SQL_SELECT_BY_ID = "select * from t_api_imovel where cd_imovel = ?";
    private static final String SQL_UPDATE = "update t_api_imovel set ds_imovel = ?, nr_dimensao = ?, vl_imovel = ?, cd_tipo = ? where cd_imovel = ?";
    private static final String SQL_DELETE = "delete from t_api_imovel where cd_imovel = ?";

    //    Create
    public void create(Imovel imovel) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        SQL_INSERT, new String[]{"cd_imovel"}
                )
        ) {
            statement.setString(1, imovel.getDescricao());
            statement.setDouble(2, imovel.getDimensao());
            statement.setDouble(3, imovel.getValor());
            statement.setInt(4, imovel.getTipo().getCodigo());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                imovel.setId(resultSet.getInt(1));
            }
        }
    }

    //    Read
    public List<Imovel> read() throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
                ResultSet resultSet = statement.executeQuery()
        ) {
            List<Imovel> imoveis = new ArrayList<>();
            while (resultSet.next()) {
                TipoImovel tipo = new TipoImovel(
                        resultSet.getInt(5)
                );

                imoveis.add(
                        new Imovel(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getDouble(3),
                                resultSet.getDouble(4),
                                tipo
                        )
                );
            }

            return imoveis;
        }
    }

    public Imovel readById(int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                TipoImovel tipo = new TipoImovel(
                        resultSet.getInt(5)
                );

                return new Imovel(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        tipo
                );
            } else {
                throw new RegistroNaoEncontradoException(
                        "Nenhum registro contém esse ID."
                );
            }

        }
    }

//    Update
    public void update(Imovel imovel, int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)
                ){
            statement.setString(1, imovel.getDescricao());
            statement.setDouble(2, imovel.getDimensao());
            statement.setDouble(3, imovel.getValor());
            statement.setInt(4, imovel.getTipo().getCodigo());
            statement.setInt(5, id);
            statement.executeUpdate();

            int linhas = statement.getUpdateCount();
            if (linhas == 0) {
                throw new RegistroNaoEncontradoException(
                        "Não existe nenhum registro com esse ID."
                );
            }
        }
    }

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
                        "Não existe nenhum registro com essee ID."
                );
            }
        }
    }
}
