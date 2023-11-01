import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileReaderAndWriter {

    private static final String PROJECTS_FILE_PATH = "src/project.json";

    public static ArrayList<Project> loadProjects() {
        ArrayList<Project> projects = new ArrayList<>();
        try {
            FileReader reader = new FileReader(PROJECTS_FILE_PATH);
            JSONObject obj = (JSONObject) new JSONParser().parse(reader);
            JSONArray projectsJSON = (JSONArray) obj.get("projects");

            for (Object o : projectsJSON) {
                JSONObject projectJSON = (JSONObject) o;
                String id = (String) projectJSON.get("id");
                String projectName = (String) projectJSON.get("projectName");
                String board = (String) projectJSON.get("board");
                String dateTime = (String) projectJSON.get("dateTime");
                Project project = new Project(id, projectName, board, dateTime);

                JSONArray commentsJSON = (JSONArray) projectJSON.get("comments");
                project.getComments().addAll(loadComments(commentsJSON));

                JSONArray contributorsJSON = (JSONArray) projectJSON.get("contributors");
                for (Object c : contributorsJSON) {
                    JSONObject contributorJSON = (JSONObject) c;
                    String username = (String) contributorJSON.get("username");
                    String firstName = (String) contributorJSON.get("firstName");
                    String lastName = (String) contributorJSON.get("lastName");
                    Contributor contributor = new Contributor(username, firstName, lastName);
                    project.getContributors(contributor);
                }

                projects.add(project);
            }
            return projects;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ArrayList<Comments> loadComments(JSONArray commentsJSON) {
        ArrayList<Comments> commentsList = new ArrayList<>();
        for (Object c : commentsJSON) {
            JSONObject commentJSON = (JSONObject) c;
            String text = (String) commentJSON.get("text");
            String user = (String) commentJSON.get("user");
            String commentDateTime = (String) commentJSON.get("dateTime");
            Comments comment = new Comments(user, text, commentDateTime);

            JSONArray nestedCommentsJSON = (JSONArray) commentJSON.get("comments");
            comment.getComments().addAll(loadComments(nestedCommentsJSON));
            
            commentsList.add(comment);
        }
        return commentsList;
    }
    
    public static void saveProjects(List<Project> projects) {
        JSONObject mainObject = new JSONObject();
        JSONArray projectList = new JSONArray();

        for (Project project : projects) {
            JSONObject projectObject = new JSONObject();
            projectObject.put("id", project.getId());
            projectObject.put("projectName", project.getProjectName());
            projectObject.put("board", project.getBoard());
            projectObject.put("dateTime", project.getDateTime());

            JSONArray contributors = new JSONArray();
            for (Contributor contributor : project.getContributors()) {
                JSONObject contributorObject = new JSONObject();
                contributorObject.put("username", contributor.getUsername());
                contributorObject.put("firstName", contributor.getFirstName());
                contributorObject.put("lastName", contributor.getLastName());
                contributors.add(contributorObject);
            }
            projectObject.put("contributors", contributors);

            JSONArray comments = saveComments(project.getComments());
            projectObject.put("comments", comments);

            projectList.add(projectObject);
        }
        mainObject.put("projects", projectList);

        try (FileWriter file = new FileWriter(PROJECTS_FILE_PATH)) {
            file.write(mainObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONArray saveComments(ArrayList<Comments> commentsList) {
        JSONArray commentsJSON = new JSONArray();
        for (Comments comment : commentsList) {
            JSONObject commentObject = new JSONObject();
            commentObject.put("user", comment.getUser());
            commentObject.put("text", comment.getText());
            commentObject.put("dateTime", comment.getDateTime());

            JSONArray nestedComments = saveComments(comment.getComments());
            commentObject.put("comments", nestedComments);

            commentsJSON.add(commentObject);
        }
        return commentsJSON;
    }
}
