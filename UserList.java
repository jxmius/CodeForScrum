import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserList {
    private static final String JSON_FILE_PATH = "users.json";
    private static UserList instance;
    private List<User> userList;

    private UserList() {
        userList = new ArrayList<>();
        loadUsersFromJson();
    }

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public void addUser(String firstName, String lastName, String userName, String userEmail, String password) {
        User user = new User(firstName, lastName, userName, userEmail, password);
        userList.add(user);
        saveUsersToJson();
    }

    public User getUser(String firstName, String lastName, String userName) {
        return userList.stream()
                .filter(user -> user.getFirstName().equals(firstName) &&
                        user.getLastName().equals(lastName) &&
                        user.getUsername().equals(userName))
                .findFirst()
                .orElse(null);
    }

    private void loadUsersFromJson() {
        try (BufferedReader reader = new BufferedReader(new FileReader(JSON_FILE_PATH)) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            userList = parseJson(jsonContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsersToJson() {
        String jsonContent = generateJson(userList);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE_PATH))) {
            writer.write(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateJson(List<User> userList) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (User user : userList) {
            if (json.length() > 1) {
                json.append(",");
            }
            json.append("{");
            json.append("\"firstName\":\"").append(user.getFirstName()).append("\",");
            json.append("\"lastName\":\"").append(user.getLastName()).append("\",");
            json.append("\"username\":\"").append(user.getUsername()).append("\",");
            json.append("\"userEmail\":\"").append(user.getUserEmail()).append("\",");
            json.append("\"password\":\"").append(user.getPassword()).append("\"");
            json.append("}");
        }
        json.append("]");
        return json.toString();
    }

    private List<User> parseJson(String json) {
        List<User> parsedUsers = new ArrayList<>();
        int index = 0;
        while (index < json.length()) {
            int start = json.indexOf("{", index);
            int end = json.indexOf("}", start);
            if (start != -1 && end != -1) {
                String userJson = json.substring(start, end + 1);
                String[] fields = userJson.split(",");
                String firstName = getField(fields, "firstName");
                String lastName = getField(fields, "lastName");
                String username = getField(fields, "username");
                String userEmail = getField(fields, "userEmail");
                String password = getField(fields, "password");
                User user = new User(firstName, lastName, username, userEmail, password);
                parsedUsers.add(user);
                index = end + 1;
            } else {
                break;
            }
        }
        return parsedUsers;
    }

    private String getField(String[] fields, String fieldName) {
        for (String field : fields) {
            String[] parts = field.split(":");
            if (parts[0].trim().equals("\"" + fieldName + "\"")) {
                return parts[1].trim().replace("\"", "");
            }
        }
        return null;
    }
}
