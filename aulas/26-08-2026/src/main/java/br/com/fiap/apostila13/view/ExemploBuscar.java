package br.com.fiap.apostila13.view;

import br.com.fiap.apostila13.dao.ProdutoDao;
import br.com.fiap.apostila13.model.Produto;

import javax.swing.*;

public class ExemploBuscar {

    static void main(String[] args) {

        try {
            ProdutoDao dao = new ProdutoDao();
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto:"));

            Produto produto01 = dao.buscar(id);

            System.out.println(
                    "-> Nome: " + produto01.getNome() + "\n" +
                            "-> Descrição: " + produto01.getDescricao() + "\n" +
                            "-> Valor: R$" + produto01.getValor() + "\n" +
                            "-> Tem em estoque? " + produto01.isTemEstoque()
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
