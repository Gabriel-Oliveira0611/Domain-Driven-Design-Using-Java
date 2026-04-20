package br.com.fiap.empresa.view;

import br.com.fiap.empresa.model.Profissao;
import br.com.fiap.empresa.model.Funcionario;

import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) {
        // Criação da função leitor
        Scanner leitor = new Scanner(System.in);

        // Criação dos valores
        System.out.println("Digite o nome: ");
        String nome = leitor.next() + leitor.nextLine();

        System.out.println("Digite a matricula:");
        long matricula = leitor.nextLong();

        System.out.println("Digite o nome da profissao:");
        String nomeProfissao = leitor.next() + leitor.nextLine();

        System.out.println("Digite o salário:");
        double salario = leitor.nextDouble();

        // Criação dos objetos
        Profissao profissao1 = new Profissao(nomeProfissao);
        System.out.println(profissao1.getNome());

        Funcionario funcionario1 = new Funcionario(matricula, nome, profissao1);

        funcionario1.exibirDados();
        System.out.println(funcionario1.exibirDados());
    }

}
