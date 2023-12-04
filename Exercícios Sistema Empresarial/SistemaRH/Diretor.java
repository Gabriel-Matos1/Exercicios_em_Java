package SistemaRH;

class Diretor extends Funcionario {
    private int numDepartamentos;

    public Diretor(String nome, double salario, int numDepartamentos) {
        super(nome, salario);
        this.numDepartamentos = numDepartamentos;
    }

    @Override
    public double getBonus() {
        // Ajuste a lógica conforme necessário para calcular o bônus usando numDepartamentos
        return 4 * getSalario() + 3000 * numDepartamentos;
    }
}
