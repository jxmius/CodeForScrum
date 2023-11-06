import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

    public void addUser(User user) {
        userList.add(user);
        saveUsersToJson();
    }

    public User getUser(String username) {
        return userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }

 private void loadUsersFromJson() {
        JSONParser parser = new JSONParser();
        try (BufferedReader reader = new BufferedReader(new FileReader(JSON_FILE_PATH))) {
            JSONArray usersArray = (JSONArray) parser.parse(reader);
            for (Object userObj : usersArray) {
                JSONObject userJSON = (JSONObject) userObj;
                User user = parseUser(userJSON);
                if (user != null) {
                    userList.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveUsersToJson() {
        JSONArray usersArray = new JSONArray();
        for (User user : userList) {
            JSONObject userObject = new JSONObject();
            userObject.put("uuid", user.getUuid().toString());
            userObject.put("firstName", user.getFirstName());
            userObject.put("lastName", user.getLastName());
            userObject.put("username", user.getUsername());
            userObject.put("password", user.getPassword());
            userObject.put("userType", user.isUserTypeAdmin());
            JSONArray projectIdsArray = new JSONArray();
            for (UUID projectId : user.getProjectIds()) {
                projectIdsArray.add(projectId.toString());
            }
            userObject.put("projectIds", projectIdsArray);
            usersArray.add(userObject);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE_PATH))) {
            writer.write(usersArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User parseUser(JSONObject userJSON) {
        UUID uuid = UUID.fromString((String) userJSON.get("uuid"));
        String firstName = (String) userJSON.get("firstName");
        String lastName = (String) userJSON.get("lastName");
        String username = (String) userJSON.get("username");
        String password = (String) userJSON.get("password");
        boolean userType = (boolean) userJSON.get("userType");
        User user = new User(uuid, firstName, lastName, username, password);
        user.setUserType(userType);
        JSONArray projectIdsJSON = (JSONArray) userJSON.get("projectIds");
        List<UUID> projectIds = new ArrayList<>();
        for (Object projectIdObj : projectIdsJSON) {
            UUID projectId = UUID.fromString((String) projectIdObj);
            projectIds.add(projectId);
        }
        user.setProjectIds(projectIds);
        return user;
    }
}
