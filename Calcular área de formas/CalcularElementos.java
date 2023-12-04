import java.util.Scanner;

/*
 * Crie uma classe que contenha um método capaz de efetuar a soma das áreas
de elementos de um único vetor contendo objetos do tipo Retangulo, Triangulo e
Circunferencia. Construa um programa para testar este método
*/
public class CalcularElementos {
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     System.out.println("Quer calcular o que?"+
     "\n1. Circunferencia"+
     "\n2. Triangulo"+
     "\n3. Retangulo");
     int opc = sc.nextInt();
     double resultado = 0;
     if(opc == 1){
        System.out.println("Qual o raio da circunferencia?");
        double raio = sc.nextDouble();
        resultado = Circunferencia(raio);
     }
     if(opc == 2){
        System.out.println("Qual a altura do triangulo?");
        double altura = sc.nextDouble();
        System.out.println("Qual a base do triangulo?");
        double base = sc.nextDouble();
        resultado = triangulo(altura, base);
     }
     if(opc == 3){
        System.out.println("Qual a altura do retangulo?");
        double altura = sc.nextDouble();
        System.out.println("Qual a base do retangulo?");
        double base = sc.nextDouble();
        resultado = retangulo(altura, base);
     }

     System.out.println("A área é: "+ resultado);
     sc.close();
}

    public static double Circunferencia(double raio){
        double circuferencia = 3.14 * raio;
        return circuferencia;
    }
    public static double triangulo(double altura, double base){
        double triangulo = (base*altura)/2;
        return triangulo;
    }
    public static double retangulo(double altura, double base){
        double retangulo = base*altura;
        return retangulo;
    }

    }
