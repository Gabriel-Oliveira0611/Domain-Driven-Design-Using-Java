package br.com.bukan.view;

import br.com.bukan.dao.InstrutorDao;
import br.com.bukan.model.Instrutor;

import java.util.Scanner;

public class TesteBuscar {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            InstrutorDao dao = new InstrutorDao();

            System.out.println("Insira abaixo o id do instrutor:");
            int id = input.nextInt();

            Instrutor instrutor = dao.buscar(id);

            System.out.println("Instrutor encontrado com sucesso.");
            System.out.println(
                    "-> Nome: " + instrutor.getNome() + "\n" +
                            "-> CPF: " + instrutor.getCpf() + "\n" +
                            "-> Idade: " + instrutor.getIdade() + "\n" +
                            "-> Faixa: " + instrutor.getFaixa() + "\n" +
                            "-> Nível: " + instrutor.getNivel()
            );

            int opcao;
            do {
                System.out.println(
                        """
                                Deseja alterar alguma informação?
                                -> 01: Alterar nome.
                                -> 02: Alterar CPF.
                                -> 03: Alterar idade.
                                -> 04: Alterar faixa.
                                -> 05: Alterar nível.
                                -> 06: Não alterar nada.
                                """
                );
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Insira o novo nome:");
                        String nome = input.next() + input.nextLine();

                        instrutor.setNome(nome);
                        dao.update(instrutor);

                        System.out.println("Registro alterado com sucesso.");
                        break;

                    case 2:
                        System.out.println("Insira o novo CPF:");
                        String cpf = input.next();

                        instrutor.setCpf(cpf);
                        dao.update(instrutor);

                        System.out.println("Registro alterado com sucesso.");
                        break;

                    case 3:
                        System.out.println("Insira a nova idade:");
                        int idade = input.nextInt();

                        instrutor.setIdade(idade);
                        dao.update(instrutor);

                        System.out.println("Registro alterado com sucesso.");
                        break;

                    case 4:
                        System.out.println("insira a nova faixa:");
                        String faixa = input.next();

                        instrutor.setFaixa(faixa);
                        dao.update(instrutor);

                        System.out.println("Registro alterado com sucesso.");
                        break;

                    case 5:
                        System.out.println("Insira o novo nível:");
                        String nivel = input.next();

                        instrutor.setNivel(nivel);
                        dao.update(instrutor);

                        System.out.println("Registro alterado com sucesso.");
                        break;

                    case 6:
                        System.out.println("Encerrando o sistema.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (opcao != 6);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
