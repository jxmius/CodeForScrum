import java.io.FileReader;
import java.util.ArrayList;
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
                for (Object c : commentsJSON) {
                    JSONObject commentJSON = (JSONObject) c;
                    String text = (String) commentJSON.get("text");
                    String commentDateTime = (String) commentJSON.get("dateTime");
                    String user = (String) commentJSON.get("user");
                    Comment comment = new Comment(text, commentDateTime, user);
                    project.addComment(comment);//json array implementation as opposed to this

                    JSONArray nestedCommentsJSON = (JSONArray) commentJSON.get("comments");
                    for (Object nestedC : nestedCommentsJSON) {
                        JSONObject nestedCommentJSON = (JSONObject) nestedC;
                        String nestedText = (String) nestedCommentJSON.get("text");
                        String nestedDateTime = (String) nestedCommentJSON.get("dateTime");
                        String nestedUser = (String) nestedCommentJSON.get("user");
                        Comment nestedComment = new Comment(nestedText, nestedDateTime, nestedUser);
                        comment.addNestedComment(nestedComment);
                    } //json array implemantation populate the array
                }

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
}