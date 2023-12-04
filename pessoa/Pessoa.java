package Pessoa;

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
public class Pessoa {

    String nome;
    int idade;
    String endereco;

    public int fazAniversário(int idade){
        idade += 1;
        return idade;
    };
    
    public void imprime(int idade, String endereco, String nome){
        System.out.println("\nNome: "+nome+"\nidade: "+idade+"\nEndereço: "+endereco);
    }
}
