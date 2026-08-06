package br.com.fiap.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Exemplo01 {
    static void main(String[] args) {

        // Criar uma variavel para armazenar o nome da turma
        String nomeDaTurma = "1TDSPW";

        List<String> alunos = new ArrayList<>();
        // Adicionar dois nomes na lista

        alunos.add("Gabriel");
        alunos.add("José das Couves");
        alunos.add(
                1,
                "Julia"
        );
        alunos.set(1, "Adalto");

        //Recuperar um aluno da posição 2
        System.out.println(alunos.get(2));

        //Exibir quantos alunos tem na lista
        System.out.println(alunos.size());

        //Verificar se o "Gabriel" está
        if (alunos.contains("Gabriel"))
            JOptionPane.showMessageDialog(
                    null,
                    "Existe");
        else
            JOptionPane.showMessageDialog(
                    null,
                    "Não existe");

        //Verificar se a lista está vazia
        if (alunos.isEmpty())
            JOptionPane.showMessageDialog(
                    null,
                    "é vazia");
        else
            JOptionPane.showMessageDialog(
                    null,

                    "Não é vazia");

        // Exibir todos os alunos
        System.out.println(alunos);
    }
}
