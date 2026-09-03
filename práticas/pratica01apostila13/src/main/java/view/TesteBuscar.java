package view;

import dao.AlunoDao;
import model.Aluno;

import java.util.Scanner;

public class TesteBuscar {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            AlunoDao dao = new AlunoDao();

            System.out.println("Insira os dados do aluno:");

            System.out.println("Insira o ID:");
            int id = input.nextInt();

            System.out.println("Insira o RM:");
            String rm = input.next() + input.nextLine();

            System.out.println("Insira o nome:");
            String nome = input.next() + input.nextLine();

            System.out.println("O aluno está ativo? (true/false");
            Boolean ativo = input.nextBoolean();

            System.out.println("Insira a primeira nota");
            double nota1 = input.nextDouble();

            System.out.println("Insira a segunda nota");
            double nota2 = input.nextDouble();

            Aluno alunoTeste = new Aluno(
                    id, rm, nome, ativo, nota1, nota2
            );

            dao.cadastrar(alunoTeste);
            System.out.println("Aluno cadastrado com sucesso.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
