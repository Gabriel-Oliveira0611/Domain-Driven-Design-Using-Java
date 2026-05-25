package br.com.fiap.veiculos.model;

public class Lancha extends Veiculo {
    private Cor cor;
    private int quantidadeMotores;

    public Lancha () {}

    public Lancha (
            String modelo,
            int quantidadeLugares,
            int quantidadePortas,
            int anoFabricacao,
            double comprimento,
            int quantidadeMotores
    ) {
        super(
                modelo,
                quantidadeLugares,
                quantidadePortas,
                anoFabricacao,
                comprimento
        );
        this.quantidadeMotores = quantidadeMotores;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getQuantidadeMotores() {
        return quantidadeMotores;
    }

    public void setQuantidadeMotores(int quantidadeMotores) {
        this.quantidadeMotores = quantidadeMotores;
    }
}
