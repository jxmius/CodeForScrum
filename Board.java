import java.util.LinkedHashMap;
import java.util.Map;

public class Board {
    private String boardName;
    private Map<String, Columns> columnsMap;

    public Board(String boardName) {
        this.boardName = boardName;
        this.columnsMap = new LinkedHashMap<>();
    }

    public void addColumn(String columnName) {
        this.columnsMap.putIfAbsent(columnName, new Columns(columnName));
    }

    public boolean removeColumn(String columnName) {
        return this.columnsMap.remove(columnName) != null;
    }

    public Columns getColumn(String columnName) {
        return this.columnsMap.get(columnName);
    }

    public void setColumn(String columnName, Columns column) {
        this.columnsMap.put(columnName, column);
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public Map<String, Columns> getColumnsMap() {
        return columnsMap;
    }

    public void setColumnsMap(Map<String, Columns> columnsMap) {
        this.columnsMap = columnsMap;
    }

    public void displayBoard() {
        System.out.println("Board: " + boardName);
        for (Map.Entry<String, Columns> columnEntry : this.columnsMap.entrySet()) {
            System.out.println("Column: " + columnEntry.getKey());
            columnEntry.getValue().displayColumn();
        }
    }

    //add a task to a specific column for ease
    public boolean addTaskToColumn(String columnName, Task task) {
        Columns column = this.columnsMap.get(columnName);
        if (column != null) {
            column.addTask(task);
            return true;
        }
        return false;
    }

    //remove a specific task from a column for ease
    public boolean removeTaskFromColumn(String columnName, Task task) {
        Columns column = this.columnsMap.get(columnName);
        if (column != null) {
            return column.removeTask(task);
        }
        return false;
    }
    public boolean moveTask(String fromColumn, String toColumn, Task task) {
        Columns originColumn = this.columnsMap.get(fromColumn);
        Columns destinationColumn = this.columnsMap.get(toColumn);
        if (originColumn != null && destinationColumn != null) {
            if (originColumn.getTasks().remove(task)) {
                destinationColumn.addTask(task);
                return true;
            }
        }
        return false;
    }
}
