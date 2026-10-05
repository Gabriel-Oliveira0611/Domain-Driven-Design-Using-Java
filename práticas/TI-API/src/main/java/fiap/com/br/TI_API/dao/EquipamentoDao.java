package fiap.com.br.TI_API.dao;

import fiap.com.br.TI_API.exception.RegistroNaoEncontradoException;
import fiap.com.br.TI_API.model.Equipamento;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EquipamentoDao {

    private static final String INSERT_SQL = "insert into t_tech_equipamento (id_equipamento, nome_equipamento, categoria_equipamento, patrimonio_equipamento, status_equipamento, valor_equipamento) values (sq_t_tech_equipamento.nextval, ?, ?, ?, ?, ?)";
    private static final String READ_SQL = "select * from t_tech_equipamento";
    private static final String READBYID_SQL = "select * from t_tech_equipamento where id_equipamento =  ?";
    private static final String UPDATE_SQL = "update t_tech_equipamento set nome_equipamento = ?, categoria_equipamento = ?, patrimonio_equipamento = ?, status_equipamento = ?, valor_equipamento = ? where id_equipamento = ?";
    private static final String DELETE_SQL = "delete from t_tech_equipamento where id_equipamento = ?";
    private final DataSource dataSource;

    public EquipamentoDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(Equipamento equipamento) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_SQL, new String[]{"id_equipamento"})
        ) {
            statement.setString(1, equipamento.getNome());
            statement.setString(2, equipamento.getCategoria());
            statement.setString(3, equipamento.getPatrimonio());
            statement.setString(4, equipamento.getStatus());
            statement.setDouble(5, equipamento.getValor());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                equipamento.setId(resultSet.getInt(1));
            }

            int linhas = statement.getUpdateCount();
            if (linhas == 0) {
                throw new RegistroNaoEncontradoException(
                        "Nenhum registro contém esse id."
                );
            }
        }
    }

    public List<Equipamento> read() throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_SQL);
                ResultSet resultSet = statement.executeQuery()
        ) {
            List<Equipamento> equipamentos = new ArrayList<>();
            while (resultSet.next()) {
                equipamentos.add(new Equipamento(
                        resultSet.getInt("id_equipamento"),
                        resultSet.getString("nome_equipamento"),
                        resultSet.getString("categoria_equipamento"),
                        resultSet.getString("patrimonio_equipamento"),
                        resultSet.getString("status_equipamento"),
                        resultSet.getDouble("valor_equipamento")
                ));
            }

            return equipamentos;
        }
    }

    public Equipamento readById(int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READBYID_SQL)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Equipamento(
                        resultSet.getInt("id_equipamento"),
                        resultSet.getString("nome_equipamento"),
                        resultSet.getString("categoria_equipamento"),
                        resultSet.getString("patrimonio_equipamento"),
                        resultSet.getString("status_equipamento"),
                        resultSet.getDouble("valor_equipamento")
                );
            } else {
                throw new RegistroNaoEncontradoException(
                        "Nenhum registro encontrado com esse id!"
                );
            }
        }
    }

    public void update(Equipamento equipamento, int id) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)
        ) {

            statement.setString(1, equipamento.getNome());
            statement.setString(2, equipamento.getCategoria());
            statement.setString(3, equipamento.getPatrimonio());
            statement.setString(4, equipamento.getStatus());
            statement.setDouble(5, equipamento.getValor());
            statement.setInt(6, id);

            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException, RegistroNaoEncontradoException {
        try (
                Connection conexao = dataSource.getConnection();
                PreparedStatement statement = conexao.prepareStatement(DELETE_SQL)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();

            int linhas = statement.getUpdateCount();
            if (linhas == 0) {
                throw new RegistroNaoEncontradoException(
                        "Nenhum registro foi deletado!"
                );
            }
        }
    }
}
