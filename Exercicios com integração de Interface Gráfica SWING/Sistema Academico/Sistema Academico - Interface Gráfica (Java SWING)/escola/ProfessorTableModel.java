package escola;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProfessorTableModel extends AbstractTableModel {
    private final List<Professor> professores;
    private final String[] colunas = {"Nome", "Idade"};

    public ProfessorTableModel(List<Professor> professores) {
        this.professores = professores;
    }

    @Override
    public int getRowCount() {
        return professores.size();
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
        Professor professor = professores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return professor.getNome();
            case 1:
                return professor.getIdade();
            default:
                return null;
        }
    }
}
