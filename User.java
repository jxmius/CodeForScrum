import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String username;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String password;
    private boolean userType;
    private List<UUID> projectIds;

    public User(UUID uuid, String username, String firstName, String lastName, String userEmail, String password, boolean userType) {
        this.uuid = uuid;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.password = password;
        this.userType = userType;
        this.projectIds = new ArrayList<>();
    }

    public void addProjectId(UUID projectId) {
        this.projectIds.add(projectId);
    }
    public UUID getUuid() {
        return uuid;
    }
    public String getUsername() {
         return username; 
    }
    public String getFirstName() { 
        return firstName; 
    }
    public String getLastName() { 
        return lastName; 
    }
    public String getUserEmail() { 
        return userEmail; 
    }
    public String getPassword() { 
        return password; 
    }
    public boolean isUserTypeAdmin() { 
        return userType; 
    }
    public List<UUID> getProjectIds() { 
        return projectIds; 
    }
    
    public void setUuid(UUID uuid) {
        this.uuid = uuid; 
    }
    public void setUsername(String username) { 
        this.username = username; 
    }
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }
    public void setUserEmail(String userEmail) { 
        this.userEmail = userEmail; 
    }
    public void setPassword(String password) { 
        this.password = password; 
    }
    public void setUserType(boolean userType) { 
        this.userType = userType; 
    }
    public void setProjectIds(List<UUID> projectIds) { 
        this.projectIds = projectIds; 
    }
}
