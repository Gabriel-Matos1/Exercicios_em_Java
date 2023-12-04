
import java.util.Scanner;

/*  Construa um programa que leia do teclado dois pontos em um
plano (x,y) e informe a distância entre eles.
*/

public class Pontos {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Digite o valor de x no ponto 1: ");
            double x1 = sc.nextDouble();
            System.out.println("Digite o valor do y no ponto 1: ");
            double y1 = sc.nextDouble();
            
            System.out.println("Digite o valor de x no ponto 2: ");
            double x2 = sc.nextDouble();
            System.out.println("Digite o valor do y no ponto 2: ");
            double y2 = sc.nextDouble();
            
            double resultado = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
            System.out.printf("A distância entre os dois pontos é de: %.0f", resultado);
        }
    }    
}
