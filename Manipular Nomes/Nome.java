import java.util.Scanner;

/*
 * Crie um programa “Nome” que leia um nome completo na linha de comando
e imprima-o ao contrário. 
*/
public class Nome {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Escreva seu nome completo: ");
            String nomeCompleto = sc.nextLine();

            String[] partesNome = nomeCompleto.split(" ");
            String[] nomes = new String[partesNome.length];

            for(int i = 0; i < partesNome.length; i++){
                nomes[i] = partesNome[i];
            }

            for(int j = partesNome.length - 1; j >= 0; j--){
                System.out.println(nomes[j]);
            }
        }
    }
}
