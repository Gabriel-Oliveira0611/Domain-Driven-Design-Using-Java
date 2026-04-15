package br.com.fiap.cor.view;

import br.com.fiap.cor.model.Cor;
import br.com.fiap.cor.model.Aviao;
import br.com.fiap.cor.model.Carro;
import br.com.fiap.cor.model.Lancha;

public class Terminal {

    static void main(String[] args) {

        //--------------- AVIAO -------------------------

        // Aviao - criar um objeto Cor
        Cor corClasse = new Cor();

        // Aviao - Atribuir os valores para os atributos da cor
        corClasse.alterarCor(0,0,255,"Azul");

        // Aviao - Criar um objeto avião
        Aviao boeing = new Aviao();

        // Aviao - Atribuir os valores para os atributos do avião
        boeing.setModelo("Boeing");
        boeing.setQuantidadeLugares(250);
        boeing.setPrefixo("FIAP26");
        boeing.setComprimento(80);
        boeing.setAnoFabricacao(2026);
        boeing.setCor(corClasse);
        boeing.setQuantidadeTurbinas(2);

        // Aviao - Exibir os valores do avião (incluindo a cor)
        System.out.println("\nEis abaixo as informações do avião! \n" +
                "\n-> Modelo: " + boeing.getModelo() +
                "\n-> Quantidade de Lugares: " + boeing.getQuantidadeLugares() +
                "\n-> Prefixo: " + boeing.getPrefixo() +
                "\n-> Comprimento: " + boeing.getComprimento() +
                "\n-> Ano de Fabricação: " + boeing.getAnoFabricacao() +
                "\n-> Cor: " +
                "\n--> Red: " + corClasse.getR() +
                "\n--> Green: " + corClasse.getG() +
                "\n--> Blue: " + corClasse.getB() +
                "\n-> Quantidade de Turbinas: " + boeing.getQuantidadeTurbinas());

        //--------------- CARRO -------------------------

        // Carro - Criação do novo objeto
        Carro veloster = new Carro();

        // Carro - Atribuição das cores
        corClasse.alterarCor(0,255,0,"Verde");

        // Carro - Atribuir atributos do carro
        veloster.setModelo("Veloster 2011");
        veloster.setQuantidadeLugares(5);
        veloster.setQuantidadePortas(3);
        veloster.setComprimento(4.220);
        veloster.setAnoFabricacao(2011);
        veloster.setCor(corClasse);
        veloster.setPlaca("BPS5f89");
        veloster.setMotor(1.6f);

        // Carro - Exibição dos valores
        System.out.println("\nEis abaixo as informaões do carro!\n" +
                "\n-> Modelo: " + veloster.getModelo() +
                "\n-> Quantidade de lugares: " + veloster.getQuantidadeLugares() +
                "\n-> Quantidade de portas: " + veloster.getQuantidadePortas() +
                "\n-> Comprimento: " + veloster.getComprimento() +
                "\n-> Ano de Fabricação: " + veloster.getAnoFabricacao() +
                "\n-> Cor: " +
                "\n--> Red: " + corClasse.getR() +
                "\n--> Green: " + corClasse.getG() +
                "\n--> Blue: " + corClasse.getB() +
                "\n-> Placa: " + veloster.getPlaca() +
                "\n-> Motor: " + veloster.getMotor());

        //--------------- LANCHA -------------------------

        // Lancha - Criação do objeto
        Lancha nx270Challenger = new Lancha();

        // Lancha - Atribuição das cores
        corClasse.alterarCor(255,0,0,"vermelho");

        // Lancha - Atribuição das variáveis
        nx270Challenger.alterarInformacoes("NX 270 Challenger", 11, 8.22, 2026, 1);

        // Lancha - Exibição dos valores
        System.out.println("\nEis abaixo as informações!\n" +
                "\n-> Modelo: " + nx270Challenger.getModelo() +
                "\n-> Quantidade de Lugares: " + nx270Challenger.getQuantidadeLugares() +
                "\n-> Comprimento: " + nx270Challenger.getComprimento() +
                "\n-> Ano de Fabricação: " + nx270Challenger.getAnoFabricacao() +
                "\n-> Cor: " +
                "\n--> Red: " + corClasse.getR() +
                "\n--> Green: " + corClasse.getG() +
                "\n--> Blue: " + corClasse.getB() +
                "\n-> Quantidade de Motores: " + nx270Challenger.getQuantidadeMotores());
    }
}
