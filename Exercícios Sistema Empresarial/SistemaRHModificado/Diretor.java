package SistemaRHModificado;

class Diretor extends Funcionario {
    private int numDepartamentos;

    public Diretor(String nome, double salario, int numDepartamentos) {
        super(nome, salario);
        this.numDepartamentos = numDepartamentos;
    }

    @Override
    public double getBonus() {
        return 4 * getSalario() + 3000 * numDepartamentos;
    }
    public int getNumDepartamentos() {
        return numDepartamentos;
    }
}




