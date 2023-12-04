import java.util.Scanner;

/*
 * Escreva um programa que calcule a soma das diagonais principal e
secundária. O programa deve perguntar ao usuário a dimensão da matriz. Baseado na
dimensão da matriz o programa deve pedir ao usuário para preencher os valores da matriz
(faça um método estático que receba a referência de uma matriz e a preencha). Com a matriz
preenchida faça outro método estático que calcule a soma das diagonais. Imprima o
resultado.
*/
public class Diagonais {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a dimensão da matriz: ");
        int dimensao = scanner.nextInt();

        // Criar e preencher a matriz
        int[][] matriz = new int[dimensao][dimensao];
        preencherMatriz(matriz);

        // Calcular a soma das diagonais
        int somaDiagonalPrincipal = calcularSomaDiagonalPrincipal(matriz);
        int somaDiagonalSecundaria = calcularSomaDiagonalSecundaria(matriz);

        // Imprimir o resultado
        System.out.println("Soma da diagonal principal: " + somaDiagonalPrincipal);
        System.out.println("Soma da diagonal secundária: " + somaDiagonalSecundaria);
        scanner.close();
    }

    private static void preencherMatriz(int[][] matriz) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os valores da matriz:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    private static int calcularSomaDiagonalPrincipal(int[][] matriz) {
        int soma = 0;

        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][i];
        }

        return soma;
    }

    private static int calcularSomaDiagonalSecundaria(int[][] matriz) {
        int soma = 0;

        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][matriz.length - 1 - i];
        }

        return soma;
    }
}
 
