package br.com.fiap.view;

import br.com.fiap.model.UserClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class terminal {
    static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

//        Criação dos objetos
        UserClass user1 = new UserClass(
                20,
                "Gabriel",
                "gabriel@email.com",
                "sdf313233"
        );

        UserClass user2 = new UserClass(
                30,
                "Roberto",
                "roberto@email.com",
                "senha123456"
        );

        UserClass user3 = new UserClass(
                40,
                "Júlia",
                "julia@emial.com",
                "senha654321"
        );

//        Criaçao do map
        Map<Integer, UserClass> mapList = new HashMap<>();

        System.out.println("------------------------- Utilizando o put ---------------------------");
        mapList.put(user1.getId(), user1);
        mapList.put(user2.getId(), user2);
        mapList.put(user3.getId(), user3);

        for (Integer key : mapList.keySet()) {
            System.out.println("Id: " + key + " ->  " + mapList.get(key).getName());
        }

        System.out.println("------------------------- Utilizando o remove ---------------------------");
        mapList.remove(user3.getId());

        for (Integer key : mapList.keySet()) {
            System.out.println("id: " + key + "-> " + mapList.get(key).getName());
        }

        System.out.println("------------------------- Utilizando o clear ---------------------------");
        mapList.clear();

        if (mapList.isEmpty()) {
            System.out.println("Agora o map está vazio");
        } else {
            for (Integer key : mapList.keySet()) {
                System.out.println("id: " + key + "-> " + mapList.get(key).getName());
            }
        }

        mapList.put(user1.getId(), user1);
        mapList.put(user2.getId(), user2);
        mapList.put(user3.getId(), user3);

        System.out.println("------------------------- Utilizando o containsKey ---------------------------");
        System.out.println(mapList.containsKey(user1.getId()));

        System.out.println("Insira abaixo a chave procurada: ");
        int chaveProcurada = leitor.nextInt();

        if (mapList.containsKey(chaveProcurada)) {
            System.out.println("o map contém a chave " + chaveProcurada + " e ela contém o objeto " + mapList.get(chaveProcurada).getName());
        } else {
            System.out.println("Não existe.");
        }

        System.out.println("------------------------- Utilizando o get ---------------------------");
        System.out.println(mapList.get(user1.getId()).getName());

        System.out.println("------------------------- Utilizando o isEmpty ---------------------------");
        if (mapList.isEmpty()){
            System.out.println("Está vazio");
        } else {
            System.out.println("Não está vazio");
        }

        System.out.println("------------------------- Utilizando o keySet ---------------------------");
        System.out.println(mapList.keySet());

        System.out.println("------------------------- Utilizando o size ---------------------------");
        System.out.println(mapList.size());

        System.out.println("------------------------- Utilizando o values ---------------------------");
        System.out.println(mapList.values());
        
    }
}
