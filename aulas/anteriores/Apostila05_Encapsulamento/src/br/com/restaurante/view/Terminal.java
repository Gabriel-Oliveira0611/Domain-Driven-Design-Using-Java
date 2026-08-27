package br.com.restaurante.view;

import br.com.restaurante.model.Funcionario;

public class Terminal {

    public static void main(String[] args) {
        //Criar umm objeto
        Funcionario gabriel = new Funcionario();

        //Inserção de dados da variável
        gabriel.setNome("Gabriel");
        System.out.println(gabriel.getNome());

        gabriel.setId(509);
        System.out.println(gabriel.getId());

        gabriel.setBoolean(true);
        System.out.println(gabriel.getAtivo());

        gabriel.setSalario(2490.56);
        System.out.println(gabriel.getSalario());

        gabriel.setSexo('m');
        System.out.println(gabriel.getSexo());


    }

}
