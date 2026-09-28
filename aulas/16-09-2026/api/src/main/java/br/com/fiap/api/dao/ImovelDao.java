package br.com.fiap.api.dao;

import br.com.fiap.api.model.Imovel;
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

    public Imovel buscarImovel(int id) throws SQLException {
        String sql = "select * from T_API_IMOVEL where cd_imovel = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Imovel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4)
                );
            }
        }

        return null;
    }

    public List<Imovel> listarImovel() throws SQLException {
        String sql = "select * from T_API_IMOVEL";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            List<Imovel> imovels = new ArrayList<>();
            while (rs.next()) {
                imovels.add(new Imovel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4)
                ));
            }
            return imovels;
        }
    }

    public void atualizarImovel(Imovel imovel) throws SQLException {
        String sql = "update T_API_IMOVEL set DS_IMOVEL = ?, NR_DIMENSAO = ?, VL_IMOVEL = ? where cd_imovel = ?;";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, imovel.getDescricao());
            stmt.setInt(2, imovel.getDimensao());
            stmt.setDouble(3, imovel.getValor());
            stmt.setInt(4, imovel.getCodigo());

            stmt.executeUpdate();
        }
    }

    public void deletarImovel(int id) throws SQLException {
        String sql = "delete from T_API_IMOVEL where cd_imovel = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

}
