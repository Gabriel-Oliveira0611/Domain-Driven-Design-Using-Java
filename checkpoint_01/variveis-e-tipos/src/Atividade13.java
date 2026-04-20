public class Atividade13 {
    static void main(String[] args) {
        double valorEmReais = 451.50;
        double taxaDeCambio = 5.25;
        double valorEmDolar = valorEmReais / taxaDeCambio;

        System.out.println("O valor de R$" + valorEmReais + " em dólares é de $" + valorEmDolar);
    }
}
