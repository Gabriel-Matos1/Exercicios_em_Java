package SistemaAcademicoComLPOO;

public class Disciplina {
    private String nome;
    private Aluno[] discentesDestaDisciplina;
    private Professor professorQueMinistra;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public void setProfessorQueMinistra(Professor professor) {
        // Adaptação para permitir a definição do professor que ministra a disciplina
        this.professorQueMinistra = professor;
    }

    public Professor getProfessorQueMinistra() {
        // Adaptação para obter o professor que ministra a disciplina
        return professorQueMinistra;
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
