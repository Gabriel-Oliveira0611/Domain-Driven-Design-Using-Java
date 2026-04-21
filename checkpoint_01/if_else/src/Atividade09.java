public class Atividade09 {
    static void main(String[] args) {
        double valorDaCompra = 80.0;
        double desconto = 0.10;
        double novoValor =  valorDaCompra - (valorDaCompra * desconto);

        if (valorDaCompra >= 100) {
            System.out.println("O cliente  tem direito ao desconto de 10%" +
                    "\nNovo valor da compra: R$" + novoValor);
        } else {
            System.out.println("Nenhum desconto aplicado." +
                    "\nValor da compra: R$" + valorDaCompra);
        }
    }
}
