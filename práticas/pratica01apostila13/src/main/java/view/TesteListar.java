package view;

import dao.AlunoDao;
import model.Aluno;

import java.util.List;

public class TesteListar {

    static void main(String[] args) {

        try {
            AlunoDao dao = new AlunoDao();

            List<Aluno> lista = dao.listar();

            for (Aluno aluno : lista) {
                System.out.println("-> Nome: " + aluno.getNome() + "\n" +
                        "-> RM: " + aluno.getRm() + "\n" +
                        "-> Ativo? " + aluno.isAtivo() + "\n" +
                        "-> Nota 01: " + aluno.getNota1() + "\n" +
                        "-> Nota 02: " + aluno.getNota2() + "\n");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
