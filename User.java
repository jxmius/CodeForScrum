import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private ArrayList<Project> projectsList;
    private boolean userType;

    public User(UUID uuid, String firstName, String lastName, String username, String password, boolean userType) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.projectsList = new ArrayList<>();
        this.userType = userType;
    }

    public void callProject(Project project) {
        // Implementation for calling a project
    }

    public boolean checkUserType() {
        return userType;
    }

    public void addComment(Project project, String message) {
        project.addComment(message);
    }

    public void removeComment(Project project, String message) {
        project.removeComment(message);
    }

    public void editComment(Project project, String oldMessage, String newMessage) {
        project.editComment(oldMessage, newMessage);
    }

    public void addTask(Project project, Task task) {
        project.addTask(task);
    }

    public void removeTask(Project project, Task task) {
        project.removeTask(task);
    }

    public void editTask(Task task, String newTask) {
        task.editTask(newTask);
    }

    public void addProject(Board board, Project project) {
        board.addProject(project);
    }


    public void addContributor(Project project, Contributor contributor) {
        project.addContributor(contributor);
    }

    public void deleteContributor(Project project, Contributor contributor) {
        project.deleteContributor(contributor);
    }

    public void addProject(Project project) {
        projectsList.add(project);
    }

    public void deleteProject(Project project) {
        projectsList.remove(project);
    }

    public void editProjectDescription(Project project, String newDescription) {
        project.editProjectDescription(newDescription);
    }

    public void addColumns(Project project, Columns columns) {
        project.addColumns(columns);
    }

    public void deleteColumns(Project project, Columns columns) {
        project.deleteColumns(columns);
    }

    public void editColumns(Project project, Columns oldColumns, Columns newColumns) {
        project.editColumns(oldColumns, newColumns);
    }
}
