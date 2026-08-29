package br.com.bukan.dao;

import br.com.bukan.model.Instructor;
import br.com.bukan.model.Member;
import br.com.bukan.model.Student;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {

    public static Map<String, Member> integrantes = new HashMap<>();

    public static void launch() {

        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    """
                            Seja bem-vindo ao sistema da Bukan!
                            Selecione uma das opções abaixo:
                            
                            -> 1: Cadastrar integrante
                            -> 2: Listar integrantes
                            -> 3: Pesquisar por cpf
                            -> 4: Editar cadastro
                            -> 5: Remover integrante
                            -> 6: Pesquisar por nome
                            -> 7: Sair
                            """
            ));

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    pesquisarPorCodigo();
                    break;

                case 4:
                    editar();
                    break;

                case 5:
                    remover();
                    break;

                case 6:
                    pesquisarPorNome();
                    break;

                case 7:
                    JOptionPane.showMessageDialog(
                            null,
                            "Encerrando o sistema..."
                    );
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida."
                    );
                    break;
            }
        } while (opcao != 7);

    }

    public static void cadastrar() {
        String opcao;

        String cpf;
        String name;
        String belt;
        String phone;
        int age;

        opcao = JOptionPane.showInputDialog(
                """
                        Perfeito! Escolha uma das opções abaixo:
                        
                        -> 1: Cadastrar aluno(a)
                        -> 2: Cadastrar instrutor(a).
                        -> 3: Voltar.
                        """
        );

        switch (opcao) {
            case "1":
                cpf = JOptionPane.showInputDialog(
                        "Insira abaixo o CPF do aluno:"
                );
                name = JOptionPane.showInputDialog(
                        "Insira abaixo o nome do aluno:"
                );
                belt = JOptionPane.showInputDialog(
                        "insira abaixo a faixa atual do aluno:"
                );
                phone = JOptionPane.showInputDialog(
                        "Insira abaixo o número de whatsapp do aluno:"
                );
                age = Integer.parseInt(JOptionPane.showInputDialog(
                        "Insira abaixo a idade do aluno:"
                ));
                String registrationDate = JOptionPane.showInputDialog(
                        "Insira abaixo a data de matrícula do aluno: (dd/mm/aaa)"
                );
                String monthlyPlan = JOptionPane.showInputDialog(
                        "Insira abaixo o plano de assinatura do aluno: (base, premium, max)"
                );
                boolean activeRegistration = Boolean.parseBoolean(JOptionPane.showInputDialog(
                        "Informe abaixo se o aluno está ativo na escola: (true/false)"
                ));

                Member aluno = new Student(
                        cpf,
                        name,
                        belt,
                        phone,
                        age,
                        registrationDate,
                        monthlyPlan,
                        activeRegistration
                );
                integrantes.put(aluno.getCpf(), aluno);

                JOptionPane.showMessageDialog(
                        null,
                        "Aluno(a) " + aluno.getName() + " cadastrado(a) com sucesso!"
                );
                break;

            case "2":
                cpf = JOptionPane.showInputDialog(
                        "Insira abaixo o CPF do instrutor:"
                );
                name = JOptionPane.showInputDialog(
                        "Insira abaixo o nome do instrutor:"
                );
                belt = JOptionPane.showInputDialog(
                        "insira abaixo a faixa atual do instrutor:"
                );
                phone = JOptionPane.showInputDialog(
                        "Insira abaixo o número de whatsapp do instrutor:"
                );
                age = Integer.parseInt(JOptionPane.showInputDialog(
                        "Insira abaixo a idade do instrutor:"
                ));
                String instructionLevel = JOptionPane.showInputDialog(
                        "Insira abaixo o nível de instrução do instrutor: (base, pleno ou sênior)"
                );
                int experienceInYears = Integer.parseInt(JOptionPane.showInputDialog(
                        "Insira quantos anos de experiência tem o instrutor:"
                ));

                Member instrutor = new Instructor(
                        cpf,
                        name,
                        belt,
                        phone,
                        age,
                        instructionLevel,
                        experienceInYears
                );
                integrantes.put(instrutor.getCpf(), instrutor);

                JOptionPane.showMessageDialog(
                        null,
                        "Instrutor(a) " + instrutor.getName() + " cadastrado(a) com sucesso!"
                );
                break;

            case "3":
                JOptionPane.showMessageDialog(
                        null,
                        "Voltando à etapa anterior."
                );
                break;

            default:
                JOptionPane.showMessageDialog(
                        null,
                        "Opção inválida!"
                );
                break;

        }

    }

    public static void listar() {

        if (integrantes.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não existem integrantes cadastrados."
            );
        } else {
            String resultado = "";

            for (String cpf : integrantes.keySet()) {
                Member integrante = integrantes.get(cpf);

                if (integrante instanceof Instructor instrutor) {
                    resultado +=
                            "--> Instrutor(a): " + instrutor.getName() + "\n" +
                                    "-> CPF: " + instrutor.getCpf() + "\n" +
                                    "-> Faixa atual: " + instrutor.getBelt() + "\n" +
                                    "-> Telefone: " + instrutor.getPhone() + "\n" +
                                    "-> Idade: " + instrutor.getAge() + "\n" +
                                    "-> Nível de Instrução: " + instrutor.getInstructonLevel() + "\n" +
                                    "-> Anos de experiência: " + instrutor.getExpeienceInYears() + "\n\n";
                } else if (integrante instanceof Student aluno) {
                    resultado +=
                            "--> Aluno(a): " + aluno.getName() + "\n" +
                                    "-> CPF: " + aluno.getCpf() + "\n" +
                                    "-> Faixa atual: " + aluno.getBelt() + "\n" +
                                    "-> Telefone: " + aluno.getPhone() + "\n" +
                                    "-> Idade: " + aluno.getAge() + "\n" +
                                    "-> Data de matrícula: " + aluno.getRegistrationDate() + "\n" +
                                    "-> Plano de assinatura: " + aluno.getMonthlyPlan() + "\n" +
                                    "-> Aluno ativo? " + aluno.isActiveRegistration() + "\n\n";
                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    resultado
            );

        }

    }

    public static void pesquisarPorCodigo() {
        String cpf = JOptionPane.showInputDialog(
                "Insira o CPF do aluno ou instrutor:"
        );

        if (integrantes.containsKey(cpf)) {
            if (integrantes.get(cpf) instanceof Student aluno) {
                JOptionPane.showMessageDialog(
                        null,
                        "Você pesquisou pelo(a) aluno(a) " + aluno.getName() + "\n" +
                                "Abaixo seguem suas infomações: \n" +
                                "-> CPF: " + aluno.getCpf() + "\n" +
                                "Faixa atual: " + aluno.getBelt() + "\n" +
                                "-> Telefone: " + aluno.getPhone() + "\n" +
                                "-> Idade: " + aluno.getAge() + "\n" +
                                "-> Data de matrícula: " + aluno.getRegistrationDate() + "\n" +
                                "-> Plano de assinatura: " + aluno.getMonthlyPlan() + "\n" +
                                "-> Aluno ativo? " + aluno.isActiveRegistration()
                );
            } else if (integrantes.get(cpf) instanceof Instructor instrutor) {
                JOptionPane.showMessageDialog(
                        null,
                        "--> Você pesquisou pelo Instrutor(a): " + instrutor.getName() + "\n" +
                                "-> CPF: " + instrutor.getCpf() + "\n" +
                                "-> Faixa atual: " + instrutor.getBelt() + "\n" +
                                "-> Telefone: " + instrutor.getPhone() + "\n" +
                                "-> Idade: " + instrutor.getAge() + "\n" +
                                "-> Nível de Instrução: " + instrutor.getInstructonLevel() + "\n" +
                                "-> Anos de experiência: " + instrutor.getExpeienceInYears()
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Não existem nenhum integrante com esse CPF."
            );
        }


    }

    public static void editar() {
        String codigo = JOptionPane.showInputDialog(
                "Insira o CPF do aluno ou instrutor a ser editado:"
        );
        String opcao = "";

        do {
            if (integrantes.get(codigo) instanceof Instructor instrutor) {
                opcao = JOptionPane.showInputDialog(
                        "O(a) instrutor(a) " + instrutor.getName() + " tem os seguintes atributos: \n\n" +
                                "-> Nome \n" +
                                "-> CPF: " + instrutor.getCpf() + "\n" +
                                "-> Faixa atual: " + instrutor.getBelt() + "\n" +
                                "-> Telefone: " + instrutor.getPhone() + "\n" +
                                "-> Idade: " + instrutor.getAge() + "\n" +
                                "-> Nível de instrução: " + instrutor.getInstructonLevel() + "\n" +
                                "-> Anos de experiência: " + instrutor.getExpeienceInYears() + "\n\n" +
                                "Qual desses atributos você deseja alterar? Digite 'nenhum' para não alterar nenhum atributo."
                );

                switch (opcao) {
                    case "nome":
                        String name = JOptionPane.showInputDialog(
                                "Insira abaixo o novo nome:"
                        );
                        instrutor.setName(name);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "CPF", "cpf":
                        String cpf = JOptionPane.showInputDialog(
                                "Insira abaixo o novo cpf:"
                        );
                        instrutor.setCpf(cpf);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "faixa", "faixa atual":
                        String belt = JOptionPane.showInputDialog(
                                "Insira abaixo a nova faixa:"
                        );
                        instrutor.setBelt(belt);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "phone", "telefone", "contato", "whatsapp":
                        String phone = JOptionPane.showInputDialog(
                                "Insira abaixo o novo telefone:"
                        );
                        instrutor.setPhone(phone);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "idade":
                        int idade = Integer.parseInt(JOptionPane.showInputDialog(
                                "Insira abaixo a nova idade:"
                        ));
                        instrutor.setAge(idade);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "nivel de instrução", "nivel":
                        String instructionLevel = JOptionPane.showInputDialog(
                                "Insira abaixo o novo nível de instrução: (base, pleno ou sênior)"
                        );
                        instrutor.setInstructonLevel(instructionLevel);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "experiencia", "anos de experiencia", "xp":
                        int experienceInYears = Integer.parseInt(JOptionPane.showInputDialog(
                                "Insira abaixo o novo tempo de experiência::"
                        ));
                        instrutor.setExpeienceInYears(experienceInYears);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "nenhum":
                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum atributo será alterado!"
                        );
                        break;

                    default:
                        JOptionPane.showMessageDialog(
                                null,
                                "Opção inválida!"
                        );
                        break;
                }

            } else if (integrantes.get(codigo) instanceof Student aluno) {
                opcao = JOptionPane.showInputDialog(
                        "O(a) aluno(a) " + aluno.getName() + " tem os seguintes atributos: \n\n" +
                                "-> Nome: \n" +
                                "-> CPF: " + aluno.getCpf() + "\n" +
                                "-> Faixa atual: " + aluno.getBelt() + "\n" +
                                "-> Telefone: " + aluno.getPhone() + "\n" +
                                "-> Idade: " + aluno.getAge() + "\n" +
                                "-> Data de matrícula: " + aluno.getRegistrationDate() + "\n" +
                                "-> Plano de assinatura: " + aluno.getMonthlyPlan() + "\n" +
                                "-> Aluno ativo? " + aluno.isActiveRegistration() + "\n\n" +
                                "Qual desses atributos você deseja alterar? Digite 'nenhum' para não alterar nenhum atributo."
                );

                switch (opcao) {
                    case "nome":
                        String name = JOptionPane.showInputDialog(
                                "Insira abaixo o novo nome:"
                        );
                        aluno.setName(name);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "CPF":
                        String cpf = JOptionPane.showInputDialog(
                                "Insira abaixo o novo cpf:"
                        );
                        aluno.setCpf(cpf);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "faixa", "faixa atual":
                        String belt = JOptionPane.showInputDialog(
                                "Insira abaixo a nova faixa:"
                        );
                        aluno.setBelt(belt);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "phone", "telefone", "contato", "whatsapp":
                        String phone = JOptionPane.showInputDialog(
                                "Insira abaixo o novo telefone:"
                        );
                        aluno.setPhone(phone);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "idade":
                        int idade = Integer.parseInt(JOptionPane.showInputDialog(
                                "Insira abaixo a nova idade:"
                        ));
                        aluno.setAge(idade);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "data de matricula", "matricula":
                        String registrationDate = JOptionPane.showInputDialog(
                                "Insira abaixo a nova data de matrícula:"
                        );
                        aluno.setRegistrationDate(registrationDate);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "plano de assinatura", "assinatura":
                        String monthlyPlan = JOptionPane.showInputDialog(
                                "Insira abaixo o novo plano de assinatura: (base, premium ou max)"
                        );
                        aluno.setMonthlyPlan(monthlyPlan);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "ativo", "aluno ativo", "situação":
                        boolean activeRegistration = Boolean.parseBoolean(JOptionPane.showInputDialog(
                                "Altere a situação do aluno: (true = ativo / false = inativo)"
                        ));
                        aluno.setActiveRegistration(activeRegistration);

                        JOptionPane.showMessageDialog(
                                null,
                                "Atributo alterado com sucesso."
                        );
                        break;

                    case "nenhum":
                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum atributo será alterado!"
                        );
                        break;

                    default:
                        JOptionPane.showMessageDialog(
                                null,
                                "Opção inválida!"
                        );
                        break;
                }
            }
        } while (!opcao.equalsIgnoreCase("nenhum"));
    }

    public static void remover() {
        String codigo = JOptionPane.showInputDialog(
                "Insira o cpf do integrante a ser removido:"
        );
        String opcao = "";

        if (integrantes.get(codigo) instanceof Instructor instructor) {
            opcao = JOptionPane.showInputDialog(
                    "Você tem certea de que quer remover o(a) instrutor(a) " + instructor.getName() + "? (sim/nao)"
            );

            switch (opcao) {
                case "sim":
                    integrantes.remove(codigo);
                    JOptionPane.showMessageDialog(
                            null,
                            "Instrutor(a) removido(a) com sucesso."
                    );
                    break;

                case "nao":
                    JOptionPane.showMessageDialog(
                            null,
                            "O(a) instrutor(a) não foi removido."
                    );
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida!"
                    );
                    break;
            }
        } else if (integrantes.get(codigo) instanceof Student aluno) {
            opcao = JOptionPane.showInputDialog(
                    "Você tem certea de que quer remover o(a) aluno(a) " + aluno.getName() + "? (sim/nao)"
            );

            switch (opcao) {
                case "sim":
                    integrantes.remove(codigo);
                    JOptionPane.showMessageDialog(
                            null,
                            "Aluno(a) removido(a) com sucesso."
                    );
                    break;

                case "nao":
                    JOptionPane.showMessageDialog(
                            null,
                            "O(a) aluno(a) não foi removido."
                    );
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida!"
                    );
                    break;
            }
        }

    }

    public static void pesquisarPorNome() {
        String nome = JOptionPane.showInputDialog(
                "Insira abaixo o nome a ser pesquisado:"
        );

        for (String key : integrantes.keySet()) {
            if (integrantes.get(key).getName().startsWith(nome)) {
                if (integrantes.get(key) instanceof Student aluno) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Você pesquisou pelo(a) aluno(a) " + aluno.getName() + "\n" +
                                    "Abaixo seguem as informações do mesmo: \n\n" +
                                    "-> CPF: " + aluno.getCpf() + "\n" +
                                    "-> Faixa atual: " + aluno.getBelt() + "\n" +
                                    "-> Telefone: " + aluno.getPhone() + "\n" +
                                    "-> Idade: " + aluno.getAge() + "\n" +
                                    "-> Data de matrícula: " + aluno.getRegistrationDate() + "\n" +
                                    "-> Plano de assinatura: " + aluno.getMonthlyPlan() + "\n" +
                                    "-> Situação do aluno: (true = ativo / false = intivo) " + aluno.isActiveRegistration()
                    );
                } else if (integrantes.get(key) instanceof Instructor instrutor) {
                    JOptionPane.showMessageDialog(
                            null,
                            "--> Você pesquisou pelo Instrutor(a): " + instrutor.getName() + "\n" +
                                    "-> CPF: " + instrutor.getCpf() + "\n" +
                                    "-> Faixa atual: " + instrutor.getBelt() + "\n" +
                                    "-> Telefone: " + instrutor.getPhone() + "\n" +
                                    "-> Idade: " + instrutor.getAge() + "\n" +
                                    "-> Nível de Instrução: " + instrutor.getInstructonLevel() + "\n" +
                                    "-> Anos de experiência: " + instrutor.getExpeienceInYears()
                    );
                }
            }
        }
    }
}
