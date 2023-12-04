package pessoa;
import java.util.Scanner;

/*
 *  Escreva a estrutura de uma classe (atributos e métodos) para
representar uma Pessoa (nome, idade e endereço):
a. Compile a classe;
b. Crie uma outra classe que utilize um objeto Pessoa. Leia informações de
nome, idade e endereço, e mostre todos os dados e a idade da pessoa. O
programa deve usar os métodos do objeto.
c. Acrescente dois métodos:
 fazAniversario(): que incrementa a idade da pessoa
 imprime(): Que imprime de forma legível todos os atributos da pessoa
d. Altere o método main (que utiliza a classe pessoa) para que instancie
uma pessoa, utilize algumas vezes o método fazAniversario e imprima os
atributos do objeto pessoa.

*/

public class Ler {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa();
    
        try (Scanner sc = new Scanner(System.in)) {
    
            System.out.println("Qual o nome?");
            p1.nome = sc.nextLine();
            System.out.println("Qual a idade?");
            p1.idade = sc.nextInt();
    
            // Consumir a quebra de linha pendente
            sc.nextLine();
    
            System.out.println("Qual o endereço?");
            p1.endereco = sc.nextLine();
    
            p1.idade = p1.fazAniversário(p1.idade);
            p1.idade = p1.fazAniversário(p1.idade);
            p1.idade = p1.fazAniversário(p1.idade);
 
            p1.imprime(p1.idade, p1.endereco, p1.nome);
        }
    }
    
}