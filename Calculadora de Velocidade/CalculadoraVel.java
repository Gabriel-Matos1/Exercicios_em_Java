import java.util.Scanner;

/*
 *  Faça uma classe executável que dados a distância percorrida 
 * (emKm) e o tempo gasto em uma viagem (em horas), informe a velocidade média do carro, 
sabendo que Velocidade = S / T (variação de distância /variação do tempo). Imprima o 
valor com duas casas decimais.
*/
public class CalculadoraVel{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Digite a distancia em km: ");
            double n1 = sc.nextDouble();
            System.out.println("Digite quantas horas foram gastas: ");
            double n2 = sc.nextDouble();
            double vel = n1/n2;
            
            System.out.printf("A velocidade foi de: ");
            System.out.printf("%.2f", vel);

        }
    }    
}
