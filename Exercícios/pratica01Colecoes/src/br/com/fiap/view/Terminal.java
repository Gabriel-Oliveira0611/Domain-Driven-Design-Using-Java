package br.com.fiap.view;

import br.com.fiap.model.Aluno;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Terminal {
    static Map<Integer, Aluno> mapAlunos = new HashMap<>();

    static void main(String[] args) {
        // Criaão dos objetos.

        Aluno aluno01 = new Aluno(
                "Gabriel",
                24,
                572262,
                9.0,
                8.5);

        Aluno aluno02 = new Aluno(
                "Roberto",
                40,
                572263,
                9.5,
                8.5);

        Aluno aluno03 = new Aluno(
                "Júlia",
                26,
                572264,
                8.7,
                9.0);

        Aluno aluno04 = new Aluno(
                "Carolina",
                20,
                572265,
                9.5,
                7.8);

        Aluno aluno05 = new Aluno(
                "Carlos",
                36,
                572266,
                9.6,
                8.5);

        mapAlunos.put(aluno01.getRm(), aluno01);
        mapAlunos.put(aluno02.getRm(), aluno02);
        mapAlunos.put(aluno03.getRm(), aluno03);
        mapAlunos.put(aluno04.getRm(), aluno04);
        mapAlunos.put(aluno05.getRm(), aluno05);

        for (Integer key : mapAlunos.keySet()) {
            System.out.println("Rm: " + mapAlunos.get(key).getRm());
        }

        launch();
    }

    static void administrarAlunos() {
        String name;
        int age;
        int rm;
        double nota1;
        double nota2;

        int option;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Seja bem-vindo ao sistema de controle de alunos.\n" +
                            "Selecione uma das opções abaixo:\n" +
                            "\n" +
                            "-> 1: Cadastrar aluno\n" +
                            "-> 2: Prosseguir"));

            switch (option) {
                case 1:
                    name = JOptionPane.showInputDialog(null, "Insira o nome do(a) aluno(a):");
                    age = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a idade do(a) aluno(a):"));
                    rm = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o rm do(a) aluno(a):"));
                    nota1 = Double
                            .parseDouble(JOptionPane.showInputDialog(null, "Insira a primeira nota do(a) aluno(a)"));
                    nota2 = Double
                            .parseDouble(JOptionPane.showInputDialog(null, "Insira a segunda nota do(a) aluno(a):"));

                    mapAlunos.put(rm, new Aluno(
                            name,
                            age,
                            rm,
                            nota1,
                            nota2));
                    break;

                case 2:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        } while (option != 2);
    }

    static void launch() {
        administrarAlunos();

        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Seja bem-vindo ao sistema de administração de alunos.\n" +
                            "-> Total de alunos cadastrados: " + mapAlunos.size() + "\n" +
                            "-> Média geral de notas: " + mostrarMediaNotas() + "\n" +
                            "-> Média geral de idade: " + mostrarMediaIdade() + "\n" +
                            "-> Maior idade registrada: " + mostrarMaiorIdade() + "\n" +
                            "-> Menor idade registrada: " + mostrarMenorIdade() + "\n" +
                            "\n" +
                            "Escolha uma das opções abaixo:\n" +
                            "\n" +
                            "-> 1: Ver nomes e médias de todos os alunos.\n" +
                            "-> 2: Ver alunos que possuem média maior que 6.0.\n" +
                            "-> 3: Ver alunos que tem idade acima de 30 anos.\n" +
                            "-> 4: Excluir alunos com médias menores que 3.0.\n" +
                            "-> 5: Sair do sistema."));

            switch (option) {
                case 1:
                    mostrarNomesEMedias();
                    break;

                case 2:
                    mostrarNomesAprovados();
                    break;

                case 3:
                    mostrarAlunosMaiorDe30();
                    break;

                case 4:
                    excluirReprovados();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }

        } while (option != 5);
    }

    static int mostrarTotalAlunos() {
        return mapAlunos.size();
    }

    static double mostrarMediaNotas() {
        double totalNotas = 0;
        int quantidadeNotas = 0;
        for (Integer aluno : mapAlunos.keySet()) {
            totalNotas += mapAlunos.get(aluno).getNota1();
            totalNotas += mapAlunos.get(aluno).getNota2();

            quantidadeNotas += 2;
        }

        double resultado = totalNotas / quantidadeNotas;
        return resultado;
    }

    static double mostrarMediaIdade() {
        double totalIdades = 0;
        int quantidadeIdades = 0;
        for (Integer aluno : mapAlunos.keySet()) {
            totalIdades += mapAlunos.get(aluno).getAge();

            quantidadeIdades++;
        }

        double resultado = totalIdades / quantidadeIdades;
        return resultado;
    }

    static int mostrarMaiorIdade() {
        int maiorIdade = 0;
        for (Integer aluno : mapAlunos.keySet()) {
            if (mapAlunos.get(aluno).getAge() > maiorIdade) {
                maiorIdade = mapAlunos.get(aluno).getAge();
            }
        }

        return maiorIdade;
    }

    static int mostrarMenorIdade() {
        int menorIdade = 999;
        for (Integer aluno : mapAlunos.keySet()) {
            if (mapAlunos.get(aluno).getAge() < menorIdade) {
                menorIdade = mapAlunos.get(aluno).getAge();
            }

        }
        return menorIdade;
    }

    static void mostrarNomesEMedias() {
        String name;
        String resultado = "";

        for (Integer aluno : mapAlunos.keySet()) {
            name = mapAlunos.get(aluno).getName();
            double media = (mapAlunos.get(aluno).getNota1() + mapAlunos.get(aluno).getNota2()) / 2;

            resultado += "Nome: " + name + ". média: " + media + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    static void mostrarNomesAprovados() {
        String resultado = "Abaixo está o nome dos alunos com média acima de 6.0:\n";

        for (Integer aluno : mapAlunos.keySet()) {
            double media = (mapAlunos.get(aluno).getNota1() + mapAlunos.get(aluno).getNota2()) / 2;

            if (media > 6.0) {
                resultado += "-> " + mapAlunos.get(aluno).getName() + ". Média:  " + media + "\n";
            }

        }

        JOptionPane.showMessageDialog(null, resultado);

    }

    static void mostrarAlunosMaiorDe30() {
        String resultado = "Abaixo está a lista de alunos com mais de 30 anos:\n";

        for (Integer aluno : mapAlunos.keySet()) {
            if (mapAlunos.get(aluno).getAge() > 30) {
                resultado += "-> " + mapAlunos.get(aluno).getName() + ". Idade: " + mapAlunos.get(aluno).getAge()
                        + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    static void excluirReprovados() {
        String relatorio = "Os seguintes alunos foram excluídos.\n";

        for (Integer aluno : mapAlunos.keySet()) {
            double media = (mapAlunos.get(aluno).getNota1() + mapAlunos.get(aluno).getNota2()) / 2;
            if (media < 3.0) {
                relatorio += "-> Nome: " + mapAlunos.get(aluno).getName() + ". Média: " + media + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, relatorio);
        List<Integer> removidos = new ArrayList<>();

        for (Integer aluno : mapAlunos.keySet()) {
            double media = (mapAlunos.get(aluno).getNota1() + mapAlunos.get(aluno).getNota2()) / 2;
            if (media < 3.0) {
                removidos.add(aluno);
            }
        }

        for (Integer aluno : removidos) {
            mapAlunos.remove(aluno);
        }
    }

}
