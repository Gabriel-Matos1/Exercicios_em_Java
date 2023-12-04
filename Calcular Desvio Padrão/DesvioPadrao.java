import java.util.Scanner;

/*
 * Faça um programa que calcule o desvio padrão de um determinado número
de amostras. O número de amostras deve ser pedido ao usuário no início do programa.
Utilize array para armazenar as amostras. Os valores das amostras devem ser digitadas pelo
usuário, uma a uma, como números decimais. 
*/
public class DesvioPadrao {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int qtde = 0;
            double m_a = 0;
            double soma = 0;
            System.out.println("Quantas amostras?");
            qtde = sc.nextInt();
            int[] amostras = new int[qtde];
            System.out.println("\nDigite as amostras: ");

            for (int i = 0; i < amostras.length; i++) {
                System.out.print((i + 1) + "-> ");
                amostras[i] = sc.nextInt();
                m_a += amostras[i];
            }

            m_a = m_a / amostras.length;

            for (int i = 0; i < amostras.length; i++) {
                soma += Math.pow((amostras[i] - m_a), 2);
            }
            soma = Math.sqrt(soma / amostras.length);

            System.out.printf("O desvio padrão é: %.2f", soma);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
