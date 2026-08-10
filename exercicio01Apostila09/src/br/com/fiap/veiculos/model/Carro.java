package br.com.fiap.veiculos.model;

public class Carro extends Veiculo {
    private Cor cor;
    private String placa;
    private float motor = 1;

    public Carro () {}

    public Carro (
            String modelo,
            int quantidadeLugares,
            int quantidadePortas,
            int anoFabricacao,
            double comprimento,
            String placa
    ) {
        super(
                modelo,
                quantidadeLugares,
                quantidadePortas,
                anoFabricacao,
                comprimento
        );
        this.placa = placa;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getMotor() {
        return motor;
    }

    public void setMotor(float motor) {
        this.motor = motor;
    }
}
