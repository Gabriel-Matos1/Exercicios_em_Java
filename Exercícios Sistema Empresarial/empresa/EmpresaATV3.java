package empresa;
import java.util.Scanner;

/*
 *  Escreva um programa com os seguintes passos: 1) Peça ao usuário que informe
quantos funcionários existem na empresa. 2) Instancie um array de strings e um array de
doubles com o tamanho informado. 3) Peça ao usuário que informe o nome e o salário de
cada funcionário e armazene o nome no array de strings e o salário no array de doubles. 4)
Calcule a média salarial da empresa. 5) Imprima a lista de nomes/salários que estão acima
da média salarial. Obs.: Faça o tratamento das entradas de dados. Se o usuário informar um
salário inválido, peça para ele informar novamente. Imprima os salários com duas casas
decimais. Os nomes devem conter ao menos 3 caracteres
*/
public class EmpresaATV3 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Quantos funcionários tem na empresa?");
            int qtde_func = sc.nextInt();
            double[] salarios = new double[qtde_func];
            String[] nomes = new String[qtde_func];
            double media_salario = 0;

            for (int i = 0; i < qtde_func; i++) {
                while (true) {
                    System.out.print("Qual o nome deste funcionário?");
                    sc.nextLine(); 
                    nomes[i] = sc.nextLine();

                    if (nomes[i].length() > 3) {
                        break;
                    } else {
                        System.out.println("Nome inválido. Insira um nome com mais de três caracteres.");
                    }
                }

                while (true) {
                    System.out.print("Qual o salário deste funcionário?");
                    if (sc.hasNextDouble()) {
                        salarios[i] = sc.nextDouble();
                        break;
                    } else {
                        System.out.println("Valor inválido. Insira um valor válido.");
                        sc.next(); // Limpa o buffer do scanner
                    }
                }

                media_salario += salarios[i];
            }

            media_salario = media_salario / qtde_func;
            System.out.println("Funcionários com o salário acima da média: ");

            for (int i = 0; i < qtde_func; i++) {
                if (salarios[i] > media_salario) {
                    System.out.printf("%s - R$ %.2f%n", nomes[i], salarios[i]);
                }
            }

        }
    }
}
