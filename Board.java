import java.util.ArrayList;

public class Board {
    private String boardName;
    private ArrayList<Columns> columns;

    public Board(String boardName) {
        this.boardName = boardName;
        this.columns = new ArrayList<>();
    }

    // Getter and setter methods for the board names
    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    // Getter and setter methods for columns
    public ArrayList<Columns> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Columns> columns) {
        this.columns = columns;
    }

    // Method to add a new column
    public void addColumn(Columns column) {
        columns.add(column);
    }

    // Method to edit an existing column
    public void editColumn(Columns oldColumn, Columns newColumn) {
        if (columns.contains(oldColumn)) {
            int index = columns.indexOf(oldColumn);
            columns.set(index, newColumn);
        }
    }

    // Method to delete a column
    public void deleteColumn(Columns column) {
        columns.remove(column);
    }
}
