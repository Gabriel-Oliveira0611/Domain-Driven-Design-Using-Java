package br.com.bukan.view;

import br.com.bukan.model.Instructor;
import br.com.bukan.model.Member;
import br.com.bukan.model.Student;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Terminal {

    Map<Integer, Member> integrantes = new HashMap<>();

    static void main(String[] args) {

//        Criação de integrantes teste

        Member gabriel = new Instructor(
                "00056500056",
                "Gabriel Pereira",
                "marrom",
                "11987175329",
                24,
                "Sênior",
                3
        );

        Member rodrigo = new Instructor(
                "00023200023",
                "Rodrigo José",
                "preta",
                "11912345678",
                45,
                "Sênior",
                6
        );

        Member Joana = new Student(
                "00078900078",
                "Joana Ogawa",
                "amarela",
                "11978945612",
                26,
                "01/05/2025",
                "Básico",
                true
        );

    }

    static void launch() {

        String opcao = "";

        do {
            JOptionPane.showMessageDialog(
                    null,
                    """
                            Seja bem-vindo ao sistema da Bukan!
                            Selecione uma das opções abaixo:
                            
                            -> 1: Cadastrar integrante
                            -> 2: Listar alunos
                            -> 3: Pesquisar por cpf
                            -> 4: Editar cadastro
                            -> 5: Remover integrante
                            -> 6: Pesquisar por nome
                            -> 7: Sair
                            """
            );

            switch (opcao) {
                case "1":
                    break;

                case
            }
        } while (opcao != "7");

    }
}
