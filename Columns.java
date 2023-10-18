import java.util.ArrayList;

public class Column {
    private String columnName;
    private ArrayList<String> taskArray = new ArrayList<>();

    public Column(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ArrayList<String> getTaskArray() {
        return taskArray;
    }

    public void addTask(String task) {
        taskArray.add(task);
    }

    public void editTasks() {
        // Implementation for editing tasks in the column
        // You can add your logic here
    }

    public void addTasks() {
        // Implementation for adding tasks to the column
        // You can add your logic here
    }

    public void deleteTasks() {
        // Implementation for deleting tasks from the column
        // You can add your logic here
    }
}