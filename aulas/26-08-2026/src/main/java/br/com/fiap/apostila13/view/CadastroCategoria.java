package br.com.fiap.apostila13.view;

import br.com.fiap.apostila13.dao.CategoriaDao;
import br.com.fiap.apostila13.model.Categoria;

import java.util.Scanner;

public class CadastroCategoria {
    static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Digite o nome d acategoria:");
            String nome = input.next() + input.nextLine();

            CategoriaDao dao = new CategoriaDao();
            Categoria categoria = new Categoria(nome);
            dao.cadastrar(categoria);

            System.out.println("Categoria cadastrada com sucesso!");
            System.out.println(categoria);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
