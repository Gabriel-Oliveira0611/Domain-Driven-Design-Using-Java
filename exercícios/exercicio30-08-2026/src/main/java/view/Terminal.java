package view;

import dao.AlunoDao;
import model.Aluno;

import javax.swing.*;

public class Terminal {

    static void main(String[] args) {

        int id = Integer.parseInt(JOptionPane.showInputDialog(
                "Insira abaixo o id:"
        ));
        String nome = JOptionPane.showInputDialog(
                "Insira abaixo o nome:"
        );
        String email  = JOptionPane.showInputDialog(
                "Insira email:"
        );
        int idade = Integer.parseInt(JOptionPane.showInputDialog(
                "Insira idade:"
        ));

        Aluno aluno = new Aluno(id, nome, email, idade);

        try {
            AlunoDao dao = new AlunoDao();
            dao.cadastrar(aluno);

            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
