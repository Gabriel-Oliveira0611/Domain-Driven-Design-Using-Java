package view;

import dao.AlunoDao;
import model.Aluno;

import java.util.Scanner;

public class TesteUpdate {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

//        Create
        try {
//            Criar o aluno
            AlunoDao dao = new AlunoDao();

            System.out.println("Insira abaixo o id:");
            int id =  input.nextInt();

            System.out.println("Insira o nome do aluno:");
            String nome = input.next();

            System.out.println("Insira o email do aluno:");
            String email = input.next();

            System.out.println("Insira o idade do aluno:");
            int idade = input.nextInt();

            Aluno alunoTeste = new Aluno(id, nome,email,idade);
//            Cadatsrar o aluno
            dao.cadastrar(alunoTeste);
            System.out.println("Aluno cadastrado com Sucesso.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

//        Read
        try {
//            Buscar o aluno

            AlunoDao dao = new AlunoDao();
            System.out.println("Insira o id do aluno:");
            int id  = input.nextInt();

            Aluno alunoBuscado = dao.buscar(id);

            System.out.println("Aluno Econtrado.");

            System.out.println(
                    "-> Nome: " + alunoBuscado.getNome() + "\n" +
                            "-> E-mail: " + alunoBuscado.getEmail() + "\n" +
                            "-> Idade: " + alunoBuscado.getIdade()
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

//        Update
        try {
            AlunoDao dao = new AlunoDao();

            System.out.println("Insira o id do aluno:");
            int id  = input.nextInt();

            Aluno alunoBuscado = dao.buscar(id);

            System.out.println("Aluno Econtrado.");

            System.out.println(
                    "-> Nome: " + alunoBuscado.getNome() + "\n" +
                            "-> E-mail: " + alunoBuscado.getEmail() + "\n" +
                            "-> Idade: " + alunoBuscado.getIdade()
            );

            System.out.println("Insira abaixo uma nova idade:");
            alunoBuscado.setIdade(input.nextInt());

            dao.cadastrar(alunoBuscado);
            System.out.println("Registro alterado com Sucesso.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
