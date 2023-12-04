package SistemaRHModificado;

import java.util.Scanner;

public class SistemaRH {
    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[10];
        try (Scanner sc = new Scanner(System.in)) {

            int opc = 2;
            int c=0;
            String nome = " ";
            while (opc == 2) {
                if(c==0){
                System.out.println("\nQual o nome do funcionário?");
                nome = sc.nextLine();
            }
                System.out.println("\nQual o cargo do Funcionário?\n1. Diretor\n2. Gerente\n3. Analista\n4. Sair.");
                int cargo = sc.nextInt();
            
                sc.nextLine();
                if (cargo != 4) {
                    System.out.println("Qual o salário?");
                    double salario = sc.nextDouble();

                    double bonus = 0;

                    switch (cargo) {
                        case 1:  System.out.println("Quantos departamentos o funcionário gerencia?");
                        int qtdeDepartamentos = sc.nextInt();
                        bonus = 4 * salario + 3000 * qtdeDepartamentos;
        
                        try {
                            Diretor nelson = new Diretor(nome, salario, qtdeDepartamentos);
                            verificarDepartamentos(nelson);
                            // Se verificarDepartamentos não lançar exceção, cadastra o funcionário
                            cadastrarFuncionario(funcionarios, nelson);
                        } catch (DepartamentosInsuficientesException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
        
                    case 2:
                        System.out.println("Quantas pessoas o funcionário gerencia?");
                        int qtdePessoasGerenciadas = sc.nextInt();
                        bonus = 2 * salario + 100 * qtdePessoasGerenciadas;
        
                        try {
                            Gerente bob = new Gerente(nome, salario, qtdePessoasGerenciadas);
                            verificarEquipe(bob);
                            // Se verificarEquipe não lançar exceção, cadastra o funcionário
                            cadastrarFuncionario(funcionarios, bob);
                        } catch (EquipeInsuficienteException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                        case 3:
                            bonus = salario;
                            cadastrarFuncionario(funcionarios, new Analista(nome, salario));
                            break;

                        default:
                            break;
                    }

                    System.out.println("\nQuer cadastrar mais alguém?\n1. Não\n2. Sim\n");
                    opc = sc.nextInt();
                System.out.println("\nQual o nome do funcionário?");
                 nome = sc.nextLine();

                } else {
                    opc = 1;
                }
             }

            imprimeRelatorio(funcionarios);
            System.out.println("\nAté mais!\n");
        }
    }




    public static void cadastrarFuncionario(Funcionario[] funcionarios, Funcionario novoFuncionario) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] == null) {
                funcionarios[i] = novoFuncionario;
                return;
            }
        }
        System.out.println("Não há espaço para cadastrar mais Funcionários.");
    }

    public static void imprimeRelatorio(Funcionario[] listaFuncionarios) {
        System.out.println("Relatório de Funcionários:");
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario != null) {
                System.out.println(funcionario + ", Bônus: " + funcionario.getBonus());
            }
        }
    }
    private static void verificarEquipe(Gerente gerente) throws EquipeInsuficienteException {
        if (gerente.getQtdePessoasGerenciadas() < 5) {
            throw new EquipeInsuficienteException("A equipe do gerente deve ter no mínimo 5 pessoas. \nFuncionário não registrado!");
        }
    }

    private static void verificarDepartamentos(Diretor diretor) throws DepartamentosInsuficientesException {
        if (diretor.getNumDepartamentos() < 2) {
            throw new DepartamentosInsuficientesException("O diretor deve ter no mínimo 2 departamentos.\\n" + //
                    "Funcionário não registrado!");
        }
    }
}
