package SistemaRH;

abstract class Funcionario {
    private String nome;
    private double salario;
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public abstract double getBonus();

    @Override
    public String toString() {
        return "Nome: " + nome + ", Salário: " + salario;
    }
}