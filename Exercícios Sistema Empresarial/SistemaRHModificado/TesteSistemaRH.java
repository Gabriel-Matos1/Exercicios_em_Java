package SistemaRHModificado;

public class TesteSistemaRH {
    
    public static void main(String[] args) {
        try {
            Gerente gerente = new Gerente("João", 5000.0, 3); // Altere a quantidade conforme necessário
            verificarEquipe(gerente);

            Diretor diretor = new Diretor("Maria", 10000.0, 1); // Altere a quantidade conforme necessário
            verificarDepartamentos(diretor);
        } catch (EquipeInsuficienteException | DepartamentosInsuficientesException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void verificarEquipe(Gerente gerente) throws EquipeInsuficienteException {
        if (gerente.getQtdePessoasGerenciadas() < 5) {
            throw new EquipeInsuficienteException("A equipe do gerente deve ter no mínimo 5 pessoas.");
        }
    }

=    private static void verificarDepartamentos(Diretor diretor) throws DepartamentosInsuficientesException {
        if (diretor.getNumDepartamentos() < 2) {
            throw new DepartamentosInsuficientesException("O diretor deve ter no mínimo 2 departamentos.");
        }
    }
}
