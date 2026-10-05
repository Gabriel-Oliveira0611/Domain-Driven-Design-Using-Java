package br.com.bukan.view;

import br.com.bukan.dao.InstrutorDao;
import br.com.bukan.model.Instrutor;

import java.util.List;
import java.util.Scanner;

public class Terminal {


    public static void main(String[] args) {
        launch();
    }

    public static void launch() {

        Scanner input = new Scanner(System.in);

        String opcao = "";

        do {
            System.out.println("""
                    Seja bem-vindo ao gerenciador de instrutores!
                    Escolha uma das opções abaixo:
                    
                    -> 1: Cadastrar instrutor(a).
                    -> 2: Pesquisar por ID.
                    -> 3: Listar instrutores.
                    -> 4: Atualizar cadastro de instrutor(a).
                    -> 5: Remover instrutor.
                    -> 6: Pesquisar por nome.
                    -> 7: Encerrar sistema.
                    """);

            opcao = input.nextLine();

            switch (opcao) {

                case "1":

                    System.out.println("Digite o nome do instrutor:");
                    String nome = input.nextLine();

                    System.out.println("Digite o CPF do instrutor:");
                    String cpf = input.nextLine();

                    System.out.println("Digite a idade do instrutor:");
                    int idade;

                    try {
                        idade = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Idade inválida.");
                        break;
                    }

                    System.out.println("Digite a faixa atual do instrutor:");
                    String faixa = input.nextLine();

                    System.out.println("Digite o nível do instrutor (junior/avançado/sênior):");
                    String nivel = input.nextLine();

                    try {
                        InstrutorDao dao = new InstrutorDao();

                        dao.cadastrar(new Instrutor(nome, cpf, idade, faixa, nivel));

                        System.out.println("Instrutor(a) cadastrado com sucesso!");

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;


                case "2":

                    System.out.println("Digite o ID do instrutor:");

                    Long id;

                    try {
                        id = Long.parseLong(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                        break;
                    }

                    try {
                        InstrutorDao dao = new InstrutorDao();

                        Instrutor instrutor = dao.buscarPorId(id);

                        System.out.println("Segue abaixo os dados do instrutor:");

                        System.out.println("Nome: " + instrutor.getNome());
                        System.out.println("CPF: " + instrutor.getCpf());
                        System.out.println("Idade: " + instrutor.getIdade());
                        System.out.println("Faixa atual: " + instrutor.getFaixa());
                        System.out.println("Nível: " + instrutor.getNivel());

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;


                case "3":

                    try {
                        InstrutorDao dao = new InstrutorDao();

                        List<Instrutor> lista = dao.listar();

                        if (lista.isEmpty()) {

                            System.out.println("Nenhum instrutor cadastrado.");

                        } else {

                            System.out.println("Segue abaixo a lista de instrutores:");

                            for (Instrutor instrutor : lista) {

                                System.out.println("-> Nome: " + instrutor.getNome() + " - Faixa: " + instrutor.getFaixa() + " - Idade: " + instrutor.getIdade());
                            }
                        }

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;


                case "4":

                    System.out.println("Digite o ID do instrutor a ter o registro alterado:");

                    try {
                        id = Long.parseLong(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                        break;
                    }

                    try {

                        InstrutorDao dao = new InstrutorDao();

                        Instrutor instrutor = dao.buscarPorId(id);

                        String atributo = "";

                        do {
                            System.out.println("""
                                    Selecione qual atributo alterar:
                                    
                                    -> 1: Nome.
                                    -> 2: CPF.
                                    -> 3: Idade.
                                    -> 4: Faixa.
                                    -> 5: Nível.
                                    -> 6: Nenhum.
                                    """);

                            atributo = input.nextLine();

                            switch (atributo) {

                                case "1":

                                    System.out.println("Digite o novo nome:");

                                    String novoNome = input.nextLine();

                                    instrutor.setNome(novoNome);

                                    dao.update(instrutor);

                                    System.out.println("Nome alterado com sucesso.");

                                    break;


                                case "2":

                                    System.out.println("Digite o novo CPF:");

                                    String novoCPF = input.nextLine();

                                    instrutor.setCpf(novoCPF);

                                    dao.update(instrutor);

                                    System.out.println("CPF alterado com sucesso.");

                                    break;


                                case "3":

                                    System.out.println("Digite a nova idade:");

                                    int novaIdade;

                                    try {
                                        novaIdade = Integer.parseInt(input.nextLine());

                                    } catch (NumberFormatException e) {

                                        System.out.println("Idade inválida.");

                                        break;
                                    }

                                    instrutor.setIdade(novaIdade);

                                    dao.update(instrutor);

                                    System.out.println("Idade alterada com sucesso.");

                                    break;


                                case "4":

                                    System.out.println("Digite a nova faixa:");

                                    String novaFaixa = input.nextLine();

                                    instrutor.setFaixa(novaFaixa);

                                    dao.update(instrutor);

                                    System.out.println("Faixa alterada com sucesso.");

                                    break;


                                case "5":

                                    System.out.println("Digite o novo nível do instrutor:");

                                    String novoNivel = input.nextLine();

                                    instrutor.setNivel(novoNivel);

                                    dao.update(instrutor);

                                    System.out.println("Nível alterado com sucesso.");

                                    break;


                                case "6":

                                    System.out.println("Voltando à etapa anterior.");

                                    break;


                                default:

                                    System.out.println("Opção inválida.");

                                    break;
                            }

                        } while (!atributo.equals("6"));

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;


                case "5":

                    System.out.println("Digite o ID do instrutor a remover:");

                    try {
                        id = Long.parseLong(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                        break;
                    }

                    try {

                        InstrutorDao dao = new InstrutorDao();

                        dao.delete(id);

                        System.out.println("Instrutor deletado com sucesso.");

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;


                case "6":

                    System.out.println("Digite o nome do instrutor a ser buscado:");

                    nome = input.nextLine();

                    try {

                        InstrutorDao dao = new InstrutorDao();

                        List<Instrutor> instrutores = dao.buscarPorNome(nome);


                        if (instrutores.isEmpty()) {

                            System.out.println("Nenhum instrutor encontrado.");

                        } else {

                            System.out.println("Esses foram os instrutores encontrados com esse nome:");

                            for (Instrutor instrutor : instrutores) {

                                System.out.println("Nome: " + instrutor.getNome());
                            }
                        }

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;


                case "7":

                    System.out.println("Encerrando o sistema...");

                    break;


                default:

                    System.out.println("Opção inválida!");

                    break;
            }

        } while (!opcao.equals("7"));

        input.close();
    }
}