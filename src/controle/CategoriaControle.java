package controle;

import java.util.ArrayList;
import java.util.List;

import Modelo.Categoria;
import Modelo.dao.CategoriaDao;

public class CategoriaControle {

    public static List<String> listarCategorias() {

        List<String> nomes = new ArrayList<>();

        CategoriaDao dao = new CategoriaDao();

        List<Categoria> categorias = dao.listarTodas();

        for (Categoria c : categorias) {
            nomes.add(c.getNome());
        }

        return nomes;
    }

    public static void inserirCategoria(int id, String nome){

        Categoria cat = new Categoria(id, nome);

        CategoriaDao dao = new CategoriaDao();

        dao.inserir(cat);

    }
}