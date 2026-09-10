package br.com.fiap.apostila13.view;

import br.com.fiap.apostila13.dao.ProdutoDao;
import br.com.fiap.apostila13.model.Produto;

import javax.swing.*;
import java.util.List;

public class TesteBuscarValor {

    static void main(String[] args) {

        double valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor:"));

        try {
            ProdutoDao dao = new ProdutoDao();

            List<Produto> listaValor = dao.buscarPeloValor(valor);

            for (Produto produto : listaValor) {
                System.out.println(produto.getNome() + ": R$" + produto.getValor());
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
