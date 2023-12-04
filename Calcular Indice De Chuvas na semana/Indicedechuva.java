import java.util.Scanner;

/*
 * Escreva um programa que leia do teclado 7 valores reais correspondentes 
 * ao índice pluviométrico diário de uma semana. Após a leitura, o programa 
 * deve determinar o índice pluviométrico médio, máximo e mínimo com o 
 * respectivo dia da ocorrência;
*/
public class Indicedechuva {
    public static void main(String[] args) {

        String[] dias = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        double med = 0;
        double min = 0;
        double max = 0;
        String min_semana = " ";
        String max_semana = " ";

        try (Scanner sc = new Scanner(System.in)) {

            for (int i = 0; i < 7; i++) {
                System.out.print((i + 1) + ". Digite a média de " + dias[i] + ": ");
                double med_dia = sc.nextDouble();

                if (i == 0) {
                    min = med_dia;
                    max = med_dia;
                }
                if (med_dia < min) {
                    min = med_dia;
                    min_semana = dias[i];
                }
                if (med_dia > max) {
                    max = med_dia;
                    max_semana = dias[i];
                }
                med += med_dia;
            }
        }
        med = med / 7;
        System.out.printf("Indice médio: %.2f\n", med);
        System.out.println("Indice mínimo: " + min + " (" + min_semana + ")");
        System.out.println("Indice máximo: " + max + " (" + max_semana + ")");
    }
}
