import java.util.Scanner;

/*Faça um programa que leia uma frase e informe se ela é um palíndromo ou não.
Uma frase é um palíndromo quando pode ser lida tanto da forma usual, quanto de trás para
frente. O programa deve ignorar maiúsculas e minúsculas na avaliação. Insira as frases sem
acentuação;
*/

public class Palindromo {
    public static void main(String[] args) {
        String palavra;
        String palavra_invertida;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Escreva o texto que você quer verificar: ");
            palavra = sc.nextLine();

            String sem_espaco = palavra.replace(" ", "");
            sem_espaco = sem_espaco.toUpperCase();

            palavra_invertida = inverterPalavra(sem_espaco);

            if (sem_espaco.equals(palavra_invertida)) {
                System.out.println("É um palíndromo.");
            } else {
                System.out.println("Não é um palíndromo.");
            }
        }
    }

    public static String inverterPalavra(String palavra) {
        StringBuilder palavraInvertida = new StringBuilder();
        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida.append(palavra.charAt(i));
        }
        return palavraInvertida.toString();
    }
}
