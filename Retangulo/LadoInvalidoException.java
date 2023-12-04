package Retangulo;


/*
 * Modifique a classe Retangulo, para que uma exceção
IllegalArgumentException seja lançada se os lados informados forem negativos. Adapte
adequadamente o programa principal, para que a exceção seja capturada.
4. Crie uma exceção monitorada chamada LadoInvalidoException e altere o programa
anterior para que esta exceção seja lançada, no lugar de IllegalArgumentException.
*/


class LadoInvalidoException extends Exception {
    public LadoInvalidoException(String message) {
        super(message);
    }
}