package br.com.bukan.view;

import br.com.bukan.dao.InstrutorDao;
import br.com.bukan.model.Instrutor;

import java.util.Scanner;

public class TesteCadastrar {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            InstrutorDao dao = new InstrutorDao();

            System.out.println("Insira abaixo o id:");
            int id = input.nextInt();

            System.out.println("Insira abaixo o nome:");
            String nome = input.next() + input.nextLine();

            System.out.println("Insira o cpf:");
            String cpf = input.next();

            System.out.println("Insira a idade:");
            int idade = input.nextInt();

            System.out.println("Insira a faixa:");
            String faixa  = input.next();

            System.out.println("Insira o nível:");
            String nivel  = input.next();

            Instrutor instrutor01 = new Instrutor(
                    id, nome, cpf, idade, faixa, nivel
            );

            dao.cadastrar(instrutor01);
            System.out.println("Instrutor cadastrado com sucesso.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
