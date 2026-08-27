public class Atividade11 {
    static void main(String[] args) {
        double preco = 250.0;
        String categoria;

        if (preco <= 50.00) {
            categoria = "Econômico";
        } else if (preco >= 50.01 && preco <= 200.00) {
            categoria = "Intermediário";
        } else {
            categoria = "Premium";
        }

        System.out.println("Categoria do produto: " + categoria);

    }
}
