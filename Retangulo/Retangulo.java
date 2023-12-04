package Retangulo;

/*
 * Modifique a classe Retangulo, para que uma exceção
IllegalArgumentException seja lançada se os lados informados forem negativos. Adapte
adequadamente o programa principal, para que a exceção seja capturada.
4. Crie uma exceção monitorada chamada LadoInvalidoException e altere o programa
anterior para que esta exceção seja lançada, no lugar de IllegalArgumentException.
*/

class Retangulo {
    private double comprimento;
    private double largura;

    public Retangulo(double comprimento, double largura) throws LadoInvalidoException {
        if (comprimento <= 0 || largura <= 0) {
            throw new LadoInvalidoException("Os lados do retângulo devem ser valores positivos.");
        }

        this.comprimento = comprimento;
        this.largura = largura;
    }

    public double calcularArea() {
        return comprimento * largura;
    }

}

