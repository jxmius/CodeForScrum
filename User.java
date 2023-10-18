import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private ArrayList<String> projectsList;
    private boolean userType;

    public User(UUID uuid, String firstName, String lastName, String username, String password) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.projectsList = new ArrayList<>();
    }

    public void callProject() {
        // Implement the logic for calling a project.
    }

    public boolean checkUserType() {
        // Implement the logic for checking the user type.
        return userType;
    }

    public void addComment(Project project, String message) {
        // Implement the logic to add a comment to a project.
    }

    public void removeComment(Project project, String message) {
        // Implement the logic to remove a comment from a project.
    }

    public void editComment() {
        // Implement the logic to edit a comment.
    }

    public void addTask() {
        // Implement the logic to add a task.
    }

    public void removeTask() {
        // Implement the logic to remove a task.
    }

    public void editTask() {
        // Implement the logic to edit a task.
    }

    public void addProject(Board board) {
        // Implement the logic to add a project to a board.
    }

    public void addContributor(Contributor contributor) {
        // Implement the logic to add a contributor to a project.
    }

    public void deleteContributor(Contributor contributor) {
        // Implement the logic to delete a contributor from a project.
    }

    public void addProject(Project project) {
        // Implement the logic to add a project to the user's project list.
    }

    public void deleteProject(Project project) {
        // Implement the logic to delete a project from the user's project list.
    }

    public void editProjectDescription() {
        // Implement the logic to edit the description of a project.
    }

    public void addColumns(Columns columns) {
        // Implement the logic to add columns to a project.
    }

    public void deleteColumns(Columns columns) {
        // Implement the logic to delete columns from a project.
    }

    public void editColumns(Columns columns) {
        // Implement the logic to edit columns in a project.
    }
}