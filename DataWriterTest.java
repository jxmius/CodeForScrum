mport java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataWriterTest {

    public static void main(String[] args) {
        testSaveUsers();
        testSaveTasks();
        testSaveProjects();
    }

    private static void testSaveUsers() {
        try {
            // Setup dummy data
            User user = new User(UUID.randomUUID(), "john_doe", "John", "Doe", "john@example.com", "password123", true, Collections.emptyList());
            DataWriter.saveUsers(Collections.singletonList(user));

            // Read the file
            String content = new String(Files.readAllBytes(Paths.get(DataWriter.USER_FILE_PATH)));
            // You should verify the content matches the JSON structure expected
            System.out.println("User JSON: " + content);

            // Use a JSON parser to parse the content
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(content);
            JSONArray jsonArray = (JSONArray) obj;
            JSONObject savedUserObject = (JSONObject) jsonArray.get(0);

            // Assert that the saved user JSON object contains the correct data
            assert savedUserObject.get("username").equals(user.getUsername());
            assert savedUserObject.get("firstName").equals(user.getFirstName());
            // Add other assertions as needed

            System.out.println("Save Users Test Passed");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void testSaveTasks() {
        // Setup dummy data for tasks
        Task task1 = createSampleTask("Task 1", "2023-10-28", "10:00", "Complete the assignment");
        List<Task> tasks = Collections.singletonList(task1);

        // Save tasks to JSON
        saveTasksAndAssert(tasks, DataWriter.TASKS_FILE_PATH);
    }

    private static void testSaveProjects() {
        // Setup dummy data for projects
        Project project1 = createSampleProject("Project 1", "Board 1");
        List<Project> projects = Collections.singletonList(project1);

        // Save projects to JSON
        saveProjectsAndAssert(projects, DataWriter.PROJECTS_FILE_PATH);
    }

    private static Task createSampleTask(String name, String date, String time, String description) {
        return new Task(name, date, time, description, "http://link-to-task", "Type A", "2023-11-01", null, Collections.emptyList(), Collections.emptyList());
    }

    private static Project createSampleProject(String projectName, String boardName) {
        return new Project(UUID.randomUUID(), projectName, boardName, "2023-10-28 10:00", Collections.emptyList(), Collections.emptyList());
    }

    private static void saveTasksAndAssert(List<Task> tasks, String filePath) {
        try {
            DataWriter.saveTasks(tasks);
            JSONArray jsonArray = readJsonArrayFromFile(filePath);
            assert jsonArray.size() == tasks.size();

            // Perform assertions on the content of the JSON objects
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject taskObject = (JSONObject) jsonArray.get(i);
                Task task = tasks.get(i);
                assert taskObject.get("taskName").equals(task.getTaskName());
                // More assertions as needed
            }

            System.out.println("Save Tasks Test Passed");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void saveProjectsAndAssert(List<Project> projects, String filePath) {
        try {
            DataWriter.saveProjects(projects);
            JSONArray jsonArray = readJsonArrayFromFile(filePath);
            assert jsonArray.size() == projects.size();

            // Perform assertions on the content of the JSON objects
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject projectObject = (JSONObject) jsonArray.get(i);
                Project project = projects.get(i);
                assert projectObject.get("projectName").equals(project.getProjectName());
                // More assertions as needed
            }

            System.out.println("Save Projects Test Passed");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static JSONArray readJsonArrayFromFile(String filePath) throws IOException, ParseException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(content);
    }
}
