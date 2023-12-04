
package SistemaAcademicoComLPOO;

import java.util.List;
import java.util.Scanner;

public class SistemaAcademicoATV6 {
    private static Aluno[] alunos;
    private static Professor[] professores;
    private static Disciplina[] disciplinas;
    
    //ENTROU NO SISTEMA, APARECE ISSO/
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos alunos serão cadastrados?");
        int qtdeAlunos = scanner.nextInt();
        alunos = new Aluno[qtdeAlunos];

        System.out.println("Quantos professores serão cadastrados?");
        int qtdeProfessores = scanner.nextInt();
        professores = new Professor[qtdeProfessores];

        System.out.println("Quantas disciplinas serão cadastradas?");
        int qtdeDisciplinas = scanner.nextInt();
        disciplinas = new Disciplina[qtdeDisciplinas];

        for (int i = 0; i < qtdeDisciplinas; i++) {
            System.out.println("Digite o nome da disciplina " + (i + 1) + ": ");
            String nomeDisciplina = scanner.next();
            disciplinas[i] = new Disciplina(nomeDisciplina);
        }

        //ESCOJHE QUAL OPERAÇÃO QUER FAZER
        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha a opção desejada (ou 0 para sair): ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner);
                    break;
                case 2:
                    excluirAlunoPorNome(scanner);
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4:
                    cadastrarProfessor(scanner);
                    break;
                case 5:
                    excluirProfessorPorNome(scanner);
                    break;
                case 6:
                    listarProfessor();
                    break;
                case 7:
                    matricularAlunoEmDisciplina(scanner);
                    break;
                case 8:
                    AtrelarProfessorEmDisciplina(scanner);
                    break;                    
                case 9:
                    cancelarMatricula(scanner);
                    break;
                case 10:
                    imprimirListaDeAlunosEDisciplinas();
                    break;
                case 11:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

//////METODOS ALUNO
    
    public static void cadastrarAluno(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("Matricula: ");
        String matricula = scanner.next();

        System.out.print("Curso: ");
        String curso = scanner.next();

        System.out.print("Periodo: ");
        int periodo = scanner.nextInt();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        System.out.print("Quantidade de disciplinas permitidas: ");
        int quantidadeDisciplinasPermitidas = scanner.nextInt();

        Aluno aluno = new Aluno(nome, matricula, idade, curso, periodo, quantidadeDisciplinasPermitidas);
        cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void cadastrarAluno(Aluno aluno) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                alunos[i] = aluno;
                return;
            }
        }

        System.out.println("Não há espaço para cadastrar mais alunos.");
    }

    public static void excluirAlunoPorNome(Scanner scanner) {
        System.out.print("Digite o nome do aluno a ser excluído: ");
        String nome = scanner.next();

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].getNome().equalsIgnoreCase(nome)) {
                alunos[i] = null;
                System.out.println("Aluno excluído com sucesso!");
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }

    public static void listarAlunos() {
        for (Aluno aluno : alunos) {
            if (aluno != null) {
                aluno.imprime();
            }
        }
    }

    private static Aluno encontrarAlunoPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno != null && aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

