import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {
    private String projectFilePath;
    private String userFilePath;

    public DataLoader(String projectFilePath, String userFilePath) {
        this.projectFilePath = projectFilePath;
        this.userFilePath = userFilePath;
    }

    public ArrayList<Project> getProjects() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(projectFilePath))){
            return (ArrayList<Project>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(userFilePath))) {
            return (ArrayList<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
