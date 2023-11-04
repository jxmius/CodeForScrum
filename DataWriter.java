import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class DataWriter {
    private static final String USER_FILE_PATH = "CodeForScrum/lib/users.json";
    private static final String TASKS_FILE_PATH = "CodeForScrum/lib/task.json";



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
        public static void saveTasks(List<Task> tasks) throws IOException {
        JSONArray tasksArray = new JSONArray();
        for (Task task : tasks) {
            JSONObject taskObject = taskToJSONObject(task);
            tasksArray.add(taskObject);
        }

        try (FileWriter file = new FileWriter(TASKS_FILE_PATH)) {
            file.write(tasksArray.toJSONString());
        }
    }

    private static JSONObject taskToJSONObject(Task task) {
        JSONObject taskObject = new JSONObject();
        taskObject.put("taskName", task.getTaskName());
        taskObject.put("taskDate", task.getTaskDate());
        taskObject.put("taskTime", task.getTaskTime());
        taskObject.put("taskDescription", task.getTaskDescription());
        taskObject.put("links", task.getLinks());
        taskObject.put("taskType", task.getTaskType());
        taskObject.put("dueDate", task.getDueDate());
        taskObject.put("assignedUser", contributorToJSONObject(task.getAssignedUser()));
        taskObject.put("comments", commentsToJSONArray(task.getComments()));
        taskObject.put("taskHistory", taskHistoryToJSONArray(task.getTaskHistory()));

        return taskObject;
    }

    private static JSONObject contributorToJSONObject(Contributor contributor) {
        JSONObject contributorObject = new JSONObject();
        contributorObject.put("username", contributor.getUsername());
        contributorObject.put("firstName", contributor.getFirstName());
        contributorObject.put("lastName", contributor.getLastName());
        return contributorObject;
    }

    private static JSONArray commentsToJSONArray(List<Comments> comments) {
        JSONArray commentsArray = new JSONArray();
        for (Comments comment : comments) {
            JSONObject commentObject = new JSONObject();
            commentObject.put("text", comment.getText());
            commentObject.put("dateTime", comment.getDateTime());
            commentObject.put("user", comment.getUser());
            commentsArray.add(commentObject);
        }
        return commentsArray;
    }

    private static JSONArray taskHistoryToJSONArray(List<TaskHistory> taskHistory) {
        JSONArray taskHistoryArray = new JSONArray();
        for (TaskHistory history : taskHistory) {
            JSONObject historyObject = new JSONObject();
            historyObject.put("actionDate", history.getActionDate());
            historyObject.put("actionTime", history.getActionTime());
            historyObject.put("actionDescription", history.getActionDescription());
            taskHistoryArray.add(historyObject);
        }
        return taskHistoryArray;
    }
}

   