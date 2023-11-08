import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class DataWriter {
    private static final String USER_FILE_PATH = "CodeForScrum/lib/users.json";
    private static final String TASKS_FILE_PATH = "CodeForScrum/lib/task.json";
    private static final String PROJECTS_FILE_PATH = "CodeForScrum/lib/projects.json"; // Add the correct path for your projects file

//user side of stuff
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
//project side of stuff

    public static void saveProjects(List<Project> projects) throws IOException {
        JSONArray projectsArray = new JSONArray();
        for (Project project : projects) {
            JSONObject projectObject = projectToJSONObject(project);
            projectsArray.add(projectObject);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROJECTS_FILE_PATH))) {
            writer.write(projectsArray.toJSONString());
        }
    }

    private static JSONObject projectToJSONObject(Project project) {
        JSONObject projectObject = new JSONObject();
        projectObject.put("id", project.getId().toString());
        projectObject.put("projectName", project.getProjectName());
        projectObject.put("dateTime", project.getDateTime());
        projectObject.put("board", boardToJSONObject(project.getBoard()));
        projectObject.put("comments", commentsToJSONArray(new ArrayList<>(project.getComments())));
        projectObject.put("contributors", contributorsToJSONArray(new ArrayList<>(project.getContributors())));

        return projectObject;
    }

    private static JSONObject boardToJSONObject(Board board) {
        JSONObject boardObject = new JSONObject();
        boardObject.put("boardName", board.getBoardName());
        boardObject.put("columnsMap", columnsMapToJSONObject(board.getColumnsMap()));
        return boardObject;
    }

    private static JSONObject columnsMapToJSONObject(Map<String, Columns> columnsMap) {
        JSONObject columnsMapObject = new JSONObject();
        for (Map.Entry<String, Columns> entry : columnsMap.entrySet()) {
            columnsMapObject.put(entry.getKey(), columnToJSONObject(entry.getValue()));
        }
        return columnsMapObject;
    }

    private static JSONObject columnToJSONObject(Columns column) {
        JSONObject columnObject = new JSONObject();
        columnObject.put("columnName", column.getColumnName());
        columnObject.put("tasks", tasksToJSONArray(column.getTasks()));
        return columnObject;
    }

    private static JSONArray tasksToJSONArray(List<Task> tasks) {
        JSONArray tasksArray = new JSONArray();
        for (Task task : tasks) {
            tasksArray.add(taskToJSONObject(task));
        }
        return tasksArray;
    }

    private static JSONArray contributorsToJSONArray(List<Contributor> contributors) {
        JSONArray contributorsArray = new JSONArray();
        for (Contributor contributor : contributors) {
            contributorsArray.add(contributorToJSONObject(contributor));
        }
        return contributorsArray;
    }

}

   