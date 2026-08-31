package view;

import dao.AlunoDao;

import java.util.Scanner;

public class TesteDelete {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            AlunoDao dao = new AlunoDao();

            System.out.println("Insira o id do aluno a ser detelado.");
            int id = input.nextInt();

            dao.delete(id);
            System.out.println("Registro deletado com sucesso.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