//////METODOS PROFESSOR

    public static void cadastrarProfessor(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("Matricula: ");
        String matricula = scanner.next();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        System.out.print("Quantidade de disciplinas ministradas: ");
        int quantidadeDisciplinasMinistradas = scanner.nextInt();

        Professor professor = new Professor(nome, matricula, idade, quantidadeDisciplinasMinistradas);
        cadastrarProfessor(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public static void cadastrarProfessor(Professor professor) {
        for (int i = 0; i < professores.length; i++) {
            if (professores[i] == null) {
                professores[i] = professor;
                return;
            }
        }

        System.out.println("Não há espaço para cadastrar mais professores.");
    }

    public static void excluirProfessorPorNome(Scanner scanner) {
        System.out.print("Digite o nome do professor a ser excluído: ");
        String nome = scanner.next();

        for (int i = 0; i < professores.length; i++) {
            if (professores[i] != null && professores[i].getNome().equalsIgnoreCase(nome)) {
                professores[i] = null;
                System.out.println("Professor excluído com sucesso!");
                return;
            }
        }

        System.out.println("Professor não encontrado.");
    }

    public static void listarProfessor() {
        for (Professor professor : professores) {
            if (professor != null) {
                System.out.println("Nome: " + professor.getNome() +
                        "\nMatricula: " + professor.getMatricula() +
                        "\nIdade: " + professor.getIdade() +
                        "\nDisciplinas Ministradas: " + String.join(", ", professor.getDisciplinasMinistradas()) +
                        "\n------------------------");
            }
        }
    }

    private static Professor encontrarProfessorPorNome(String nome) {
        for (Professor professor : professores) {
            if (professor != null && professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }


 //////GESTÃO DAS DISCIPLINAS

    public static void matricularAlunoEmDisciplina(Scanner scanner) {
        System.out.print("Digite o nome do aluno para matrícula: ");
        String nomeAluno = scanner.next();

        Aluno aluno = encontrarAlunoPorNome(nomeAluno);

        if (aluno != null) {
            System.out.print("Digite o nome da disciplina para matrícula: ");
            String disciplina = scanner.next();
            String resultadoMatricula = aluno.fazMatricula(disciplina);
            System.out.println(resultadoMatricula);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void cancelarMatricula(Scanner scanner) {
        System.out.print("Digite o nome do aluno para cancelar matrícula: ");
        String nomeAluno = scanner.next();

        Aluno aluno = encontrarAlunoPorNome(nomeAluno);

        if (aluno != null) {
            System.out.print("Digite o nome da disciplina para cancelar matrícula: ");
            String disciplina = scanner.next();
            String resultadoCancelamento = aluno.cancelarMatricula(disciplina);
            System.out.println(resultadoCancelamento);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void AtrelarProfessorEmDisciplina(Scanner scanner) {
        System.out.print("Digite o nome do professor para atrelar a disciplina: ");
        String nomeProfessor = scanner.next();

        Professor professor = encontrarProfessorPorNome(nomeProfessor);

        if (professor != null) {
            System.out.print("Digite o nome da disciplina para atrelar ao professor: ");
            String disciplina = scanner.next();
            professor.adicionarDisciplina(disciplina);
            System.out.println("Disciplina atrelada ao professor com sucesso.");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }
    
    public static void DesatrelarProfessorEmDisciplina(Scanner scanner) {
        System.out.print("Digite o nome do Professor que será desligado da disciplina: ");
        String nomeProfessor = scanner.next();

        Professor professor = encontrarProfessorPorNome(nomeProfessor);

        if (professor != null) {
            System.out.print("Digite o nome da disciplina para desatrelar registro: ");
            String disciplina = scanner.next();
            String resultadoCancelamento = professor.cancelarMatricula(disciplina);
            System.out.println(resultadoCancelamento);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    //METODOS DE CONTROLE GERAL

    public static void imprimirListaDeAlunosEDisciplinas() {
        for (Aluno aluno : alunos) {
            if (aluno != null) {
                aluno.imprime();
            }
        }
    }
    
    public static void imprimirListaDeDisciplinas(List<Disciplina> disciplinas) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina != null) {
                disciplina.imprime();
            }
        }
    }



    private static void exibirMenu() {
        System.out.println("\nMenu:\n" +
        "1 - Cadastrar Aluno\n" +
        "2 - Excluir aluno por nome\n" +
        "3 - Listar alunos\n" +
        "4 - Cadastrar Professor\n" +
        "5 - Excluir Professor por Nome\n" +
        "6 - Listar Professores\n" +
        "7 - Matricular Aluno em Disciplina\n" +
        "8 - Atrelar Professor em Disciplina\n" +
        "9 - Cancelar Matrícula\n" +
        "10 - Imprimir lista Alunos e Disciplinas Matriculadas\n" +
        "11 - Sair do sistema");


    }
}
