package br.com.fiap.view;

import br.com.fiap.model.NumeroDDD;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Terminal {

    static Map<String, List<NumeroDDD>> estados = new HashMap<>();

    static void main(String[] args) {
        launch();
    }

    static void launch() {
        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    """
                            Seja bem-vindo ao registro de DDDs.
                            Escolha uma das opções abaixo:
                            
                            -> 1: Incluir o estado e seus DDDs.
                            -> 2: Consultar os DDDs de um estado.
                            -> 3: Sair."""
            ));

            switch (option) {
                case 1:
                    incluirEstadoComDDD();
                    break;

                case 2:
                    consultarDDDs();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (option != 3);
    }

    static void incluirEstadoComDDD() {
        String key = JOptionPane.showInputDialog("Digite a sigla do estado:");
        List<NumeroDDD> ddds = new ArrayList<>();

        estados.put(key, ddds);
        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    Escolha uma das opções abaixo:
                    
                    -> 1: Adicionar ddd ao estado.
                    -> 2: Prosseguir
                    """));

            switch (option) {
                case 1:
                    ddds.add(new NumeroDDD(Integer.parseInt(JOptionPane.showInputDialog("Insira o ddd:"))));
                    break;

                case 2:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (option != 2);
    }

    static void consultarDDDs() {
        String key = JOptionPane.showInputDialog("Insira o UF desejado.");

        if (estados.containsKey(key)) {
            String resultado = "Segue abaixo os DDDs registrados no UF " + key + "\n";

            for (NumeroDDD index : estados.get(key)) {
                resultado += "-> " + index.getNumeroDDD() + "\n";
            }

            JOptionPane.showMessageDialog(null, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Não existe nenhum estado cadastrado com essa sigla.");
        }
    }
}
