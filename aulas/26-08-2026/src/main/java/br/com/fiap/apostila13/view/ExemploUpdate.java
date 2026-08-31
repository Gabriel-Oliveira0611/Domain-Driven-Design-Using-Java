package br.com.fiap.apostila13.view;

import br.com.fiap.apostila13.dao.ProdutoDao;
import br.com.fiap.apostila13.model.Produto;

import java.util.Scanner;

public class ExemploUpdate {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            ProdutoDao dao = new ProdutoDao();

            System.out.println("Digite o id do produto:");
            int idBusca = input.nextInt();

            Produto produtoBuscado = dao.buscar(idBusca);

            int opcao;
            do {
                System.out.println("""
                        Escolha uma das opções abaixo:
                        
                        -> 01: Alterar nome.
                        -> 02: Alterar descrição.
                        -> 03: Alerar valor.
                        -> 04: Alterar situção.
                        -> 05: Finalizar.
                        """);
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o novo nome do produto:");
                        produtoBuscado.setNome(input.next());

                        dao.update(produtoBuscado);
                        System.out.println("Produto alterado com sucesso!");
                        break;

                    case 2:
                        System.out.println("Digite a nova descrição do produto:");
                        produtoBuscado.setDescricao(input.next() + input.nextLine());

                        dao.update(produtoBuscado);
                        System.out.println("Produto alterado com sucesso!");
                        break;

                    case 3:
                        System.out.println("Digite o novo valor do produto:");
                        produtoBuscado.setValor(input.nextDouble());

                        dao.update(produtoBuscado);
                        System.out.println("Produto alterado com sucesso!");
                        break;

                    case 4:
                        System.out.println("Digite a nova situação de estoque (true = tem / false = não tem");
                        produtoBuscado.setTemEstoque(input.nextBoolean());

                        dao.update(produtoBuscado);
                        System.out.println("Produto alterado com sucesso!");
                        break;

                    case 5:
                        System.out.println("Finalizando...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (opcao != 5);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
