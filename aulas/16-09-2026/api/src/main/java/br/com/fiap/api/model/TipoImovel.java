package br.com.fiap.api.model;

import java.time.LocalDateTime;

public class TipoImovel {
    private int codigo;
    private String nome;
    private LocalDateTime dataDeCadastro;

    public TipoImovel(){}

    public TipoImovel(String nome, LocalDateTime dataDeCadastro) {
        this.nome = nome;
        this.dataDeCadastro = dataDeCadastro;
    }

    public TipoImovel(int codigo, String nome, LocalDateTime dataDeCadastro) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataDeCadastro = dataDeCadastro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
