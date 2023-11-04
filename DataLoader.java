import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.List;

public class DataLoader {
    private static final String DATA_FILE_PATH = "data.txt";
    private static final String TASKS_FILE_PATH = "CodeForScrum/lib/task.json";

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = parseUser(line);
                if (user != null) {
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static User parseUser(String userData) {
        String[] parts = userData.split(",");
        if (parts.length == 7) {
            UUID uuid = UUID.fromString(parts[0]);
            String firstName = parts[1];
            String lastName = parts[2];
            String username = parts[3];
            String userEmail = parts[4];
            boolean userType = Boolean.parseBoolean(parts[6]);
            User user = new User(uuid, firstName, lastName, username, userEmail);
            user.setUserType(userType);
            return user;
        }
        return null;
    }

    private static String formatUser(User user) {
        return user.getUuid() + "," + user.getFirstName() + "," + user.getLastName() + ","
                + user.getUsername() + "," + "," + user.getPassword() + ","
                + user.isUserTypeAdmin();
    }

    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(TASKS_FILE_PATH)) {
            JSONArray tasksArray = (JSONArray) parser.parse(reader);

            for (Object taskObj : tasksArray) {
                JSONObject taskJSON = (JSONObject) taskObj;
                Task task = parseTask(taskJSON);
                tasks.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }

    private static Task parseTask(JSONObject taskJSON) {
        String taskName = (String) taskJSON.get("taskName");
        String taskDate = (String) taskJSON.get("taskDate");
        String taskTime = (String) taskJSON.get("taskTime");
        String taskDescription = (String) taskJSON.get("taskDescription");
        List<String> links = (List<String>) taskJSON.getOrDefault("links", new JSONArray());
        String taskType = (String) taskJSON.get("taskType");
        JSONObject assignedUserJSON = (JSONObject) taskJSON.get("assignedUser");
        Contributor assignedUser = parseContributor(assignedUserJSON);
        String dueDate = (String) taskJSON.get("dueDate");
        return new Task(taskName, taskDate, taskTime, taskDescription, links, taskType, assignedUser, dueDate);
    }

    private static Contributor parseContributor(JSONObject contributorJSON) {
        String username = (String) contributorJSON.get("username");
        String firstName = (String) contributorJSON.get("firstName");
        String lastName = (String) contributorJSON.get("lastName");
        return new Contributor(username, firstName, lastName);
    }

}
