import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class DataWriter {
    private static final String USER_FILE_PATH = "users.json";
    private static final String PROJECT_FILE_PATH = "projects.json";

    public static void saveUsers(ArrayList<User> users) {
        StringBuilder userJson = new StringBuilder();
        userJson.append("[");
        for (User user : users) {
            if (userJson.length() > 1) {
                userJson.append(",");
            }
            userJson.append("{");
            userJson.append("\"firstName\":\"").append(user.getFirstName()).append("\",");
            userJson.append("\"lastName\":\"").append(user.getLastName()).append("\",");
            userJson.append("\"username\":\"").append(user.getUsername()).append("\",");
            userJson.append("\"userEmail\":\"").append(user.getUsername()).append("\",");
            userJson.append("\"password\":\"").append(user.getPassword()).append("\"");
            userJson.append("}");
        }
        userJson.append("]");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH))) {
            writer.write(userJson.toString());
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveProjects(ArrayList<Project> projects) {
        StringBuilder projectJson = new StringBuilder();
        projectJson.append("[");
        for (Project project : projects) {
            if (projectJson.length() > 1) {
                projectJson.append(",");
            }
            projectJson.append("{");
            projectJson.append("\"id\":\"").append(project.getId()).append("\",");
            projectJson.append("\"projectName\":\"").append(project.getProjectName()).append("\",");
            projectJson.append("\"board\":\"").append(project.getBoard()).append("\",");
            projectJson.append("\"dateTime\":\"").append(project.getDateTime()).append("\",");
            projectJson.append("\"comments\":[");

            // Add comments to the projectJson
            for (Comments comment : project.getComments()) {
                if (projectJson.charAt(projectJson.length() - 1) != '[') {
                    projectJson.append(",");
                }
                projectJson.append("{");
                projectJson.append("\"message\":\"").append(comment.getMessage()).append("\"");
                projectJson.append("}");
            }
            projectJson.append("],");

            projectJson.append("\"contributors\":[");

            // Add contributors to the projectJson
            for (Contributor contributor : project.getContributors()) {
                if (projectJson.charAt(projectJson.length() - 1) != '[') {
                    projectJson.append(",");
                }
                projectJson.append("{");
                projectJson.append("\"username\":\"").append(contributor.getUsername()).append("\",");
                projectJson.append("\"firstName\":\"").append(contributor.getFirstName()).append("\",");
                projectJson.append("\"lastName\":\"").append(contributor.getLastName()).append("\"");
                projectJson.append("}");
            }
            projectJson.append("]");
            projectJson.append("}");
        }
        projectJson.append("]");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROJECT_FILE_PATH))) {
            writer.write(projectJson.toString());
            System.out.println("Project data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
