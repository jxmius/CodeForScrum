import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class DataWriter {
    private static final String USER_FILE_PATH = "CodeForScrum/lib/users.json";
    private static final String TASKS_FILE_PATH = "CodeForScrum/lib/task.json";


    public static void saveUsers(List<User> users) throws IOException {
        JSONArray usersArray = new JSONArray();
        for (User user : users) {
            JSONObject userObject = new JSONObject();
            userObject.put("uuid", user.getUuid().toString());
            userObject.put("username", user.getUsername());
            userObject.put("firstName", user.getFirstName());
            userObject.put("lastName", user.getLastName());
            userObject.put("userEmail", user.getUserEmail());
            userObject.put("password", user.getPassword());
            userObject.put("userType", user.isUserTypeAdmin());
            
            JSONArray projectIdsArray = new JSONArray();
            for (UUID projectId : user.getProjectIds()) {
                projectIdsArray.add(projectId.toString());
            }
            userObject.put("projectIds", projectIdsArray);
            
            usersArray.add(userObject);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH))) {
            writer.write(usersArray.toJSONString());
        }
    }
    
    public static void saveTasks(List<Task> tasks) {
        JSONArray tasksArray = new JSONArray();
        for (Task task : tasks) {
            tasksArray.add(taskToJSONObject(task));
        }

        try (FileWriter file = new FileWriter(TASKS_FILE_PATH)) {
            file.write(tasksArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
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

   