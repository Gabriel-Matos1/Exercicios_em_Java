import java.util.Scanner;
/*
 * Implemente um programa que calcule o bônus anual de um funcionário
de uma empresa. O programa pede para o usuário os seguintes dados: Cargo do
funcionário e salário atual. Se o cargo for diretor o sistema pede quantidade de
departamentos gerenciados. Se o cargo for gerente o sistema pede a quantidade
de pessoas gerenciadas. Não é necessário fazer tratamento de entrada de dados.
O cálculo do bônus anual segue as seguintes regras.
a. Para Diretor:
i. 4 salários + R$3000,00 por departamento gerenciado
b. Para Gerente
i. 2 salários + R$100,00 por pessoa gerenciada
c. Analista
i. 1 salário
d. Programador
i. 0,8 salário
e. Auxiliar de Limpeza
i. 0,5 salário
*/

public class Empresa {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Qual teu cargo?\n1. Diretor\n2. Gerente\n3. Analista\n.4 Programador\n5. Auxiliar de Limpeza");
    int cargo = sc.nextInt();
    System.out.println("Qual teu salário?");
    double salario = sc.nextDouble();

    double bonus = 0;
    switch (cargo) {
        case 1:
                System.out.println("Quantos departamentos tu gerencia?");
                int qtdeDepartamentos = sc.nextInt();
                bonus = (4*salario)+(3000*qtdeDepartamentos);                 
                break;
        case 2:
                System.out.println("Quantas pessoas tu gerencia?");
                int qtdePessoasGerenciadas = sc.nextInt();
                bonus = (2*salario)+(100*qtdePessoasGerenciadas);                
                break;
                
        case 3:
                bonus = salario;                
                break;
        case 4:
                bonus = salario*0.8;  
                break; 
        case 5:
                bonus = salario/2;  
                break;
        default:
                break;
    }
 
    System.out.println("O bonus deste funcionário é de: "+bonus);
 
}}