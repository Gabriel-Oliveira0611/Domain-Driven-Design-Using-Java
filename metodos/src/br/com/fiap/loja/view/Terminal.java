package br.com.fiap.loja.view;

import java.util.Scanner;
import br.com.fiap.loja.model.Produto;

public class Terminal {

    static void main() {
        // Criação da função de inserção de dados
        Scanner leitor = new Scanner(System.in);

        // Criação do produto
        Produto p = new Produto();

        // Inserção de dados por parte do usuário
        System.out.println("Qual é o nome do produto?");
        String nome = leitor.next()  + leitor.nextLine();

        System.out.println("Qual é a quantidade?");
        int quantidade = leitor.nextInt();

        System.out.println("Qual o valor unitário?");
        double precoUnitario = leitor.nextDouble();

        // Atribuição dos dados ao produto
        p.nome = nome;
        p.quantidade = quantidade;
        p.precoUnitario = precoUnitario;

        // Execução do método
        double precoTotal = p.calcularPrecoTotal();

        // Exibição dos dados
        System.out.println("Segue resumo abaixo:");
        System.out.println("_______________________");
        System.out.println("Nome do produto: " + nome);
        System.out.println("_______________________");
        System.out.println("Quantidade solicitada: " + quantidade);
        System.out.println("_______________________");
        System.out.println("Preço uniário: R$" + precoUnitario);
        System.out.println("_______________________");
        System.out.println("Preço total: R$" + precoTotal);
    }

}
