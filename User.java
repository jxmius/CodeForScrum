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

    public void addProject(Project project) {
        projectsList.add(project);
    }

    public void deleteProject(Project project) {
        projectsList.remove(project);
    }

    public void getContributors(Project project, Contributor contributor) {
        project.getContributors();
    }

    public void getComments(Project project, Comment comment) {
        project.getComments(comment);
    }

    public void getProjectName(Project project, String projectName) {
        project.getProjectName();
    }

    public void getBoard(Project project, Board board) {
        project.getBoard();
    }

    public void getDateTime(Project project, String dateTime) {
        project.getDateTime();
    } 

    

}
