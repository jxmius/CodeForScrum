import java.util.ArrayList;
import java.util.List;

public class Task {
    private String taskName;
    private String taskDate;
    private String taskTime;
    private String taskDescription;
    private List<String> links;
    private String taskType;
    private Contributor assignedUser;
    private String dueDate;
    private List<Comments> comments;
    private List<TaskHistory> taskHistory;

    public Task(String taskName, String taskDate, String taskTime, String taskDescription,
                List<String> links, String taskType, Contributor assignedUser, String dueDate) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.taskDescription = taskDescription;
        this.links = links;
        this.taskType = taskType;
        this.assignedUser = assignedUser;
        this.dueDate = dueDate;
        this.comments = new ArrayList<>();
        this.taskHistory = new ArrayList<>();
    }

    public void addComment(Comments comment) {
        this.comments.add(comment);
    }

    public void addHistory(TaskHistory history) {
        this.taskHistory.add(history);
    }

    public void assignUser(Contributor user) {
        this.assignedUser = user;
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

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Contributor getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(Contributor assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<TaskHistory> getTaskHistory() {
        return taskHistory;
    }

    public void setTaskHistory(List<TaskHistory> taskHistory) {
        this.taskHistory = taskHistory;
    }
}
