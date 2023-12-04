import java.util.Scanner;

/*
 * Construa um programa que calcule o determinante de uma matriz 3 x 3
fornecida pelo usuário;

*/
public class Determinantes {
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite os elementos da matriz 3x3:");

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("linha ["+(i+1)+"]["+(j+1)+"]=> " );matriz[i][j] = sc.nextInt();
                }


            }
        }

        int determinante = calcularDeterminante(matriz);
        System.out.println("O determinante da matriz é: " + determinante);
    }

    public static int calcularDeterminante(int[][] matriz) {
        int determinante = 0;
        determinante += matriz[0][0] * matriz[1][1] * matriz[2][2];
        determinante += matriz[0][1] * matriz[1][2] * matriz[2][0];
        determinante += matriz[0][2] * matriz[1][0] * matriz[2][1];
        determinante -= matriz[0][2] * matriz[1][1] * matriz[2][0];
        determinante -= matriz[0][0] * matriz[1][2] * matriz[2][1];
        determinante -= matriz[0][1] * matriz[1][0] * matriz[2][2];
        return determinante;
    }
}
