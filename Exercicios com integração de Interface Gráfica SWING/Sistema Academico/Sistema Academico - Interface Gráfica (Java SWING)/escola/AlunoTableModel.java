package escola;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AlunoTableModel extends AbstractTableModel {
    private final List<Aluno> alunos;
    private final String[] colunas = {"Nome", "Matrícula", "Idade", "Curso", "Período"};

    public AlunoTableModel(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aluno.getNome();
            case 1:
                return aluno.getMatricula();
            case 2:
                return aluno.getIdade();
            case 3:
                return aluno.getCurso();
            case 4:
                return aluno.getPeriodo();
            default:
                return null;
        }
    }
}
