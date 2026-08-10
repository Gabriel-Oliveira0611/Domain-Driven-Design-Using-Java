package br.com.fiap.view;

import br.com.fiap.model.UserClass;

import java.util.HashSet;
import java.util.Set;

public class Terminal {
    static void main(String[] args) {
        Set<UserClass> conjunto = new HashSet<>();

//        Criação dos objetos
        UserClass user1 = new UserClass(
                "Gabriel",
                "gabriel.pereira@email.com",
                24,
                1.70
        );

        UserClass user2 = new UserClass(
                "Júlia",
                "julia@email.com",
                25,
                1.65
        );

        UserClass user3 = new UserClass(
                "Roberto",
                "roberto@email.com",
                60,
                1.75
        );

        System.out.println("-------------------- Utilizando o add -------------------");
        conjunto.add(user1);
        conjunto.add(user2);
        conjunto.add(user3);
        for (UserClass user : conjunto) {
            System.out.println(user.getName());
        }

        System.out.println("-------------------- Utilizando o clear -------------------");
        conjunto.clear();

        if (conjunto.isEmpty()) {
            System.out.println("Agora o conjunto está vazio");
        } else {
            for (UserClass user : conjunto) {
                System.out.println(user.getName());
            }
        }

        conjunto.add(user1);
        conjunto.add(user2);
        conjunto.add(user3);

        System.out.println("-------------------- Utilizando o contains -------------------");
        System.out.println(conjunto.contains(user1));
        System.out.println(conjunto.contains(user2));

        if (conjunto.contains(user1)) {
            System.out.println(user1.getName() + " está no set.");
        } else {
            System.out.println("Não está no set");
        }

        System.out.println("-------------------- Utilizando o isEmpty -------------------");
        if (conjunto.isEmpty()) {
            System.out.println("Agora o conjunto está vazio");
        } else {
            for (UserClass user : conjunto) {
                System.out.println(user.getName());
            }
        }

        System.out.println("-------------------- Utilizando o remove -------------------");

        System.out.println("-------------------- Antes da remoção -------------------");

        for (UserClass user : conjunto) {
            System.out.println(user.getName());
        }

        System.out.println("-------------------- Após a remoção -------------------");
//        conjunto.remove(user1);

        for (UserClass user : conjunto) {
            System.out.println(user.getName());
        }

        System.out.println("-------------------- Utilizando o size -------------------");
        System.out.println(conjunto.size());

        System.out.println("-------------------- Utilizando o toArray -------------------");

        UserClass[] usersArray = conjunto.toArray(new UserClass[0]);
    }
}
