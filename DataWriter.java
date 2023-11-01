import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {

    // Method to save User data
    public void saveUsers(UserList userList) {
        try (FileWriter writer = new FileWriter(DataConstants.USERS_FILE_PATH)) {
            // Sample: Convert userList to a suitable format and write
            // More detailed logic based on how the UserList is structured
            writer.write(userList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save Project data
    public void saveProject(ProjectList projectList) {
        try (FileWriter writer = new FileWriter(DataConstants.PROJECTS_FILE_PATH)) {
            // Sample: Convert projectList to a suitable format and write
            // More detailed logic based on how the ProjectList is structured
            writer.write(projectList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}