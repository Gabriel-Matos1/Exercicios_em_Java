import java.util.Scanner;

/*
 Faça uma classe executável que dado um conjunto de 20 elementos numéricos,
informe a soma de todos os números pares. Faça a validação de dados inválidos informando
o usuário, e fazendo-o repetir a digitação.
*/
public class VinteNum {
    public static void main(String[] args) {
        double soma = 0;

        try (Scanner sc = new Scanner(System.in)) {
            double num;

            for (int i = 0; i < 20; i++) {
                System.out.print((i+1) + ". Digite um número: ");

                if (sc.hasNextDouble()) {
                    num = sc.nextDouble();
                    if (num % 2 == 0) {
                        soma = soma + num;
                    }
                } else {
                    System.out.println("Valor inválido, insira novamente.");
                    sc.next(); // Limpa o buffer do scanner
                    i--; // Volta uma iteração para tentar novamente
                }
            }
        }

        System.out.println("Valor final da soma: " + soma);
    }
}
