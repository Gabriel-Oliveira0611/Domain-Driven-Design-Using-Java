public class Atividade15 {
    static void main(String[] args) {
        double consumoMedio = 12.5;
        double capacidadeDoTanque = 50;
        double combustivelAtual = 20;
        double distanciaDaViagem = 200;

        double autonomiaDoCarro = capacidadeDoTanque * consumoMedio;
        double autonomiaAtual = combustivelAtual * consumoMedio;

        System.out.println(
                "Seu carro consegue andar " + autonomiaDoCarro + "km com tanque cheio." +
                        "\nVocê tem no tanque um total de " + combustivelAtual + " Litros\n" +
                        combustivelAtual + " litros te dá uma autonomia de " + autonomiaAtual + "km sem abastecer."
        );

        if (autonomiaAtual < distanciaDaViagem) {
            System.out.println(
                    "A viagem tem " + distanciaDaViagem + "km." +
                            "\nVocê não tem autonomia para fazer essa viagem sem abastecer."
            );
        } else {
            System.out.println(
                    "A viagem tem " + distanciaDaViagem + "km." +
                            "\nVocê tem autonomia para fazer essa viagem sem abastecer."
            );
        }
    }
}
