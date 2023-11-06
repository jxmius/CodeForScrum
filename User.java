import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class User {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private List<UUID> projectIds; 
    private boolean userType; 

    public User(UUID uuid, String firstName, String lastName, String username, String password) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.projectIds = new ArrayList<>(); 
        this.userType = false; 
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

    public void addProjectId(UUID projectId) {
        this.projectIds.add(projectId);
    }
    public void setUserType(boolean userType) {
        this.userType = userType;
    }
    public List<UUID> getProjectIds() {
        return projectIds;
    }
    public void setProjectIds(List<UUID> projectIds) {
        this.projectIds = projectIds;
    }


}
