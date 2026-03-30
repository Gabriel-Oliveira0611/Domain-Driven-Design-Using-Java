package br.com.fiap.financeiro.view;

import java.util.Scanner;

import br.com.fiap.financeiro.model.Cliente;
import br.com.fiap.financeiro.model.ContaCorrente;
import br.com.fiap.financeiro.model.Endereco;

public class Terminal {

    static void main() {
        // Criação da função de leitor
        Scanner leitor = new Scanner(System.in);

        // Instanciar Produtos das classes
        ContaCorrente contaCorrente = new ContaCorrente();
        Cliente usuario = new Cliente();
        Endereco endereco = new Endereco();

        // Inserção de dados pelo usuário
        System.out.println("Seja bem-vindo ao controle financeiro!\n" +
                "Vamos fazer seu cadastro e acompanhamento financeiro.\n" +
                "Insira abaixo seu nome:");
        usuario.nome = leitor.next() + leitor.nextLine();

        System.out.println("É um prazer, " + usuario.nome + "!\n" +
                "Insira agora seu CPF.");
        usuario.cpf = leitor.next() + leitor.nextLine();

        System.out.println("Perfeitamente, agora preciso saber onde você reside.\n" +
                "Insira abaixo o logradouro.");
        endereco.logradouro = leitor.next() + leitor.nextLine();

        System.out.println("Agora, o número, por favor.");
        endereco.numero = leitor.nextShort();

        System.out.println("Agora, um complemento, por favor.");
        endereco.complemento = leitor.next() + leitor.nextLine();

        System.out.println("Por fim, qual é seu CEP?");
        endereco.cep = leitor.next() + leitor.nextLine();

        System.out.println("Pois bem, " + usuario.nome + "!\n" +
                "Agora, vamos ao acompanhamento financeiro do seu saldo atual.\n" +
                "Quanto você tem em conta agora?");
        contaCorrente.saldo = leitor.nextDouble();

        System.out.println("Perfeitamente, " + usuario.nome + ".\n" +
                "Seu saldo atual é de R$" + contaCorrente.saldo);

        // Adição de saldo
        System.out.println("Vamos adicionar um pouco mais de dinheiro.\n" +
                "Quanto você quer depositar?");
        double aumentarSaldo = leitor.nextDouble();
        contaCorrente.depositar(aumentarSaldo);
        contaCorrente.retornarSaldo();
        System.out.println("Pois bem, " + usuario.nome + ".\n" +
                "Seu saldo após a adição de R$" + aumentarSaldo + ".\n" +
                "é de R$" + contaCorrente.retornarSaldo());

        // Retirada de saldo
        System.out.println("Pois bem, agora vamos sacar um pouco do saldo.\n" +
                "Quanto você quer sacar?");
        double diminuirSaldo = leitor.nextDouble();
        contaCorrente.retirar(diminuirSaldo);
        System.out.println("Pois bem, " + usuario.nome + ".\n" +
                "Seu saldo após o saque de R$" + diminuirSaldo + ".\n" +
                "é de R$" + contaCorrente.retornarSaldo());

        // Retornar saldo
        System.out.println("Agora, " + usuario.nome + ", seu saldo atual é de R$" + contaCorrente.retornarSaldo());

        // Retornar endereço
        System.out.println("Precisamos confirmar seus dados de endereço, segue dados abaixo:");
        String dadosEndereco = "Logradouro: " + endereco.logradouro + "\n" +
                "N° " + endereco.numero + "\n" +
                "Complemento: " + endereco.complemento + "\n" +
                "CEP: " + endereco.cep;
        endereco.retornarEndereco(dadosEndereco);
        System.out.println(dadosEndereco);


        // Retornar dados
        System.out.println("Agora vamos confirmar rapidamente seus dados.\n" +
                "Segue abaixo:");
        String dados = "Nome: " + usuario.nome + ".\n" +
                "CPF: " + usuario.cpf + "\n" + dadosEndereco;
        System.out.println(dados);

    }

}
