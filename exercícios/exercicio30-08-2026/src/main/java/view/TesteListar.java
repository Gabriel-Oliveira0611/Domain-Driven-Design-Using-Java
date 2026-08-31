package view;

import dao.AlunoDao;
import model.Aluno;

import java.util.List;

public class TesteListar {

    static void main(String[] args) {

        try {
            AlunoDao dao = new AlunoDao();

            List<Aluno> alunos = dao.listar();

            for (Aluno aluno : alunos) {
                System.out.println(aluno.getNome());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
