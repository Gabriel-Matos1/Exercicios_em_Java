package escola;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;


class Aluno extends Pessoa {
    private String curso;
    private int periodo;
    private int quantidadeDisciplinasPermitidas;
    private Disciplina[] disciplinasMatriculadas;

    public Aluno(String nome, String matricula, int idade, String curso, int periodo, int quantidadeDisciplinasPermitidas) {
        super(nome, matricula, idade);
        this.curso = curso;
        this.periodo = periodo;
        this.quantidadeDisciplinasPermitidas = quantidadeDisciplinasPermitidas;
        this.disciplinasMatriculadas = new Disciplina[quantidadeDisciplinasPermitidas];
    }
    
    public String fazMatricula(Disciplina disciplina) {
    String resultado = "p";
        if (this.disciplinasMatriculadas.length == 0) {
            // ...
        } else {
            int disciplinasMatriculadasCount = 0;
            for (Disciplina disc : this.disciplinasMatriculadas) {
                if (disc != null) {
                    disciplinasMatriculadasCount++;
                }
            }
    
            if (this.quantidadeDisciplinasPermitidas <= disciplinasMatriculadasCount) {
                // ...
            } else {
                for (int i = 0; i < this.disciplinasMatriculadas.length; i++) {
                    if (this.disciplinasMatriculadas[i] == null) {
                        this.disciplinasMatriculadas[i] = disciplina;
                        break;
                    }
                }
               resultado = "Matrícula na disciplina " + disciplina.getNome() + " executada.";
            }
        }
        return resultado;
    }
            public Disciplina[] getDisciplinasMatriculadas() {
            return disciplinasMatriculadas;
        }
                
    public String cancelarMatricula(String disciplina) {
        for (int i = 0; i < this.disciplinasMatriculadas.length; i++) {
            if (disciplina.equals(this.disciplinasMatriculadas[i])) {
                this.disciplinasMatriculadas[i] = null;
                return "Cancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.";
            }
        }
        return "Aluno não está matriculado na disciplina " + disciplina + ", portanto não é possível cancelar esta matrícula.";
    }

    public List<JLabel> getSwingTextLabels() {
        List<JLabel> labels = new ArrayList<>();
    
        // Crie um rótulo para cada informação que você deseja exibir
        JLabel nomeLabel = new JLabel("Nome: " + getNome());
        JLabel matriculaLabel = new JLabel("Matricula: " + getMatricula());
        JLabel cursoLabel = new JLabel("Curso: " + curso);
        JLabel periodoLabel = new JLabel("Período: " + periodo);
        JLabel disciplinasIntroLabel = new JLabel("Disciplinas:");
    
        labels.add(nomeLabel);
        labels.add(matriculaLabel);
        labels.add(cursoLabel);
        labels.add(periodoLabel);
        labels.add(disciplinasIntroLabel);
    
        // Adicione um rótulo para cada disciplina
        for (Disciplina disciplina : this.disciplinasMatriculadas) {
            if (disciplina != null) {
                JLabel disciplinaLabel = new JLabel("Disciplina: " + disciplina.getNome());
                labels.add(disciplinaLabel);
            }
        }
    
        return labels;
    }
    

    public String imprimir() {
        return "Nome: " + getNome() + "\nMatrícula: " + getMatricula() + "\nCurso: " + curso + "\nPeríodo: " + periodo;
    }
        public String imprime() {
        return "Nome: " + getNome() + "\nMatrícula: " + getMatricula() + "\nCurso: " + curso + "\nPeríodo: " + periodo;
    }
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Métodos get e set para a propriedade 'periodo'
    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}




