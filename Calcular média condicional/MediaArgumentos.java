import java.util.ArrayList;
import java.util.Scanner;

/*Construa um programa que seja capaz de efetuar a média de todos os argumentos
inteiros ou reais recebidos do teclado e imprimi-los. Argumentos inválidos devem ser
desconsiderados (Imprimir uma mensagem para cada valor inválido.), sem provocar a
exibição de exceções (Exiba uma mensagem para o usuário pedindo a ele que informe
novamente o valor). O usuário deve digitar S quando desejar encerrar a entrada de dados;*/

public class MediaArgumentos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> valores = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.print("Digite um valor (ou 'S' para encerrar): ");
            String entrada = scanner.next();

            if (entrada.equalsIgnoreCase("S")) {
                continuar = false;
            } else {
                try {
                    double valor = Double.parseDouble(entrada);
                    valores.add(valor);
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido. Por favor, informe um valor numérico.");
                }
            }
        }

        calcularMedia(valores);
        scanner.close();
    }

    private static void calcularMedia(ArrayList<Double> valores) {
        if (valores.isEmpty()) {
            System.out.println("Nenhum valor válido informado.");
        } else {
            double soma = 0;

            for (double valor : valores) {
                soma += valor;
            }

            double media = soma / valores.size();
            System.out.printf("A média dos valores é: %.0f", media);
        }
    }
}
