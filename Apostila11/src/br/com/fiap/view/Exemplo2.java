package br.com.fiap.view;

import br.com.fiap.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Exemplo2 {

    static void main(String[] args) {
        // Criar uma lista de Pokemon (pokedex)
        List<Pokemon> pokedex = new ArrayList<>();

        // Adicionar 3 pokemons
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

        pokedex.add(0, pikachu);
        pokedex.add(1, charizard);
        pokedex.add(2, mewTwo);

        // Exibir os dados dos pokemons
        for (int i = 0; i < pokedex.size(); i++) {
            System.out.println(
                    "-> Nome: " + pokedex.get(i).getNome() + "\n" +
                    "-> Tipo: " + pokedex.get(i).getTipo() + "\n" +
                            "-> Nível: " + pokedex.get(i).getNivel() + "\n"
            );
        }
    }

}
