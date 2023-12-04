import java.util.Scanner;

/*
 * Escreva um programa que tenha como entrada do usuário, através do
teclado, um número inteiro positivo. Imprima a série de Fibonacci (0, 1 , 1, 2, 3, 5,
8, 13, 21, ...) até que o número da série seja maior que o número fornecido pelo
usuário.
*/

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual número?");
        int num = sc.nextInt();

        int atual = 0;
        int anterior = 1;

        while (atual <= num) {
            System.out.print(atual + ", ");

            int proximo = atual + anterior;
            atual = anterior;
            anterior = proximo;
        }
    }
}
