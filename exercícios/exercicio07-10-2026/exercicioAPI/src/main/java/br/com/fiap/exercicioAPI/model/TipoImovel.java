package br.com.fiap.exercicioAPI.model;

import java.time.LocalDateTime;

public class TipoImovel {

    private int id;
    private String nome;
    private LocalDateTime dataDeCadastro;

    public TipoImovel(){}

    public TipoImovel(String nome, LocalDateTime dataDeCadastro) {
        this.nome = nome;
        this.dataDeCadastro = dataDeCadastro;
    }

    public TipoImovel(int id, String nome, LocalDateTime dataDeCadastro) {
        this.id = id;
        this.nome = nome;
        this.dataDeCadastro = dataDeCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }
}
