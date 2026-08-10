package br.com.fiap.view;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Exemplo03 {
    static void main(String[] args) {
        // Criar um conjunto de numeros
        Set<Integer> sorteio = new HashSet<>();

//        Adicionar os números
        sorteio.add(1);
        sorteio.add(2);
        sorteio.add(3);


//        Exibir a quantidade de números
        System.out.println(sorteio.size());

//        Exibir os números
        System.out.println(sorteio);

//        Exibir com forEach
        for (Integer churros : sorteio){
            System.out.println(churros);
        }

    }
}
