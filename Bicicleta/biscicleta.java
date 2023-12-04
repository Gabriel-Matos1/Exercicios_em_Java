package Bicicleta;

/*
 * Crie um tratamento de exceção (com exceções monitoradas) para os seguintes casos:
 valores de velocidade negativo ou superior a 100 km/h
 valores de RPM negativo,
 Valores de Marcha negativo ou superior a 24.
a. Lance estas exceções nos métodos setVelocidade, setRPM e setMarcha
b. Crie um construtor para a classe Bicicleta
c. Crie uma classe UsaBicicleta que teste estes casos. Faça o tratamento qualificado
das exceções nesta classe.
*/

class BicicletaException extends Exception {
    public BicicletaException(String message) {
        super(message);
    }
}

class Bicicleta {
    int cadencia = 0;
    int velocidade = 0;
    int marcha = 1;

    public Bicicleta() {
        // Construtor vazio
    }

    void setVelocidade(int novoValor) throws BicicletaException {
        if (novoValor < 0 || novoValor > 100) {
            throw new BicicletaException("Velocidade deve estar entre 0 e 100 km/h");
        }
        velocidade = novoValor;
    }

    void setRPM(int novoValor) throws BicicletaException {
        if (novoValor < 0) {
            throw new BicicletaException("RPM não pode ser negativo");
        }
        cadencia = novoValor;
    }

    void setMarcha(int novoValor) throws BicicletaException {
        if (novoValor < 0 || novoValor > 24) {
            throw new BicicletaException("Marcha deve estar entre 0 e 24");
        }
        marcha = novoValor;
    }

    void aumentarVelocidade(int incremento) {
        velocidade = velocidade + incremento;
    }

    void aplicarFreios(int decremento) {
        velocidade = velocidade - decremento;
    }

    void printStates() {
        System.out.println("\ncadencia=" + cadencia + "\n velocidade=" + velocidade + "\n marcha=" + marcha+"\n");
    }
}