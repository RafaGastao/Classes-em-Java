package Modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Categoria;
import util.ConectaBanco;

public class CategoriaDao {

    private static final String LISTAR = "SELECT * FROM categorias";

    public List<Categoria> listarTodas() {

        ResultSet rs = null;
        Statement stmt = null;
        Connection con = null;
        List<Categoria> categs = new ArrayList<>();

        try {

            con = ConectaBanco.getConexao();
            stmt = con.createStatement();
            rs = stmt.executeQuery(LISTAR);

            while (rs.next()) {

                Categoria cat = new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome")
                );

                categs.add(cat);
            }

        } catch (SQLException err1) {

            throw new RuntimeException(err1);

        } finally {

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException err2) {
                throw new RuntimeException(err2);
            }

        }

        return categs;
    }

    public void inserir(Categoria cat) {

        Connection con = null;
        Statement stmt = null;

        try {

            con = ConectaBanco.getConexao();
            stmt = con.createStatement();

            String sql = "INSERT INTO categorias (id, nome) VALUES (" 
                    + cat.getId() + ", '" + cat.getNome() + "')";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}