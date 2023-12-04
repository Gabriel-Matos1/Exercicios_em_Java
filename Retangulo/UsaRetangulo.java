package Retangulo;

import java.util.Scanner;

/*
 * Modifique a classe Retangulo, para que uma exceção
IllegalArgumentException seja lançada se os lados informados forem negativos. Adapte
adequadamente o programa principal, para que a exceção seja capturada.
4. Crie uma exceção monitorada chamada LadoInvalidoException e altere o programa
anterior para que esta exceção seja lançada, no lugar de IllegalArgumentException.
*/


public class UsaRetangulo {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual a complimento? ");
        int comprimento = scanner.nextInt();

        
        System.out.print("Qual o largura? ");
        int largura = scanner.nextInt();

        
        try {

            Retangulo retangulo = new Retangulo(comprimento,largura);

            double area = retangulo.calcularArea();
            System.out.println("Área do retângulo: " + area);
        } catch (LadoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    scanner.close();
    }

}
