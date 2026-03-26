package br.com.fiap.loja.view;

import java.util.Scanner;
import br.com.fiap.loja.model.Produto;

public class Terminal {

    static void main() {

        // Criação da função leitor
        Scanner leitor = new Scanner(System.in);

        // Criação do produto
        Produto p = new Produto();

        // Inserção dos valores nos atributos do produto
        System.out.println("Qual é o nome do produto?");
        String nomeProduto = leitor.next() + leitor.nextLine();

        System.out.println("Quantos você quer?");
        int quantidadeProduto = leitor.nextInt();

        System.out.println("Quanto custa cada um?");
        double precoProduto = leitor.nextDouble();

        //Atribuição dos valores no produto
        p.nomeProduto = nomeProduto;
        p.quantidadeProduto = quantidadeProduto;
        p.precoProduto = precoProduto;

        // Criação da variável do método
        double precoTotalProduto;

        // Execução do método
        precoTotalProduto = p.calcularPrecoTotalProduto();

        // Exibição dos atributos
        System.out.println("Nome do produto: " + nomeProduto);
        System.out.println("___________________________");
        System.out.println("Quantidade total: " + quantidadeProduto);
        System.out.println("___________________________");
        System.out.println("Preço unitário: R$" + precoProduto);
        System.out.println("___________________________");
        System.out.println("Preço total do produto: R$" + precoTotalProduto);
    }

}
