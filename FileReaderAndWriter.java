import java.io.FileReader;
import java.io.FileWriter;
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
                    // Extract comment fields and add to project's comments list
                }

                JSONArray contributorsJSON = (JSONArray) projectJSON.get("contributors");
                for (Object c : contributorsJSON) {
                    // Extract contributor fields and add to project's contributors list
                }

                projects.add(project);
            }

            return projects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // saveProjects
}
