package br.com.fiap.apostila13.view;

import br.com.fiap.apostila13.dao.ProdutoDao;
import br.com.fiap.apostila13.model.Produto;

import javax.swing.*;
import java.sql.SQLException;

public class ExemploCadastro {

    static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Ler os dados do produto
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                        "Insira abaixo o código do produto:"
                )
        );
        String nome = JOptionPane.showInputDialog(
                "Insira abaixo o nome do produto:"
        );
        String descricao = JOptionPane.showInputDialog(
                "Insira abaixo a descrição do produto:"
        );
        double valor = Double.parseDouble(JOptionPane.showInputDialog(
                "Insira abaixo o valor do produto:"
        ));
        boolean temEstoque = Boolean.parseBoolean(JOptionPane.showInputDialog(
                "Tem esse produto no estoque? (true or false)"
        ));

//        Instanciar um Produto com os dados
        Produto produto01 = new Produto(
                codigo,
                nome,
                descricao,
                valor,
                temEstoque
        );

//        Instanciar um ProdutoDao
        ProdutoDao dao = new ProdutoDao();

//        Chamar o método de cadastro
        dao.cadastrar(produto01);
        System.out.println("Produto cadastrado com sucesso.");
    }
}
