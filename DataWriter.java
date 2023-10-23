import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException;

public class DataWriter {
    private String userFilePath;
    private String projectFilePath;

    public DataWriter(String userFilePath, String projectFilePath) {
        this.userFilePath = userFilePath;
        this.projectFilePath = projectFilePath;
    }

    public void saveUsers(ArrayList<User> users) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(userFilePath))) {
            objectOutputStream.writeObject(users);
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveProjects(ArrayList<Project> projects) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(projectFilePath))) {
            objectOutputStream.writeObject(projects);
            System.out.println("Project data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
