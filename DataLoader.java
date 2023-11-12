import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DataLoader {
    private static final String USER_FILE_PATH = "lib/user.json";
    private static final String TASKS_FILE_PATH = "lib/tasks.json";
    private static final String PROJECTS_FILE_PATH = "lib/projects.json";

    public static List<User> loadUsers() throws IOException, ParseException {
        List<User> users = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(USER_FILE_PATH)) {
            JSONArray usersArray = (JSONArray) parser.parse(reader);
            for (Object userObj : usersArray) {
                JSONObject userJSON = (JSONObject) userObj;
                User user = parseUser(userJSON);
                users.add(user);
            }
        }
        return users;
    }

    public static List<Task> loadTasks() throws IOException, ParseException {
        List<Task> tasks = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(TASKS_FILE_PATH)) {
            JSONArray tasksArray = (JSONArray) parser.parse(reader);
            for (Object taskObj : tasksArray) {
                JSONObject taskJSON = (JSONObject) taskObj;
                Task task = parseTask(taskJSON);
                tasks.add(task);
            }
        }
        return tasks;
    }

    public static List<Project> loadProjects() throws IOException, ParseException {
        List<Project> projects = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(PROJECTS_FILE_PATH)) {
            JSONArray projectsArray = (JSONArray) parser.parse(reader);
            for (Object projectObj : projectsArray) {
                JSONObject projectJSON = (JSONObject) projectObj;
                Project project = parseProject(projectJSON);
                projects.add(project);
            }
        }
        return projects;
    }
   
    private static User parseUser(JSONObject userJSON) {
        UUID uuid = UUID.fromString((String) userJSON.get("uuid"));
        String firstName = (String) userJSON.get("firstName");
        String lastName = (String) userJSON.get("lastName");
        String username = (String) userJSON.get("username");
        String password = (String) userJSON.get("password"); 
        boolean userType = (boolean) userJSON.getOrDefault("userType", false);
        User user = new User(uuid, firstName, lastName, username, password, password, userType);
        user.setUserType(userType);
        return user;
    }

    private static Task parseTask(JSONObject taskJSON) {
        String taskName = (String) taskJSON.get("taskName");
        String taskDate = (String) taskJSON.get("taskDate");
        String taskTime = (String) taskJSON.get("taskTime");
        String taskDescription = (String) taskJSON.get("taskDescription");
        List<String> links = new ArrayList<>((JSONArray) taskJSON.get("links"));
        String taskType = (String) taskJSON.get("taskType");
        Contributor assignedUser = parseContributor((JSONObject) taskJSON.get("assignedUser"));
        String dueDate = (String) taskJSON.get("dueDate");
        List<Comments> comments = parseComments((JSONArray) taskJSON.get("comments"));
        List<TaskHistory> taskHistory = parseTaskHistory((JSONArray) taskJSON.get("taskHistory"));

        Task task = new Task(taskName, taskDate, taskTime, taskDescription, links, taskType, assignedUser, dueDate);
        task.setComments(comments);
        task.setTaskHistory(taskHistory);

        return task;
    }

    private static Contributor parseContributor(JSONObject contributorJSON) {
        String username = (String) contributorJSON.get("username");
        String firstName = (String) contributorJSON.get("firstName");
        String lastName = (String) contributorJSON.get("lastName");
        return new Contributor(username, firstName, lastName);
    }

    private static List<Comments> parseComments(JSONArray commentsJSON) {
        List<Comments> commentsList = new ArrayList<>();
        for (Object commentObj : commentsJSON) {
            JSONObject commentJSON = (JSONObject) commentObj;
            Comments comment = parseSingleComment(commentJSON);
            commentsList.add(comment);
        }
        return commentsList;
    }

    private static Comments parseSingleComment(JSONObject commentJSON) {
        String user = (String) commentJSON.get("user");
        String text = (String) commentJSON.get("text");
        String dateTime = (String) commentJSON.get("dateTime");
        Comments comment = new Comments(user, text, dateTime);
        JSONArray repliesJSON = (JSONArray) commentJSON.get("comments");
        if (repliesJSON != null) {
            for (Object replyObj : repliesJSON) {
                JSONObject replyJSON = (JSONObject) replyObj;
                Comments reply = parseSingleComment(replyJSON);
                comment.addComment(reply);
            }
        }
        return comment;
    }

    private static List<TaskHistory> parseTaskHistory(JSONArray taskHistoryJSON) {
        List<TaskHistory> taskHistoryList = new ArrayList<>();
        for (Object historyObj : taskHistoryJSON) {
            JSONObject historyJSON = (JSONObject) historyObj;
            String actionDate = (String) historyJSON.get("actionDate");
            String actionTime = (String) historyJSON.get("actionTime");
            String actionDescription = (String) historyJSON.get("actionDescription");
            taskHistoryList.add(new TaskHistory(actionDate, actionTime, actionDescription));
        }
        return taskHistoryList;
    }
    private static Project parseProject(JSONObject projectJSON) {
        UUID id = UUID.fromString((String) projectJSON.get("id"));
        String projectName = (String) projectJSON.get("projectName");
        String dateTime = (String) projectJSON.get("dateTime");
        
        Board board = parseBoard((JSONObject) projectJSON.get("board"));
        List<Comments> comments = parseComments((JSONArray) projectJSON.get("comments"));
        List<Contributor> contributors = parseContributors((JSONArray) projectJSON.get("contributors"));

        Project project = new Project(id, projectName, board, dateTime);
        project.setComments(new ArrayList<>(comments));
        project.setContributors(new ArrayList<>(contributors));

        return project;
    }
        private static Board parseBoard(JSONObject boardJSON) {
        String boardName = (String) boardJSON.get("boardName");
        Board board = new Board(boardName);
        
        JSONObject columnsMapJSON = (JSONObject) boardJSON.get("columnsMap");
        Map<String, Columns> columnsMap = new LinkedHashMap<>();
        for (Object key : columnsMapJSON.keySet()) {
            String columnName = (String) key;
            Columns column = parseColumn((JSONObject) columnsMapJSON.get(columnName));
            columnsMap.put(columnName, column);
        }
        
        board.setColumnsMap(columnsMap);
        return board;
    }

    private static Columns parseColumn(JSONObject columnJSON) {
        String columnName = (String) columnJSON.get("columnName");
        JSONArray tasksJSON = (JSONArray) columnJSON.get("tasks");
        
        Columns column = new Columns(columnName);
        for (Object taskObj : tasksJSON) {
            Task task = parseTask((JSONObject) taskObj);
            column.addTask(task);
        }
        
        return column;
    }

    private static List<Contributor> parseContributors(JSONArray contributorsJSON) {
        List<Contributor> contributors = new ArrayList<>();
        for (Object contributorObj : contributorsJSON) {
            JSONObject contributorJSON = (JSONObject) contributorObj;
            Contributor contributor = parseContributor(contributorJSON);
            contributors.add(contributor);
        }
        return contributors;
    }

}