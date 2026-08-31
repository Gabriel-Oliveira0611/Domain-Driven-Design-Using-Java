package view;

import dao.AlunoDao;
import model.Aluno;

import javax.swing.*;

public class testeBuscar {

    static void main(String[] args) {

        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno:"));

            AlunoDao dao = new AlunoDao();
            Aluno aluno01 = dao.buscar(id);

            System.out.println(
                    "-> Nome: " + aluno01.getNome() + "\n" +
                            "-> E-mail: " + aluno01.getEmail() + "\n" +
                            "-> Idade: " + aluno01.getIdade()
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
