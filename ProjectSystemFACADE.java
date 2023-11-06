import java.io.PrintWriter;
import java.util.Optional;

public class ProjectSystemFACADE {
    private ProjectList projectList;
    private UserList userList; // not working??

    public ProjectSystemFacade() {
        this.projectList = ProjectList.getInstance(); 
        this.userList = UserList.getInstance(); 
    }

    public void openProject(String projectName) {
        // Implementation 
    }

    public void addTaskToProject(String projectName, String taskName, String assigneeUsername, String taskDescription) {
        Project project = findProjectByName(projectName);
        User assignee = userList.getUser(assigneeUsername);
        Contributor contributor = new Contributor(assignee.getUsername(), assignee.getFirstName(), assignee.getLastName());
        Task newTask = new Task(taskName, /* other params */);
        newTask.assignUser(contributor);
        project.getBoard().addTaskToColumn("To Do", newTask);
    }

    public void addCommentToTask(String projectName, String taskName, String commentText) {
        Task task = findTaskByName(projectName, taskName);
        if (task != null) {
            Comments comment = new Comments("Atticus Madden", commentText, /* current dateTime */);
            task.addComment(comment);
        }
    }

    public void moveTaskToColumn(String projectName, String taskName, String columnName) {
        Project project = findProjectByName(projectName);
        Task task = findTaskByName(projectName, taskName);
        project.getBoard().moveTask(/* fromColumn */, columnName, task);
    }

    public void addColumnToBoard(String projectName, String columnName) {
        Project project = findProjectByName(projectName);
        project.getBoard().addColumn(columnName);
    }

    public void printScrumBoardToFile(String projectName, String filename) {
        Project project = findProjectByName(projectName);
        Board board = project.getBoard();

        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("SCRUM Board for: " + projectName);
            board.getColumnsMap().forEach((column, tasks) -> {
                writer.println("Column: " + column);
                tasks.getTasks().forEach(task -> {
                    writer.println("  Task: " + task.getTaskName());
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Project findProjectByName(String projectName) {
        // Implementation
        return null;
    }

    private Task findTaskByName(String projectName, String taskName) {
        // Implementation
        return null;
    }
}
