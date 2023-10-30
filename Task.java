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

    // Getter and Setter methods for attributes (e.g., getTaskName, setTaskName)
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getLinks() {
        return links;
    }

    public String getTaskType() {
        return taskType;
    }
    // Setter methods
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void removeComment(int commentIndex) {
        if (commentIndex >= 0 && commentIndex < comments.size()) {
            comments.remove(commentIndex);
        }
    }

    @Override
    public String toString() {
        // Create a custom string representation of the task
        // Include taskName, taskDate, taskTime, taskDescription, links, taskType, and comments
        // You can format it as needed
        return "Task: " + taskName + "\nDate: " + taskDate + "\nTime: " + taskTime
                + "\nDescription: " + taskDescription + "\nLinks: " + links
                + "\nType: " + taskType + "\nComments: " + comments;
    }
}
