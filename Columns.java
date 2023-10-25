import java.util.ArrayList;

public class Columns {
    private String columnName;
    private ArrayList<String> taskArray;

    public Columns(String columnName) {
        this.columnName = columnName;
        this.taskArray = new ArrayList<>();
    }

    public void editTasks(int taskIndex, String newTask) {
        if (taskIndex >= 0 && taskIndex < taskArray.size()) {
            taskArray.set(taskIndex, newTask);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void addTasks(String newTask) {
        taskArray.add(newTask);
    }

    public void deleteTasks(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < taskArray.size()) {
            taskArray.remove(taskIndex);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public String getColumnName() {
        return columnName;
    }

    public ArrayList<String> getTaskArray() {
        return taskArray;
    }

    public void displayColumn() {
        System.out.println("Column Name: " + columnName);
        System.out.println("Tasks:");
        for (int i = 0; i < taskArray.size(); i++) {
            System.out.println("Task " + i + ": " + taskArray.get(i));
        }
    }

    public static void main(String[] args) {
        Columns column = new Columns("To-Do");

        column.addTasks("Task 1");
        column.addTasks("Task 2");
        column.addTasks("Task 3");

        column.displayColumn();

        column.editTasks(1, "Updated Task 2");
        column.displayColumn();

        column.deleteTasks(0);
        column.displayColumn();
    }
}
