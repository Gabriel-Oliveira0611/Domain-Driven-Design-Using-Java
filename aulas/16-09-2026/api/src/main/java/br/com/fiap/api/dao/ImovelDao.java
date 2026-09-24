package br.com.fiap.api.dao;

import br.com.fiap.api.model.Imovel;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ImovelDao {

    private final DataSource dataSource;

    public ImovelDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserir(Imovel imovel) throws SQLException {
        String sql = "insert into t_api_imovel (cd_imovel, ds_imovel, nr_dimensao, vl_imovel) values (sq_t_api_imoveis.nextval, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"cd_imovel"})
        ) {
            stmt.setString(1, imovel.getDescricao());
            stmt.setInt(2, imovel.getDimensao());
            stmt.setDouble(3, imovel.getValor());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                imovel.setCodigo(rs.getInt(1));
            }
        }
    }

    public Imovel buscar(int id) {
        String sql = "select * from t_api_imovel where cd_imovel = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setCodigo(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
