package br.com.fiap.portal.model;

public class Endereco {
    private String logradouro;
    private String complemento;

    public Endereco (String logradouro, String complemento) {
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
