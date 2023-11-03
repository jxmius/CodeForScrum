import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class DataWriter {
    private static final String USER_FILE_PATH = "users.json";

    public static void saveUsers(UserList userList) {
        StringBuilder userJson = new StringBuilder();
        userJson.append("[");
        for (User user : userList.users) {
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
}

   