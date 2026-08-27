package br.com.fiap.view;

import java.util.HashMap;
import java.util.Map;

public class Exemplo04 {
    static void main(String[] args) {
//        Map - HashMap
        Map<String, Integer> registro = new HashMap<>();

//        Adicionar 3 registros
        registro.put("Gabriel", 2001);
        registro.put("Júlia", 2002);
        registro.put("José das couves", 1987);

//        Exibir a quantidade de registros
        System.out.println(registro);
        System.out.println("-> Quantidade de registros: " + registro.size());

//        Recuperar o ano de nacimento da Júlia
        System.out.println(registro.get("Júlia"));
        
//        Exibir todos os nomes e anos de nascimento
        for (String usuario : registro.keySet()) {
            System.out.println(usuario + ": " + registro.get(usuario));
        }
        

    }
}
