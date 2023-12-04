package escola;

/*
 *  Escreva a estrutura de uma classe (atributos e métodos) para
representar um aluno (nome, matricula, curso, período,
disciplinasMatriculadas(array de String) e endereço):
a. Compile a classe;
b. Crie um construtor para essa classe com a seguinte assinatura:
public Aluno(String nome, String matricula, String curso, int periodo, int idade,
int quantidadeDisciplinasPermitidadas)
Onde a quantidadeDisciplinasPermitidadas representa a quantidade de
disciplinas que o aluno pode se matricular. Deve ser utilizada para
redimensionar o array de Strings.
c. Acrescente três métodos:
 String fazMatricula(String disciplina): inclui uma disciplina no array de
Strings. Se o aluno já ultrapassou a quantidade de disciplinas que
pode se matricular, então o sistema retorna para este método uma
string informando: “Quantidade de disciplinas excedida. O limite de
disciplinas para este aluno é de 2 disciplina(s). Se desejar, cancele a
matrícula de uma das disciplinas e faça a nova matrícula.”
Se o aluno não puder ser matriculado em nenhuma disciplina
(tamanho do array=0), então o método deve retornar: “Este aluno não
pode ser matriculado em nenhuma disciplina, por favor, fale com a
secretaria.”
Se foi matriculado com sucesso a seguinte String é retornada:
“Matrícula na disciplina “LPOO” executada.”
 String cancelarMatricula(String disciplina): exclui a disciplina do array
de Strings. Se o aluno não estiver matriculado na disciplina, o método
deve retornar: “Aluno não está matriculado na disciplina LPOO,
portanto não é possível cancelar esta matrícula.”. Se o aluno
realmente estiver matriculado na disciplina, então o método deve
retornar “Cancelamento da matrícula da disciplina LPOO executado
com sucesso.”
 String imprime(): Método que retorna uma String de forma legível com
todos os atributos de aluno e as disciplinas matriculadas no seguinte
formato:
-----------------------------------------------------------------
Nome do Aluno: Rafael Romualdo Wandresen
Matricula: GRR20130101
Curso: TADS
Periodo: 4
Disciplinas Matriculadas: Gestão de Projetos; LPOO
-----------------------------------------------------------------
d. Crie uma outra classe (SistemaAcademico) que utilize objetos do tipo
Aluno. Nessa classe instancie um array de Alunos que armazene os
alunos criados. Crie um menu com as seguintes opções: 1 – Cadastrar
Aluno, 2 – Excluir aluno por nome, 3 – Listar Alunos, 4 – Matricular Aluno
em Disciplina, 5 – Cancelar Matrícula, 6 – Imprimir lista Alunos e
Disciplinas Matriculadas. Cada um destes itens do menu deve ter um
método associado com os seguintes métodos. Criar todos os métodos
estáticos:
1. public static void cadastrarAluno(Aluno aluno)
2. public static void excluirAlunoPorNome(String nomeAluno)
3. public static Aluno[] listarAlunos()
4. public static String matricularAlunoEmDisciplina(Aluno aluno,
String disciplina). Onde o retorno informa o que ocorreu com a
matricula do aluno, conforme especificado no método
fazMatricula.
5. public static String cancelarMatricula(Aluno aluno, String
disciplina)
6. public static String imprimirListaDeAlunoseDisciplinas ()
e. Quando o sistema iniciar deve pedir ao usuário para informar a
quantidade de alunos que serão cadastrados. Com essa informação
dimensione o array.
f. Quando o usuário optar pela opção 4, se for a primeira disciplina do
aluno, o sistema deve perguntar em quantas disciplinas o aluno deve ser
matriculado. Com essa informação dimensione o array de Strings.
*/
import java.util.Scanner;

public class SistemaAcademico {
    private static Aluno[] alunos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos alunos serão cadastrados?");
        int qtdeAlunos = scanner.nextInt();
        alunos = new Aluno[qtdeAlunos];

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
                    matricularAlunoEmDisciplina(scanner);
                    break;
                case 5:
                    cancelarMatricula(scanner);
                    break;
                case 6:
                    imprimirListaDeAlunosEDisciplinas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

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

        Aluno aluno = new Aluno(nome, matricula, curso, periodo, idade, quantidadeDisciplinasPermitidas);
        cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void cadastrarAluno(Aluno aluno) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                // Verifica se o array de disciplinasMatriculadas já foi inicializado
                if (aluno.getQuantidadeDisciplinasPermitidas() != aluno.getDisciplinasMatriculadas().length) {
                    // Inicializa o array com o tamanho correto
                    aluno.setDisciplinasMatriculadas(new String[aluno.getQuantidadeDisciplinasPermitidas()]);
                }
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
    public static void imprimirListaDeAlunosEDisciplinas() {
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
    private static void exibirMenu() {
        System.out.println("\nMenu:\n" +
                "1 - Cadastrar Aluno\n" +
                "2 - Excluir aluno por nome\n" +
                "3 - Listar alunos\n" +
                "4 - Matricular Aluno em Disciplina\n" +
                "5 - Cancelar Matrícula\n" +
                "6 - Imprimir lista Alunos e Disciplinas Matriculadas");
    }
}

