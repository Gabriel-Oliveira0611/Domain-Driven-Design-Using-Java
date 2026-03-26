import java.util.Scanner;

public class EntredaDeDados {


    static void main() {

        // Aqui foi criada uma variável do tipo Scanner, e foi criaod o objeto para inserção de dados conforme Scanner
        Scanner entrada = new Scanner(System.in);

        // Aqui eu crio uma entrada de valores, restringindo apenas a dados do tipo Byte
        entrada.nextByte();

        // Entrada de valores Short
        entrada.nextShort();

        // Entrada apenas de valores Int
        entrada.nextInt();

        // Entrada apenas de dados do tipo Long
        entrada.nextLong();

        // Entrada apenas de dados do tipo Float
        entrada.nextFloat();

        // Entrada apenas de dados do tipo Double
        entrada.nextDouble();

        // Entrada apenas de dados do tipo Boolean
        entrada.nextBoolean();

        // Entrada para palavras
        entrada.next();
    }
}
