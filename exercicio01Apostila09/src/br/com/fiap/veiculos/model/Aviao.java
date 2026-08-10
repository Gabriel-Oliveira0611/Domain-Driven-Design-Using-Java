package br.com.fiap.veiculos.model;

public class Aviao extends Veiculo {
    private Cor cor;
    private int quantidadeTurbinas;

    public Aviao () {}

    public Aviao (
            String modelo,
            int quantidadeLugares,
            int quantidadePortas,
            int anoFabricacao,
            double comprimento,
            int quantidadeTurbinas
    ) {
        super(
                modelo,
                quantidadeLugares,
                quantidadePortas,
                anoFabricacao,
                comprimento
        );
        this.quantidadeTurbinas = quantidadeTurbinas;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getQuantidadeTurbinas() {
        return quantidadeTurbinas;
    }

    public void setQuantidadeTurbinas(int quantidadeTurbinas) {
        this.quantidadeTurbinas = quantidadeTurbinas;
    }
}
