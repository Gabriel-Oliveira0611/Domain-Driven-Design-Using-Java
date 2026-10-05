package fiap.com.br.TI_API.model;

public class Equipamento {

    private int id;
    private String nome;
    private String categoria;
    private String patrimonio;
    private String status;
    private double valor;

    public Equipamento() {
    }

    public Equipamento(String nome, String categoria, String patrimonio, String status, double valor) {
        this.nome = nome;
        this.categoria = categoria;
        this.patrimonio = patrimonio;
        this.status = status;
        this.valor = valor;
    }

    public Equipamento(int id, String nome, String categoria, String patrimonio, String status, double valor) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.patrimonio = patrimonio;
        this.status = status;
        this.valor = valor;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
