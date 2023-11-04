import java.util.ArrayList;

public class Columns {
    private String columnName;
    private ArrayList<Task> tasks;

    public Columns(String columnName) {
        this.columnName = columnName;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public boolean removeTask(Task task) {
        return this.tasks.remove(task);
    }

    public void editTask(int taskIndex, Task task) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.set(taskIndex, task);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void displayColumn() {
        System.out.println("Column: " + columnName);
        for (Task task : tasks) {
            System.out.println(task.getTaskName() + " - " + task.getTaskDescription());
        }
    }
}
