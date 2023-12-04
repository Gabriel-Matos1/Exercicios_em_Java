package escola;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DisciplinaTableModel extends AbstractTableModel {
    private final List<Disciplina> disciplinas;
    private final String[] colunas = {"Nome", "Professor"};

    public DisciplinaTableModel(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int getRowCount() {
        return disciplinas.size();
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
        Disciplina disciplina = disciplinas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return disciplina.getNome();
            case 1:
                return (disciplina.getProfessorQueMinistra() != null) ? disciplina.getProfessorQueMinistra().getNome() : "Não atribuído";
            default:
                return null;
        }
    }
}
