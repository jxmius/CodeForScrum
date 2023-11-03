import java.util.UUID;

public class ProjectSystemFACADE {
    private UserList userList;
    private ProjectList projectList;
    private DataWriter dataWriter;
    private DataLoader dataLoader;

    public ProjectSystemFACADE() {
        this.userList = UserList.getInstance();
        this.projectList = ProjectList.getInstance();
        this.dataWriter = new DataWriter();
        this.dataLoader = new DataLoader();
    }

    public User login(String userName, String password) {
        // In a real system, validate the user against a list of registered users or a database.
        // Handle cases where the login is successful or not.
        User user = userList.getUserByUsername(userName);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null; // Login failed
        }
    }

    public boolean signUp(String firstName, String lastName, String userName, String password) {
        // Check if the username is already in use.
        if (userList.getUserByUsername(userName) != null) {
            return false; // Username already in use
        }
        
        // Create a new user and save it.
        UUID uuid = UUID.randomUUID();
        User newUser = new User(uuid, userName, firstName, lastName, password);
        userList.addUser(newUser);
        dataWriter.saveUsers(userList);
        
        return true; // Signup successful
    }

    public Project getProject(String projectName) {
        // Retrieve a project from the list.
        return projectList.getProject(projectName);
    }
}
