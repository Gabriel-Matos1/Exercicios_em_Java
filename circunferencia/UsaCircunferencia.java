package circunferencia;
import java.util.Scanner;

/* Crie uma classe Circunferencia, que armazene o valor do raio e
seja capaz de informar sua área. Crie uma classe UsaCircunferencia para
testar objetos da classe Circunferencia*/

public class UsaCircunferencia {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Circunferencia c1 = new Circunferencia();
        System.out.println("Qual o diametro da sua circunferencia?");
    
        c1.diametro= sc.nextDouble();
        double resultado = c1.calcularCircunferencia(c1.diametro);
  
        System.out.printf("A circunferencia do objeto é: %.2f", resultado);
    

        sc.close();
    }
}
