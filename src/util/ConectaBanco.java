package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBanco {

    public static Connection getConexao() {

        try {

            String url = "jdbc:mysql://localhost:3306/dbloja";
            String usuario = "root";
            String senha = "";

            Connection con = DriverManager.getConnection(url, usuario, senha);

            return con;

        } catch (Exception e) {

            throw new RuntimeException("Erro na conexão: " + e);

        }

    }
}