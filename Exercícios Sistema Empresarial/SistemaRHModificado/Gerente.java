package SistemaRHModificado;

class Gerente extends Funcionario {
    private int qtdePessoasGerenciadas;

    public Gerente(String nome, double salario, int qtdePessoasGerenciadas) {
        super(nome, salario);
        this.qtdePessoasGerenciadas = qtdePessoasGerenciadas;
    }

    @Override
    public double getBonus() {
        return 2 * getSalario() + 100 * qtdePessoasGerenciadas;
    }
    public int getQtdePessoasGerenciadas() {
        return qtdePessoasGerenciadas;
    }
}
