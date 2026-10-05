package br.com.fiap.api.dao;

import br.com.fiap.api.model.TipoImovel;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TipoImovelDao {

    private final DataSource dataSource;
    public TipoImovelDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    String SQLinsert = "insert into t_api_tipo_imovel (cd_tipo, nome_tipo, data_cadastro) values (sq_t_api_tipo_imovel.nextval, ?, ?)";

    public void cadastrar(TipoImovel tipoImovel) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLinsert, new String[]{"ID_TIPO"})
                ){
            preparedStatement.setString(1, tipoImovel.getNome());
            preparedStatement.setObject(2, tipoImovel.getDataDeCadastro());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                tipoImovel.setCodigo(resultSet.getInt(1));
            }
        }
    }
}
