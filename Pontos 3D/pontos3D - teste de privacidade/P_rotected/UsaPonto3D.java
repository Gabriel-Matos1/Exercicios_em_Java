package pontos3D.P_rotected;

import java.util.Scanner;

public class UsaPonto3D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informações ponto 1");

        System.out.println("Qual o ponto X?");
        double x = sc.nextDouble();
        System.out.println("Qual o ponto Y?");
        double y = sc.nextDouble();
        System.out.println("Qual o ponto Z?");
        double z = sc.nextDouble();

        // Consumir a quebra de linha pendente
        sc.nextLine();

        System.out.println("Qual a cor?");
        String cor = sc.nextLine();
        System.out.println("Qual a intensidade?");
        double intensidade = sc.nextDouble();

        Ponto3D p1 = new Ponto3D(x, y, z, cor, intensidade);
        System.out.println("Informações ponto 2");
        System.out.println("Qual o ponto X?");
        double x2 = sc.nextDouble();
        System.out.println("Qual o ponto Y?");
        double y2 = sc.nextDouble();
        System.out.println("Qual o ponto Z?");
        double z2 = sc.nextDouble();

        // Consumir a quebra de linha pendente
        sc.nextLine();

        System.out.println("Qual a cor?");
        String cor2 = sc.nextLine();
        System.out.println("Qual a intensidade?");
        double intensidade2 = sc.nextDouble();

        Ponto3D p2 = new Ponto3D(x2, y2, z2, cor2, intensidade2);

        double distancia = p1.calculaDistancia(p2);

        System.out.println("A distância entre os pontos é: " + distancia);

        sc.close();
    }
}
