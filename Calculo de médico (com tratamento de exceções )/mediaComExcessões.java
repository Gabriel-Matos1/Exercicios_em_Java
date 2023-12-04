
import java.util.Scanner;

/*
 * Crie uma classe com um método main, que receba do usuário valores de
entrada (utilize a classe Scanner) e retorne a soma e a média destes valores. Por meio
de tratamento de exceção, o programa deve pedir ao usuário que repita a digitação,
quando o valor digitado não for um numérico válido. O usuário também tem a opção de
sair do programa digitando a letra “S” ou “s” no lugar de um número.
*/
public class mediaComExcessões {

    public static void main(String[] args){
        Scanner  sc = new Scanner(System.in);

        System.out.println("Informe os números na sequencia solicitada.\nPara sair digite 'S'");
        String ese = " ";
        int soma = 0;
        double media = 0;
        String numero = "0";
        int count =0;
        while(ese != "S"){
            try{
                numero = sc.nextLine();
                numero = numero.toUpperCase();

                if(numero.equals("S")){
                    break;
                }
                int atual = Integer.parseInt(numero);
                soma = soma +atual;
                count+=1;
            }catch(NumberFormatException e) {
                System.out.println("não é um numérico válido. Tente novamente ou digite S para sair.");
            }
        }
            media = soma/count;
            System.out.println("A soma dos número digitados é: "+soma+"\n" +
                               "A média dos números digitados é: "+media); 

        sc.close();
    }
}
