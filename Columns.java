import java.util.ArrayList;

public class Columns {
    private String columnName;
    private ArrayList<String> taskArray;

    public Columns(String columnName) {
        this.columnName = columnName;
        this.taskArray = new ArrayList<>();
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

    public void addTasks(String task) {
        taskArray.add(task);
    }

    public void editTasks(int taskIndex, String newTask) {
        if (taskIndex >= 0 && taskIndex < taskArray.size()) {
            taskArray.set(taskIndex, newTask);
        } else {
            System.out.println("Invalid task index. Task not edited.");
        }
    }

    public void deleteTasks(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < taskArray.size()) {
            taskArray.remove(taskIndex);
        } else {
            System.out.println("Invalid task index. Task not deleted.");
        }
    }
}