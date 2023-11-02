import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DataLoader {
    private String projectFilePath;
    private String userFilePath;

    public DataLoader(String projectFilePath, String userFilePath) {
        this.projectFilePath = projectFilePath;
        this.userFilePath = userFilePath;
    }

    public <T> ArrayList<T> getData(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (ArrayList<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public ArrayList<Project> getProjects() {
        return getData(projectFilePath);
    }

    public ArrayList<User> getUsers() {
        return getData(userFilePath);
    }
}
