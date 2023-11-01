import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private ArrayList<Project> projectsList;
    private boolean userType;  // true for admin, false for a regular user

    public User(UUID uuid, String firstName, String lastName, String username, String password) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.projectsList = new ArrayList<>();
        this.userType = false; // Assuming false means a regular user, true means an admin
    }

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

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    public void setProjectsList(ArrayList<Project> projectsList) {
        this.projectsList = projectsList;
    }

    public void addProject(Project project) {
        projectsList.add(project);
    }

    public void deleteProject(Project project) {
        projectsList.remove(project);
    }

    public void addContributor(Project project, Contributor contributor) {
        project.addContributor(contributor);
    }

    
    public void addComment(Project project, Comments comment) {
        project.addComment(comment);
    }


    public void editTask(Task task, String newTaskName) {
        task.setTaskName(newTaskName);
    }
}
