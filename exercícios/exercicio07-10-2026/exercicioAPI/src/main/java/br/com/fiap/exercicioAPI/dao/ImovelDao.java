package br.com.fiap.exercicioAPI.dao;

import br.com.fiap.exercicioAPI.exception.RegistroNaoEncontradoException;
import br.com.fiap.exercicioAPI.model.Imovel;
import br.com.fiap.exercicioAPI.model.TipoImovel;
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

    private static final String SQL_INSERT = """
            insert into T_API_IMOVEL (CD_IMOVEL, DS_IMOVEL, NR_DIMENSAO, VL_IMOVEL, CD_TIPO)
            values (SQ_T_API_IMOVEL.nextval, ?, ?, ?, ?)
            """;

    private static final String SQL_READ = """
            select CD_IMOVEL,
                   DS_IMOVEL,
                   NR_DIMENSAO,
                   VL_IMOVEL,
                   T_API_IMOVEL.CD_TIPO,
                   NM_TIPO,
                   T_API_TIPO_IMOVEL.CD_TIPO
            from T_API_IMOVEL
                     inner join T_API_TIPO_IMOVEL on (T_API_TIPO_IMOVEL.CD_TIPO = T_API_IMOVEL.CD_TIPO)
            """;

    private static final String SQL_READ_BY_ID = """
            select CD_IMOVEL,
                   DS_IMOVEL,
                   NR_DIMENSAO,
                   VL_IMOVEL,
                   T_API_IMOVEL.CD_TIPO,
                   NM_TIPO,
                   T_API_TIPO_IMOVEL.CD_TIPO
            from T_API_IMOVEL
                     inner join T_API_TIPO_IMOVEL on (T_API_TIPO_IMOVEL.CD_TIPO = T_API_IMOVEL.CD_TIPO)
            where CD_IMOVEL = ?
            """;

    private static final String SQL_UPDATE = """
            update T_API_IMOVEL
            set DS_IMOVEL   = ?,
                NR_DIMENSAO = ?,
                VL_IMOVEL   = ?,
                CD_TIPO     = ?
            where CD_IMOVEL = ?;
            """;

    private static final String SQL_DELETE = """
            delete
            from T_API_IMOVEL
            where CD_IMOVEL = ?;
            """;

//    Create
    public void create(Imovel imovel) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        SQL_INSERT, new String[]{"cd_imovel"}
                )
                ){
            statement.setString(1, imovel.getDescricao());
            statement.setDouble(2, imovel.getDimensao());
            statement.setDouble(3, imovel.getValor());
            statement.setInt(4, imovel.getTipoImovel().getId());
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
                PreparedStatement statement = connection.prepareStatement(SQL_READ);
                ResultSet resultSet = statement.executeQuery()
                ){

            List<Imovel> imoveis = new ArrayList<>();
            while (resultSet.next()) {

                imoveis.add(
                        new Imovel(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getDouble(3),
                                resultSet.getDouble(4),
                                new TipoImovel(
                                        resultSet.getInt(5),
                                        resultSet.getString(6),
                                        resultSet.getTimestamp(7).toLocalDateTime()
                                )
                        )
                );
            }

            if (imoveis.isEmpty()) {
                throw new RegistroNaoEncontradoException(
                        "Nenhum registro encontrado."
                );
            } else {
                return imoveis;
            }
        }
    }

    public Imovel readById(int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_READ_BY_ID)
                ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Imovel(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        new TipoImovel(
                                resultSet.getInt(5),
                                resultSet.getString(6),
                                resultSet.getTimestamp(7).toLocalDateTime()
                        )
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
            statement.setInt(4, imovel.getTipoImovel().getId());
            statement.setInt(5, id);
            statement.executeUpdate();

            int linhas = statement.getUpdateCount();
            if (linhas == 0) {
                throw new RegistroNaoEncontradoException(
                        "Nenhum registro contém esse id."
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
                        "Nenhum registro contém esse ID."
                );
            }
        }
    }


}
