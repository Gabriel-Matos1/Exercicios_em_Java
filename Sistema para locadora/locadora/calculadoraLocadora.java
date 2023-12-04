import java.util.Scanner;
/**
 * Faça uma classe executável que dados a quantidade de DVDs
que uma vídeo locadora possui e o valor que ela cobra por cada aluguel,
informe:
a. Sabendo que um terço dos DVDs são alugadas por mês, o seu
faturamento anual.
b. Sabendo que quando o cliente atrasa a entrega, é cobrada uma multa de
10% sobre o valor do aluguel e que um décimo das fitas alugadas no
mês são devolvidas com atraso, o valor ganho com multas por mês.
c. Formate a saída para aparecer com duas casas decimais e (R$) na
frente.
d. Faça comentários na classe e gere o JavaDoc.
 */
    
public class calculadoraLocadora {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Quantos DVD's a locadora tem? ");
            double qtde = sc.nextInt();
            System.out.println("Quanto é o aluguel de um DVD? ");
            double vunid = sc.nextDouble();

            double faturamento_Anual = 12 * ((qtde / 3) * vunid);

            double valorAtrasoMensal = ((qtde / 3) / 10) * (vunid + (vunid * 0.10));
  
            System.out.printf("Faturamento Anual (Sem valor das multas): R$ %.2f\n", faturamento_Anual);
            System.out.printf("Valor das multas por atraso(Mensal): R$ %.2f\n", valorAtrasoMensal);
  
        }
    }
}
