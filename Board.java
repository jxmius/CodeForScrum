import java.util.ArrayList;

public class Board {
    private ArrayList<Columns> columns;

    public void addProject(Project project) {
        projects.add(project);
    }

    public Board() {
        this.columns = new ArrayList<>();
    }

    public void addColumns(Columns newColumns) {
        columns.add(newColumns);
    }
    

    public void editColumns(int columnIndex, Columns updatedColumns) {
        if (columnIndex >= 0 && columnIndex < columns.size()) {
            columns.set(columnIndex, updatedColumns);
        } else {
            System.out.println("Invalid column index. Column not edited.");
        }
    }

    public void deleteColumns(int columnIndex) {
        if (columnIndex >= 0 && columnIndex < columns.size()) {
            columns.remove(columnIndex);
        } else {
            System.out.println("Invalid column index. Column not deleted.");
        }
    }
}
