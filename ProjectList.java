import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProjectList {
    private static final String PROJECTS_JSON_FILE_PATH = "projects.json";
    private static ProjectList instance;
    private List<Project> myProjects;

    private ProjectList() {
        myProjects = new ArrayList<>();
        loadProjectsFromJson();
    }

    public static ProjectList getInstance() {
        if (instance == null) {
            instance = new ProjectList();
        }
        return instance;
    }

    public void addProject(Project project) {
        myProjects.add(project);
    }

    public List<Project> getAllProjects() {
        return myProjects;
    }

    public Project getProjectById(UUID projectId) {
        return myProjects.stream()
                .filter(project -> project.getId().equals(projectId))
                .findFirst()
                .orElse(null);
    }

    private void loadProjectsFromJson() {
        JSONParser parser = new JSONParser();
        try (BufferedReader reader = new BufferedReader(new FileReader(PROJECTS_JSON_FILE_PATH))) {
            JSONArray projectsArray = (JSONArray) parser.parse(reader);
            for (Object projectObj : projectsArray) {
                JSONObject projectJSON = (JSONObject) projectObj;
                Project project = parseProject(projectJSON);
                if (project != null) {
                    myProjects.add(project);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
        private Project parseProject(JSONObject projectJSON) {
        UUID id = UUID.fromString((String) projectJSON.get("id"));
        String projectName = (String) projectJSON.get("projectName");
        String dateTime = (String) projectJSON.get("dateTime");

        Board board = parseBoard((JSONObject) projectJSON.get("board"));
        ArrayList<Comments> comments = parseComments((JSONArray) projectJSON.get("comments"));
        ArrayList<Contributor> contributors = parseContributors((JSONArray) projectJSON.get("contributors"));

        Project project = new Project(id, projectName, board, dateTime);
        project.setComments(comments);
        project.setContributors(contributors);

        return project;
    }

    private Board parseBoard(JSONObject boardJSON) {
        String boardName = (String) boardJSON.get("boardName");
        Board board = new Board(boardName);

        JSONObject columnsMap = (JSONObject) boardJSON.get("columnsMap");
        for (Object columnName : columnsMap.keySet()) {
            Columns column = parseColumn((JSONObject) columnsMap.get(columnName));
            board.setColumn(column.getColumnName(), column);
        }

        return board;
    }

    private Columns parseColumn(JSONObject columnJSON) {
        String columnName = (String) columnJSON.get("columnName");
        JSONArray tasksJSON = (JSONArray) columnJSON.get("tasks");

        Columns column = new Columns(columnName);
        for (Object taskObj : tasksJSON) {
            Task task = parseTask((JSONObject) taskObj);
            column.addTask(task);
        }

        return column;
    }

    private Task parseTask(JSONObject taskJSON) {
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

    private List<TaskHistory> parseTaskHistory(JSONArray taskHistoryJSON) {
        List<TaskHistory> taskHistory = new ArrayList<>();
        for (Object historyObj : taskHistoryJSON) {
            JSONObject historyJSON = (JSONObject) historyObj;
            String actionDate = (String) historyJSON.get("actionDate");
            String actionTime = (String) historyJSON.get("actionTime");
            String actionDescription = (String) historyJSON.get("actionDescription");

            TaskHistory history = new TaskHistory(actionDate, actionTime, actionDescription);
            taskHistory.add(history);
        }
        return taskHistory;
    }

    private Contributor parseContributor(JSONObject userJSON) {
        String username = (String) userJSON.get("username");
        String firstName = (String) userJSON.get("firstName");
        String lastName = (String) userJSON.get("lastName");

        return new Contributor(username, firstName, lastName);
    }

    private ArrayList<Comments> parseComments(JSONArray commentsJSON) {
        ArrayList<Comments> comments = new ArrayList<>();
        for (Object commentObj : commentsJSON) {
            JSONObject commentJSON = (JSONObject) commentObj;
            String text = (String) commentJSON.get("text");
            String dateTime = (String) commentJSON.get("dateTime");
            String user = (String) commentJSON.get("user");

            comments.add(new Comments(user, text, dateTime));
        }
        return comments;
    }

    private ArrayList<Contributor> parseContributors(JSONArray contributorsJSON) {
        ArrayList<Contributor> contributors = new ArrayList<>();
        for (Object contributorObj : contributorsJSON) {
            Contributor contributor = parseContributor((JSONObject) contributorObj);
            contributors.add(contributor);
        }
        return contributors;
    }
}
