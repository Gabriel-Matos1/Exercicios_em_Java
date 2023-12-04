

import java.util.Scanner;

/*
 * Implemente uma classe contendo apenas métodos estáticos
capazes de realizar todas as conversões de temperatura possíveis entre as
unidades Celsius, Farenheit e Kelvin. São conhecidas as seguintes
relações de conversão: F = 9*C/5 + 32 e K = C + 273. Demonstre a
utilização do objeto. Utilize, neste programa, uma estrutura de controle
switch para identificar a conversão solicitada pelo usuário;
*/

public class Conversoes {
    public static double CelciusParaKelvin(double c) {
        double k = c + 273.15;
        return k;
    }

    public static double CelciusParaFarenheit(double c) {
        double f = (9 * c / 5) + 32;
        return f;
    }

    public static double FarenheitParaKelvin(double f) {
        double k = (5 / 9.0) * (f - 32) + 273.15;
        return k;
    }

    public static double FarenheitParaCelcius(double f) {
        double c = (5 / 9.0) * (f - 32);
        return c;
    }

    public static double KelvinParaCelcius(double k) {
        double c = k - 273.15;
        return c;
    }

    public static double KelvinParaFarenheit(double k) {
        double c = k - 273.15;
        double f = (9 * c / 5) + 32;
        return f;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
    int opc = 0;
    while(opc != 7){    

        System.out.println("\nQual conversão quer fazer?" +
                "\n1. Celcius para Kelvin" +
                "\n2. Celcius para Farenheit" +
                "\n3. Farenheit para Celsius" +
                "\n4. Farenheit para Kelvin" +
                "\n5. Kelvin para Celsius" +
                "\n6. Kelvin para Farenheit"+
                "\n7. Para sair");

        System.out.printf(" => ");
        opc = sc.nextInt();
        if(opc != 7){
        System.out.println("Qual valor quer converter?");
        System.out.printf(" => ");
        double valor = sc.nextDouble();
        double resultado = 0;
        switch (opc) {
            case 1:
                resultado = CelciusParaKelvin(valor);
                break;
            case 2:
                resultado = CelciusParaFarenheit(valor);
                break;
            case 3:
                resultado = FarenheitParaCelcius(valor);
                break;
            case 4:
                resultado = FarenheitParaKelvin(valor);
                break;
            case 5:
                resultado = KelvinParaCelcius(valor);
                break;
            case 6:
                resultado = KelvinParaFarenheit(valor);
                break;
            case 7: 
            break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.printf("O resultado: %.2f", resultado);
        }else{
            System.out.println("\nAté mais!\n");
        }
    }
        sc.close();

    }
}
