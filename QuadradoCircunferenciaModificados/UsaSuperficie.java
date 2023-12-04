package QuadradoCircunferenciaModificados;

import java.util.Scanner;

public class UsaSuperficie {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a medida de um dos lados do quadrado?");
        System.out.printf(" => ");
        double lado = sc.nextDouble();
        System.out.println("Qual a medida do raio da circunferencia?");
        System.out.printf(" => ");
        double raio = sc.nextDouble();
        
        Superficie superficieQuadrado = new Quadrado(lado);
        Superficie superficieCircunferencia = new Circunferencia(raio);

        System.out.printf("Área do Quadrado: %.2f \n", superficieQuadrado.area());
        System.out.printf("Área da Circunferência: %.2f", superficieCircunferencia.area());
        
        sc.close();
    }
}