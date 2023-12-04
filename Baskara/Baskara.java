import java.util.Scanner;
/*
 *  Construa um programa que leia os coeficientes de uma equação
do segundo grau do teclado e mostre os valores de x da equação
*/
public class Baskara {
    public static void main(String[] args) {
        // Leitura dos coeficientes a, b e c
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o coeficiente a: ");
        double a = scanner.nextDouble();

        System.out.print("Digite o coeficiente b: ");
        double b = scanner.nextDouble();

        System.out.print("Digite o coeficiente c: ");
        double c = scanner.nextDouble();

        // Calcula o discriminante
        double delta = b * b - 4 * a * c;

        // Verifica se as raízes são reais
        if (delta >= 0) {
            // Calcula as raízes
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);

            // Exibe as raízes
            System.out.println("Resultado: x1 = " + x1 + " e x2 = " + x2);
        } else {
            System.out.println("Não há raízes reais para a equação fornecida.");
        }
    }
}
