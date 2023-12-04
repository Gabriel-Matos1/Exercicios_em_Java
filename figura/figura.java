package Figura;
/*
 *  Implemente a estrutura de classes representada na figura a seguir, de acordo
com as instruções abaixo:
a. A implementação de operacao1() deve mostrar no console que passou por tal método
e o valor dos atributos do objeto;
b. A implementação de operacao2() deve mostrar no console que passou por tal método;
c. O construtor C() deve inicializar seus atributos 1 e 2 com “VAZIO”e -999.99f,
respectivamente;
d. O construtor C(String p1, float p2) deve inicializar seus atributos com os valores
providos por parâmetro;
e. Os construtores de C_12 devem chamar os construtores respectivos da superclasse e
inicializar a matriz atributo3. Se o construtor for sem parâmetros, a matriz deve ser 2 x
2 e seus elementos possuir valor 0. Se o construtor possuir parâmetros, a matriz deve
ser 3 x 3 e seus elementos devem possuir valor 1;
f. O método main deve possuir o código indicado a seguir. Entenda a origem de todas
as saídas;
public static void main (String args[]){
System.out.println ("Iniciando o programa...");
System.out.println ("Instanciando C1_2 sem parametros:");
C1_2 objC1 = new C1_2();
System.out.println ("Instanciando C1_2 com parametros:");
C1_2 objC2 = new C1_2("XPTO", 3.141516f);
System.out.println ("Chamando operacoes na instancia 1:");
objC1.operacao1();
objC1.operacao2();
System.out.println ("Chamando operacoes na instancia 2:");
objC2.operacao1();
objC2.operacao2();
System.out.println ("Instanciando objeto em referencia para interface:");
I1 objC3 = new C1_2("YSBC", 1.99f);;
System.out.println ("Chamando operacoes na referencia para interface:");
objC3.operacao1();
}

*/
public class figura {
    public static void main(String args[]) {
        System.out.println("Iniciando o programa...");

        System.out.println("Instanciando C1_2 sem parametros:");
        C1_2 objC1 = new C1_2();

        System.out.println("Instanciando C1_2 com parametros:");
        C1_2 objC2 = new C1_2("XPTO", 3.141516f);

        System.out.println("Chamando operacoes na instancia 1:");
        objC1.operacao1();
        objC1.operacao2();

        System.out.println("Chamando operacoes na instancia 2:");
        objC2.operacao1();
        objC2.operacao2();

        System.out.println("Instanciando objeto em referencia para interface:");
        I1 objC3 = new C1_2("YSBC", 1.99f);
        System.out.println("Chamando operacoes na referencia para interface:");
        objC3.operacao1();
    }
}
