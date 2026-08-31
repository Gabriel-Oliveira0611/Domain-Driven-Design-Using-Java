package br.com.fiap.apostila13.view;

import br.com.fiap.apostila13.dao.ProdutoDao;

import java.util.Scanner;

public class ExemploDelete {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            ProdutoDao dao = new ProdutoDao();

            System.out.println("Digite o id do produto a ser deletado:");
            int id = input.nextInt();

            dao.delete(id);
            System.out.println("Registro eliminado com sucesso.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
