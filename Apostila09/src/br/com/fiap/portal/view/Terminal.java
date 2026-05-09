package br.com.fiap.portal.view;

import br.com.fiap.portal.model.Aluno;
import br.com.fiap.portal.model.Endereco;

import javax.swing.*;
import java.util.Scanner;

public class Terminal {
    static void main(String[] args) {
        // Criação do objeto
        Aluno gabriel = new Aluno();
        Endereco endereco = new Endereco();

        // leitura dos valores
        String nomePessoa = JOptionPane.showInputDialog("Digite seu nome:");
        String cpfPessoa = JOptionPane.showInputDialog("Digite seu cpf:");
        int idadePessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade:"));
        int rmAluno = Integer.parseInt(JOptionPane.showInputDialog("Digite seu RM:"));
        String turmaAluno = JOptionPane.showInputDialog("Digite seu turma:");
        String logradouroEndereco = JOptionPane.showInputDialog("Digite seu logradouro:");
        String complementoEndereco = JOptionPane.showInputDialog("Digite o complemento:");

        // Atribuição dos valores
        gabriel.setNomePessoa(nomePessoa);
        gabriel.setCpfPessoa(cpfPessoa);
        gabriel.setIdadePessoa(idadePessoa);
        gabriel.setRmALuno(rmAluno);
        gabriel.setTurmaAluno(turmaAluno);
        endereco.setLogradouroEndereco(logradouroEndereco);
        endereco.setComplementoEndereco(complementoEndereco);

        // Exibição dos dados
        JOptionPane.showMessageDialog(null,
                "Segue abaixo os dados: " +
                        "\n -> Nome: " + nomePessoa +
                        "\n -> Seu CPF: " + cpfPessoa +
                        "\n -> Sua idade: " + idadePessoa + " anos +" +
                        "\n -> RM: " + rmAluno +
                        "\n -> Turma: " + turmaAluno +
                        "\n -> Logradouro: " + logradouroEndereco +
                        "\n -> Complemento: " + complementoEndereco);
    }
}
