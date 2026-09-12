package br.com.fiap.apostila13.view;

import br.com.fiap.apostila13.dao.ProdutoDao;
import br.com.fiap.apostila13.model.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploBuscaValor {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("""
                    Você está pesquisando por itens no banco de dados com base em um valor.
                    Insira um valor abaixo e o retorno serão os itens com preço maior que o inserido.
                    """);
            double valor = input.nextDouble();

            ProdutoDao dao = new ProdutoDao();

            for (Produto produto : dao.buscarPeloValor(valor)) {
                System.out.println(
                        "-> Item: " + produto.getNome() + "\n" +
                                "-> Valor: R$" + produto.getValor() + "\n"
                );
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
