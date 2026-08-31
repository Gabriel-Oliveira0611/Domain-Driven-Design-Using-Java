package br.com.fiap.apostila13.view;

import br.com.fiap.apostila13.dao.ProdutoDao;
import br.com.fiap.apostila13.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class TesteListar {

    static void main(String[] args) {

        try {
            ProdutoDao dao = new ProdutoDao();

            List<Produto> lista = dao.listar();

            for (Produto produto : lista) {
                System.out.println(produto.getNome());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
