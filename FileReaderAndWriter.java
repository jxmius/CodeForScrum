import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    public DataLoader() {
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
                String userEmail = (String) userJSON.get("userEmail");
                int points = Integer.parseInt(String.valueOf(userJSON.get("points"))); 

                boolean userType = "Admin".equalsIgnoreCase((String) userJSON.get("usertype"));

                ArrayList<String> projectNames = new ArrayList<>();
                JSONArray projectsJSON = (JSONArray) userJSON.get("projects");
                for (Object projectNameObj : projectsJSON) {
                    projectNames.add((String) projectNameObj);
                }

                User user = new User(id, firstName, lastName, username, password, userType, userEmail, points, projectNames);
                users.add(user);
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
