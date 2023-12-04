package SistemaAcademicoComLPOO;


class Professor extends Pessoa {
    
    private String[] disciplinasMinistradas;

    public Professor(String nome, String matricula, int idade, int quantidadeDisciplinasMinistradas) {
        super(nome, matricula, idade);
        this.disciplinasMinistradas = new String[quantidadeDisciplinasMinistradas];
    }

    public void adicionarDisciplina(String disciplina) {
        for (int i = 0; i < this.disciplinasMinistradas.length; i++) {
            if (this.disciplinasMinistradas[i] == null) {
                this.disciplinasMinistradas[i] = disciplina;
                break;
            }
        }
    }

    public String[] getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public String cancelarMatricula(String disciplina) {
        for (int i = 0; i < this.disciplinasMinistradas.length; i++) {
            if (disciplina.equals(this.disciplinasMinistradas[i])) {
                this.disciplinasMinistradas[i] = null;
                return "Desatrelamento entre o(a) Professor(a) e a disciplina " + disciplina + " executado com sucesso.";
            }
        }
        return "Professor não está registrado na disciplina " + disciplina + ", portanto não é possível cancelar o registro.";
    }

}

