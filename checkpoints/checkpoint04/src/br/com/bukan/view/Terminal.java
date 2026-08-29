package br.com.bukan.view;

import br.com.bukan.dao.MemberDao;
import br.com.bukan.model.Instructor;
import br.com.bukan.model.Member;
import br.com.bukan.model.Student;

import javax.swing.*;

import static br.com.bukan.dao.MemberDao.integrantes;

public class Terminal {

    static void main(String[] args) {

//        Criação de integrantes teste

        Member gabriel = new Instructor(
                "11111111111",
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

        Member joana = new Student(
                "00078900078",
                "Joana Ogawa",
                "amarela",
                "11978945612",
                26,
                "01/05/2025",
                "Básico",
                true
        );

//        Inserção dos membros na lista
        integrantes.put(gabriel.getCpf(), gabriel);
        integrantes.put(rodrigo.getCpf(), rodrigo);
        integrantes.put(joana.getCpf(), joana);


        MemberDao.launch();
    }


}
