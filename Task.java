import java.util.ArrayList;

public class Task {
    private String taskName;
    private String taskDate;
    private String taskTime;
    private String taskDescription;
    private String links;
    private String taskType;
    private ArrayList<String> comments;

    public Task(String taskName, String taskDate, String taskTime, String taskDescription, String links, String taskType) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.taskDescription = taskDescription;
        this.links = links;
        this.taskType = taskType;
        this.comments = new ArrayList<>();
    }

    public void addTask(String newTask) {
        taskName = newTask;
    }

    public void editTask(String newTask) {
        taskName = newTask;
    }

    public boolean editType(String newType) {
        if (newType != null && !newType.isEmpty()) {
            taskType = newType;
            return true;
        } else {
            return false;
        }
    }

    public void removeTask(ArrayList<Task> taskList) {
        // Find and remove this task from the list
        taskList.remove(this);
    }

    public void addComments(String comment) {
        comments.add(comment);
    }

    public void displayComments() {
        for (String comment : comments) {
            System.out.println(comment);
        }
    }

    public boolean editComments(int commentIndex, String newComment) {
        if (commentIndex >= 0 && commentIndex < comments.size()) {
            comments.set(commentIndex, newComment);
            return true;
        } else {
            return false;
        }
    }
}
