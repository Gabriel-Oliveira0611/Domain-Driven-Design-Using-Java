package br.com.fiap.cor.view;

import br.com.fiap.cor.model.Cor;
import br.com.fiap.cor.model.Aviao;
import br.com.fiap.cor.model.Carro;
import br.com.fiap.cor.model.Lancha;

public class Terminal {

    static void main(String[] args) {
        // criar um objeto Cor
        Cor vermelho = new Cor();

        // Atribuir os valores para os atributos da cor
        vermelho.alterarCor(0,0,255,"Azul");

        // Criar um ubjeto avião
        Aviao boeing = new Aviao();

        //Atribuir os valores para os atributos do avião
        boeing.setModelo("Boeing");
        boeing.setQuantidadeLugares(250);
        boeing.setPrefixo("FIAP26");
        boeing.setComprimento(80);
        boeing.setAnoFabricacao(2026);
        boeing.setCor(vermelho);
        boeing.setQuantidadeTurbinas(2);

        //Exibir os valores do avião (incluindo a cor)
        System.out.println("Eis abaixo a sinformações do avião!" +
                "-> Modelo: " + boeing.getModelo() +
                "-> Quantidade de Lugares: " + boeing.getQuantidadeLugares() +
                "-> Prefixo: " + boeing.getPrefixo() +
                "-> Comprimento: " + boeing.getComprimento() +
                "-> Ano de Fabricação: " + boeing.getAnoFabricacao() +
                "-> Cor: " +
                "--> Red: " + vermelho.getR() +
                "--> Green: " + vermelho.getG() +
                "--> Blue: " + vermelho.getB() +
                "-> Quantidade de Turbinas: " + boeing.getQuantidadeTurbinas());
    }

}
