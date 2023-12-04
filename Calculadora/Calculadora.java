import java.util.Scanner;
/*
 * Implemente um programa que receba da linha de comando 3 argumentos. O
primeiro e o segundo argumento são números reais e o terceiro argumento é a
operação.
*/
public class Calculadora {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Digite dois números e um sinal de cont: ");

            double n1 = sc.nextInt();
            double n2 = sc.nextInt();
            String sinal = sc.next();

            switch (sinal) {
                case "+":
                    System.out.println(n1+" + "+n2+" = "+ (n1+n2));
                    break;
                case "x":
                    System.out.println(n1+" x "+n2+" = "+ (n1*n2));
                    break;
                case "/":
                    System.out.println(n1+" / "+n2+" = "+ (n1/n2));
                    break;
                case "-":
                    System.out.println(n1+" - "+n2+" = "+ (n1-n2));
                    break;
            
                default:
                    break;
            }
        }
    }    
}
