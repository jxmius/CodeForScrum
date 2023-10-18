import java.util.ArrayList;

public class Task {
    private String taskName;
    private String taskDate;
    private String taskTime;
    private String taskDescription;
    private String links;
    private String taskType;
    private ArrayList<String> comments = new ArrayList<>();

    public Task(String taskName, String taskDate, String taskTime, String taskDescription, String links, String taskType) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.taskDescription = taskDescription;
        this.links = links;
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public boolean editComment(int commentIndex, String newComment) {
        if (commentIndex >= 0 && commentIndex < comments.size()) {
            comments.set(commentIndex, newComment);
            return true;
        } else {
            return false;
        }
    }

    public void displayComments() {
        for (int i = 0; i < comments.size(); i++) {
            System.out.println("Comment " + (i + 1) + ": " + comments.get(i));
        }
    }
}