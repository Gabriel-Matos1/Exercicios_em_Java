package circunferencia;

/* Crie uma classe Circunferencia, que armazene o valor do raio e
seja capaz de informar sua área. Crie uma classe UsaCircunferencia para
testar objetos da classe Circunferencia*/

public class Circunferencia {
    double diametro;
    double circunferencia;

    public double calcularCircunferencia(double diametro){
            circunferencia = diametro * 3.14;
            return circunferencia;
    }
}
