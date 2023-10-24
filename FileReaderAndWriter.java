import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileReaderAndWriter {
    
    public FileReaderAndWriter() {
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            FileReader reader = new FileReader("src/user.json");
            JSONArray usersJSON = (JSONArray) (new JSONParser()).parse(reader);

            for (Object obj : usersJSON) {
                JSONObject userJSON = (JSONObject) obj;
                
                UUID id = UUID.fromString((String) userJSON.get("id"));
                String firstName = (String) userJSON.get("firstName");
                String lastName = (String) userJSON.get("lastName");
                String username = (String) userJSON.get("username");
                String password = (String) userJSON.get("password");
                boolean userType = "Admin".equals((String) userJSON.get("usertype"));

                User user = new User(id, firstName, lastName, username, password, userType);
                users.add(user);
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Project> loadProjects() {
    ArrayList<Project> projects = new ArrayList<>();

    try {
        FileReader reader = new FileReader("src/project.json");
        JSONArray projectsJSON = (JSONArray) (new JSONParser()).parse(reader);

        for (Object obj : projectsJSON) {
            JSONObject projectJSON = (JSONObject) obj;

            String id = (String) projectJSON.get("id");
            String projectName = (String) projectJSON.get("projectName");
            String board = (String) projectJSON.get("board");
            String dateTime = (String) projectJSON.get("dateTime");
            
            ArrayList<Contributor> contributors = new ArrayList<>();
            JSONArray contributorsJSON = (JSONArray) projectJSON.get("contributors");
            for (Object contributorObj : contributorsJSON) {
                JSONObject contributorJSON = (JSONObject) contributorObj;
                String username = (String) contributorJSON.get("username");
                String firstName = (String) contributorJSON.get("firstName");
                String lastName = (String) contributorJSON.get("lastName");
                
                Contributor contributor = new Contributor(username, firstName, lastName);
                contributors.add(contributor);
            }
            Project project = new Project(id, projectName, board, dateTime);
            projects.add(project);
        }

        return projects;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

}
