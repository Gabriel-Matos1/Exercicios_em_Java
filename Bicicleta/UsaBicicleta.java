package Bicicleta;
import java.util.Scanner;

/*
 * Crie um tratamento de exceção (com exceções monitoradas) para os seguintes casos:
 valores de velocidade negativo ou superior a 100 km/h
 valores de RPM negativo,
 Valores de Marcha negativo ou superior a 24.
a. Lance estas exceções nos métodos setVelocidade, setRPM e setMarcha
b. Crie um construtor para a classe Bicicleta
c. Crie uma classe UsaBicicleta que teste estes casos. Faça o tratamento qualificado
das exceções nesta classe.
*/

public class UsaBicicleta {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual a velocidade? ");
        int vel = scanner.nextInt();

        
        System.out.print("Qual o RPM? ");
        int rpm = scanner.nextInt();

        
        System.out.print("Qual a marcha? ");
        int marcha = scanner.nextInt();

        Bicicleta minhaBicicleta = new Bicicleta();

        try {
            minhaBicicleta.setVelocidade(vel);
            minhaBicicleta.setRPM(rpm);
            minhaBicicleta.setMarcha(marcha);
        } catch (BicicletaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        minhaBicicleta.printStates();
        scanner.close();
    }
}