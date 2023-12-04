package escola;
public class Disciplina {
    private String nome;
    private Aluno[] discentesDestaDisciplina;
    private Professor professorQueMinistra; // Modificado para String

    public Disciplina(String nome, Professor professorQueMinistra) {
        this.nome = nome;
        this.professorQueMinistra = professorQueMinistra;
    }
    public String getNome() {
        return nome;
    }

    public void setProfessorQueMinistra(Professor professor) {
        this.professorQueMinistra = professor;
    }

    public Professor getProfessorQueMinistra() {
        return professorQueMinistra;
    }

    public void setDiscentesDestaDisciplina(Aluno[] discentes) {
        this.discentesDestaDisciplina = discentes;
    }

    public Aluno[] getDiscentesDestaDisciplina() {
        return discentesDestaDisciplina;
    }

    public void imprime() {
        System.out.println("Disciplina: " + getNome());
        System.out.println("Professor: " + (professorQueMinistra != null ? professorQueMinistra.getNome() : "Não atribuído"));
        System.out.println("Alunos matriculados: ");
        if (discentesDestaDisciplina != null) {
            for (Aluno aluno : discentesDestaDisciplina) {
                if (aluno != null) {
                    System.out.println(aluno.getNome());
                }
            }
        }
    }
}
