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

    private static final String LISTAR = "SELECT * FROM dbloja.categorias";

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
                if (con != null) con.close();
                if (stmt != null) stmt.close();
            } catch (SQLException err2) {
                throw new RuntimeException(err2);
            }

        }

        return categs;
    }
}