package br.com.fiap.portal.view;

import br.com.fiap.portal.model.Aluno;
import br.com.fiap.portal.model.Endereco;

import javax.swing.*;

public class Terminal {
    static void main(String[] args) {

        // leitura dos valores
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        String cpf = JOptionPane.showInputDialog("Digite seu cpf:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade:"));
        int rm = Integer.parseInt(JOptionPane.showInputDialog("Digite seu RM:"));
        String turma = JOptionPane.showInputDialog("Digite seu turma:");
        String logradouro = JOptionPane.showInputDialog("Digite seu logradouro:");
        String complemento = JOptionPane.showInputDialog("Digite o complemento:");

        // Criação do objeto
        Endereco endereco = new Endereco(
                logradouro,
                complemento
        );
        Aluno gabriel = new Aluno(
                nome,
                cpf,
                idade,
                endereco,
                rm,
                turma
        );

        // Exibição dos dados
        JOptionPane.showMessageDialog(null,
                "Segue abaixo os dados: " +
                        "\n -> Nome: " + gabriel.getNome() +
                        "\n -> Seu CPF: " + gabriel.getCpf() +
                        "\n -> Sua idade: " + gabriel.getIdade() + " anos +" +
                        "\n -> RM: " + gabriel.getRm() +
                        "\n -> Turma: " + gabriel.getTurma() +
                        "\n -> Logradouro: " + endereco.getLogradouro() +
                        "\n -> Complemento: " + endereco.getComplemento());
    }
}
