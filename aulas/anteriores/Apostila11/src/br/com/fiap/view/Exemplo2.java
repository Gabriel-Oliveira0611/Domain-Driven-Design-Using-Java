package br.com.fiap.view;

import br.com.fiap.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Exemplo2 {

    static void main(String[] args) {
        // Criar uma lista de Pokemon (pokedex)
        List<Pokemon> pokedex = new ArrayList<>();

        // Crisação dos objetos
        Pokemon pikachu = new Pokemon(
                "Elétrico",
                "Pikachu",
                20
        );

        Pokemon charizard = new Pokemon(
                "Fogo",
                "Charizard",
                50
        );

        Pokemon mewTwo = new Pokemon(
                "Psíquico",
                "Mewtwo",
                100
        );

        // Adição dos objetos na lista
        pokedex.add( pikachu);
        pokedex.add( charizard);
        pokedex.add( mewTwo);

        // Exibir os dados dos pokemons
//        for (int i = 0; i < pokedex.size(); i++) {
//            System.out.println(pokedex.get(i).toString() + "\n");
//        }

//        Utilizando forEach
        for (Pokemon index : pokedex) {
            System.out.println(index);
        }
    }

}
