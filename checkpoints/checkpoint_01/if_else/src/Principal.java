public class Principal {
    static void main(String[] args) {
        String nome = "João";
        double salario = 2890.0;
        int numeroDependentes = 2;
        boolean isento = true;

        if (salario > 2259.20 && !isento) {
            double irff = salario / 100 * 7.5;
            System.out.println("Valor de IRFF: " + irff);
        } else if (isento) {
            System.out.println("Contribuinte isento de irff");
        } else {
            System.out.println("Não há valores de imposto de renda.");
        }
    }
}
