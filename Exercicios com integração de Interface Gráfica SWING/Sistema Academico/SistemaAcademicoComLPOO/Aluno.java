package SistemaAcademicoComLPOO;


class Aluno extends Pessoa {
    private String curso;
    private int periodo;
    private int quantidadeDisciplinasPermitidas;
    private String[] disciplinasMatriculadas;

    public Aluno(String nome, String matricula, int idade, String curso, int periodo, int quantidadeDisciplinasPermitidas) {
        super(nome, matricula, idade);
        this.curso = curso;
        this.periodo = periodo;
        this.quantidadeDisciplinasPermitidas = quantidadeDisciplinasPermitidas;
        this.disciplinasMatriculadas = new String[quantidadeDisciplinasPermitidas];
    }

    public String fazMatricula(String disciplina) {
        if (this.disciplinasMatriculadas.length == 0) {
            return "Este aluno não pode ser matriculado em nenhuma disciplina, por favor, fale com a secretaria.";
        } else {
            int disciplinasMatriculadasCount = 0;
            for (String disc : this.disciplinasMatriculadas) {
                if (disc != null) {
                    disciplinasMatriculadasCount++;
                }
            }
    
            if (this.quantidadeDisciplinasPermitidas <= disciplinasMatriculadasCount) {
                return "Quantidade de disciplinas excedida. O limite de disciplinas para este aluno é de " + this.quantidadeDisciplinasPermitidas + " disciplina(s). Se desejar, cancele a matrícula de uma das disciplinas e faça a nova matrícula.";
            } else {
                for (int i = 0; i < this.disciplinasMatriculadas.length; i++) {
                    if (this.disciplinasMatriculadas[i] == null) {
                        this.disciplinasMatriculadas[i] = disciplina;
                        break;
                    }
                }
                return "Matrícula na disciplina " + disciplina + " executada.";
            }
        }    }

    public String cancelarMatricula(String disciplina) {
        for (int i = 0; i < this.disciplinasMatriculadas.length; i++) {
            if (disciplina.equals(this.disciplinasMatriculadas[i])) {
                this.disciplinasMatriculadas[i] = null;
                return "Cancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.";
            }
        }
        return "Aluno não está matriculado na disciplina " + disciplina + ", portanto não é possível cancelar esta matrícula.";
    }

    public void imprime() {
        System.out.println("Nome: " + getNome() + "\nMatricula: " + getMatricula() + "\nCurso: " + curso + "\nPeríodo: " + periodo + "\nDisciplinas: ");
        for (String disciplina : this.disciplinasMatriculadas) {
            if (disciplina != null) {
                System.out.println(disciplina);
            }
        }
    }


}
