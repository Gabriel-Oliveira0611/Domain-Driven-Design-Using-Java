public class operadoresAritmeticos {
    static void main() {
        // Adição (+)
        int adicao = 5 + 5;
        System.out.println("Adição:");
        System.out.println(adicao);

        // Subtração (-)
        int subtracao = 45 - 5;
        System.out.println("Subtração:");
        System.out.println(subtracao);

        // Multiplicação (*)
        int multiplicacao = 5 * 5;
        System.out.println("Multiplicação:");
        System.out.println(multiplicacao);

        // Divisão
        int divisao = 15 / 2;
        System.out.println("Divisão:");
        System.out.println(divisao);

        // Módulo (Resto de uma divisão que resultou em dízima periódica)
        int modulo = 10 % 3;
        System.out.println("Módulo (Resto de uma divisão que resultou em dízima periódica");
        System.out.println(modulo);

        //Definindo variável para incremento e decremento.
        int numero = 100;

        // Incremento
        int incremento = ++numero;
        System.out.println("Incremento:");
        System.out.println(incremento);

        // Decremento
        int decremento = --numero;
        System.out.println("Decremento:");
        System.out.println(decremento);

        // Atribuição aditiva
        int atribuicaoAditiva = numero += 50;
        System.out.println("Atribuição Aditiva:");
        System.out.println(atribuicaoAditiva);

        // Atribuição subtrativa
        int atribuicaoSubtrativa = numero -= 50;
        System.out.println("Atribuição Subtrativa:");
        System.out.println(atribuicaoSubtrativa);

        // Atribuição multiplicativa
        int atribuicaoMultiplicativa = numero *= 100;
        System.out.println("Atribuição Multiplicativa:");
        System.out.println(atribuicaoMultiplicativa);

        // Atribuição de divisão
        int atribuicaoDeDivisao = numero /= 100;
        System.out.println("Atribuição de divisão:");
        System.out.println(atribuicaoDeDivisao);

        // Atribuição de Módulo
        int atribuicaoDeModulo = numero %= 3;
        System.out.println(
                "Atribuição de Módulo:"
        );
        System.out.println(
                atribuicaoDeModulo
        );

    }
}
