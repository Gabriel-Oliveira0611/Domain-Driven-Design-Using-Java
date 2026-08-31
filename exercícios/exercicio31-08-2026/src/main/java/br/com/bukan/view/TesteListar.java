package br.com.bukan.view;

import br.com.bukan.dao.InstrutorDao;
import br.com.bukan.model.Instrutor;

import java.util.List;

public class TesteListar {

    static void main(String[] args) {

        try {
            InstrutorDao dao = new InstrutorDao();

            List<Instrutor> lista = dao.listar();

            for (Instrutor instrutor : lista) {
                System.out.println("Nome: " + instrutor.getNome());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
