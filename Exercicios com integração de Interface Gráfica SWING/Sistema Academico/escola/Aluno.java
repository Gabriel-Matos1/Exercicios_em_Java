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

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private int periodo;
    private String[] disciplinasMatriculadas = new String[1];
    private int idade;
    private int quantidadeDisciplinasPermitidas;

    public Aluno(String nome, String matricula, String curso, int periodo, int idade, int quantidadeDisciplinasPermitidas) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.idade = idade;
        this.quantidadeDisciplinasPermitidas = quantidadeDisciplinasPermitidas;
        this.disciplinasMatriculadas = new String[quantidadeDisciplinasPermitidas];
    }

    public String fazMatricula(String disciplina) {
        if (this.disciplinasMatriculadas.length == 0) {
            return "Este aluno não pode ser matriculado em nenhuma disciplina, por favor, fale com a secretaria.";
        } else {
            int count = 0;
            for (int i = 0; i < disciplinasMatriculadas.length; i++) {
                if (disciplinasMatriculadas[i] != null) {
                    count++;
                }
            }
            if (count >= this.quantidadeDisciplinasPermitidas) {
                return "Quantidade de disciplinas excedida. O limite de disciplinas para este aluno é de " + this.quantidadeDisciplinasPermitidas + " disciplina(s). Se desejar, cancele a matrícula de uma das disciplinas e faça a nova matrícula.";
            } else {
                // Adiciona a nova disciplina ao array
                this.disciplinasMatriculadas[count] = disciplina;
                System.out.println("Matrícula na disciplina " + disciplina + " executada.");
                return "";
            }
        }
    }
    
    

    public String cancelarMatricula(String disciplina) {
        int posicao = -1;
        for (int i = 0; i < this.disciplinasMatriculadas.length; i++) {
            if (disciplina.equals(this.disciplinasMatriculadas[i])) {
                posicao = i;
                break;
            }
        }

        if (posicao != -1) {
            String[] novaArray = new String[this.disciplinasMatriculadas.length - 1];
            int novaArrayIndex = 0;
            for (int i = 0; i < this.disciplinasMatriculadas.length; i++) {
                if (i != posicao) {
                    novaArray[novaArrayIndex] = this.disciplinasMatriculadas[i];
                    novaArrayIndex++;
                }
            }

            this.disciplinasMatriculadas = novaArray;
            return "Cancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.";
        } else {
            return "Aluno não está matriculado na disciplina " + disciplina + ", portanto não é possível cancelar esta matrícula.";
        }
    }

    public void imprime() {
        System.out.println("Nome: " + this.nome + "\nMatricula: " + this.matricula + "\nCurso: " + this.curso + "\nPeríodo: " + this.periodo + "\nDisciplinas: ");
        for (int j = 0; j < this.disciplinasMatriculadas.length; j++) {
            System.out.println(this.disciplinasMatriculadas[j]);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String[] getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void setDisciplinasMatriculadas(String[] disciplinasMatriculadas) {
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }

    public int getQuantidadeDisciplinasPermitidas() {
        return quantidadeDisciplinasPermitidas;
    }

    public void setQuantidadeDisciplinasPermitidas(int quantidadeDisciplinasPermitidas) {
        this.quantidadeDisciplinasPermitidas = quantidadeDisciplinasPermitidas;
    }
}
