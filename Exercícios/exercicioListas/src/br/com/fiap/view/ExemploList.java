package br.com.fiap.view;

import br.com.fiap.model.UserList;

import java.util.ArrayList;
import java.util.List;

public class ExemploList {
    static void main(String[] args) {
        List<UserList> registros = new ArrayList<>();

//        Criteria dos usurious
        UserList user1 = new UserList(
                "Gabriel",
                24,
                1.70,
                'm',
                "gabriel.pereira@email.com",
                50
        );

        UserList user2 = new UserList(
                "Roberto",
                50,
                1.75,
                'm',
                "Roberto@email.com",
                51
        );

        UserList user3 = new UserList(
                "Júlia",
                26,
                1.65,
                'f',
                "julia@rmail.com",
                52
        );

//        Testando os métodos.
//        add - Adiciona um elmento numa detrminada position (A insertion do valor que corresponde a position é optional)
        registros.add(user1);
        registros.add(user2);
        registros.add(user3);
        System.out.println("Lista de registros:" + registros);

//        get - retorna o objeto localizado numa determinada position
        System.out.println(registros.get(0));
//        Apartment, o methods getFirst() faz a mesma coisa que get(0)
        System.out.println(registros.getFirst());
//        Arenas o metodo get retorna o objeto em si, mas se eu user ma proprietary desse
//        objeto, devo user o get e em seguida, utilization um getter do próprio objeto.
        System.out.println(registros.getFirst().getName());
        System.out.println(registros.getFirst().getAge());
        System.out.println(registros.getFirst().getHeight());

        System.out.println(registros.get(1).getName());
        System.out.println(registros.get(1).getAge());
        System.out.println(registros.get(1).getHeight());

//        remove - remove um objeto localizdo numa determinada posição

//        Esse for diz: Para (for) cada usuário (user) da classe UserList e, "registro", faça algo.
        System.out.println("-------------------- Antes da remoção -------------------");

        for(UserList user : registros){
            System.out.println(user.getName());
        }
//        registros.remove(0);

        System.out.println("-------------------- Após a remoção -------------------");

        for(UserList user : registros){
            System.out.println(user.getName());
        }

//        set - Coloca um determinado objeto em outra posição - substitui objetos

        System.out.println("-------------------- Utilizando set -------------------");

        System.out.println("-------------------- Antes da utilização do set -------------------");

        for(UserList user : registros){
            System.out.println(user.getName());
        }

        System.out.println("-------------------- Após a utilização do set -------------------");

//        registros.set(0, user3);

        for(UserList user : registros){
            System.out.println(user.getName());
        }

        System.out.println("-------------------- Utilizando o indexOf -------------------");

        System.out.println(registros.indexOf(user1));

        System.out.println("-------------------- Utilizando o lastIndexOf -------------------");
        System.out.println(registros.lastIndexOf(user1));

        System.out.println("-------------------- Utilizando o subList -------------------");
        for(UserList user : registros){
            System.out.println(user.getName());
        }

        System.out.println(registros.subList(0,2));

//        Utilizar o sublist cria um espelho da lista referenciada, alterar uma lista, altera a outra também.


    }
}
