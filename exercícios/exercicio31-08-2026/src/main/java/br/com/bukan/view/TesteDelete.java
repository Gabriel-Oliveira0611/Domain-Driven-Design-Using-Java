package br.com.bukan.view;

import br.com.bukan.dao.InstrutorDao;

import java.util.Scanner;

public class TesteDelete {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            InstrutorDao dao = new InstrutorDao();

            System.out.println("Insira abaixo o id do instrutor a ser removido:");
            int id = input.nextInt();

            dao.delete(id);
            System.out.println("Instrutor removido com sucesso.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
