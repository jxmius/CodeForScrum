import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private ArrayList<Project> projectsList;
    private boolean userType;  // true for admin, false for regular user

    public User(String firstName, String lastName, String username, String password) {
        this.uuid = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.projectsList = new ArrayList<>();
        this.userType = false; // Assuming false means a regular user, true means an admin
    }

    // Getter methods for attributes
    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUserTypeAdmin() {
        return userType;
    }

    public ArrayList<Project> getProjectsList() {
        return projectsList;
    }

    // Method to add a project to the user's project list
    public void addProject(Project project) {
        projectsList.add(project);
    }

    // Method to delete a project from the user's project list
    public void deleteProject(Project project) {
        projectsList.remove(project);
    }

    // Method to add a contributor to a project
    public void addContributor(Project project, Contributor contributor) {
        project.addContributor(contributor);
    }

    // Method to delete a contributor from a project
    public void deleteContributor(Project project, Contributor contributor) {
        project.removeContributor(contributor);
    }

    // Method to add a comment to a project
    public void addComment(Project project, Comments comment) {
        project.addComment(comment);
    }

    // Method to remove a comment from a project
    public void removeComment(Project project, Comments comment) {
        project.removeComment(comment);
    }

    // Other methods for managing tasks, editing project descriptions, etc.

    // Method to add a task to a project
    public void addTask(Project project, Columns columns, String task) {
        project.addTask(columns, task);
    }

    // Method to remove a task from a project
    public void removeTask(Project project, Columns columns, String task) {
        project.removeTask(columns, task);
    }

    // Method to edit a task in a project
    public void editTask(Project project, Columns columns, String oldTask, String newTask) {
        project.editTask(columns, oldTask, newTask);
    }

    // Method to add a project to the user's project list
    public void addProject(Project project) {
        projectsList.add(project);
    }

    // Method to delete a project from the user's project list
    public void deleteProject(Project project) {
        projectsList.remove(project);
    }

    // Method to edit the description of a project
    public void editProjectDescription(Project project, String newDescription) {
        project.editDescription(newDescription);
    }

    // Method to add columns to a project
    public void addColumns(Project project, Columns columns) {
        project.addColumns(columns);
    }

    // Method to delete columns from a project
    public void deleteColumns(Project project, Columns columns) {
        project.deleteColumns(columns);
    }

    // Method to edit columns in a project
    public void editColumns(Project project, Columns oldColumns, Columns newColumns) {
        project.editColumns(oldColumns, newColumns);
    }
}
