import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class DataLoaderTest {

    // You need to define these expected values based on the actual data you are testing against.
    private static final int expectedNumberOfUsers = 2; // Example expected number
    private static final int expectedNumberOfTasks = 3; // Example expected number
    private static final int expectedNumberOfProjects = 1; // Example expected number

    public static void main(String[] args) {
        testLoadUsers();
        testLoadTasks();
        testLoadProjects();
    }

    private static void testLoadUsers() {
        try {
            List<User> users = DataLoader.loadUsers();
            assert users != null : "Users list should not be null";
            assert users.size() == expectedNumberOfUsers : "Users list size should match expected value";

            for (User user : users) {
                // Replace these with actual expected values
                assert user.getUuid() instanceof UUID : "User UUID should be of UUID type";
                assert user.getUsername().equals("expectedUsername") : "User username should match expected value";
                assert user.getFirstName().equals("expectedFirstName") : "User first name should match expected value";
                assert user.getLastName().equals("expectedLastName") : "User last name should match expected value";
                assert user.getUserEmail().equals("expectedEmail") : "User email should match expected value";
                assert user.getPassword().equals("expectedPassword") : "User password should match expected value";
                assert user.isUserTypeAdmin() == expectedUserType : "User type should match expected value";
                // ... More assertions for other User fields
            }

            System.out.println("Load Users Test Passed");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            assert false : "Load Users Test Failed";
        }
    }

    private static void testLoadTasks() {
        try {
            List<Task> tasks = DataLoader.loadTasks();
            assert tasks != null : "Tasks list should not be null";
            assert tasks.size() == expectedNumberOfTasks : "Tasks list size should match expected value";

            for (Task task : tasks) {
                // Replace these with actual expected values
                assert task.getTaskName().equals("expectedTaskName") : "Task name should match expected value";
                assert task.getTaskDate().equals("expectedTaskDate") : "Task date should match expected value";
                assert task.getTaskTime().equals("expectedTaskTime") : "Task time should match expected value";
                assert task.getTaskDescription().equals("expectedDescription") : "Task description should match expected value";
                assert task.getLinks().equals(expectedLinksList) : "Task links should match expected value";
                assert task.getTaskType().equals("expectedTaskType") : "Task type should match expected value";
                assert task.getDueDate().equals("expectedDueDate") : "Task due date should match expected value";
                // ... More assertions for other Task fields
            }

            System.out.println("Load Tasks Test Passed");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            assert false : "Load Tasks Test Failed";
        }
    }

    private static void testLoadProjects() {
        try {
            List<Project> projects = DataLoader.loadProjects();
            assert projects != null : "Projects list should not be null";
            assert projects.size() == expectedNumberOfProjects : "Projects list size should match expected value";

            for (Project project : projects) {
                // Replace these with actual expected values
                assert project.getId().equals(UUID.fromString("expectedProjectId")) : "Project ID should match expected value";
                assert project.getProjectName().equals("expectedProjectName") : "Project name should match expected value";
                assert project.getDateTime().equals("expectedDateTime") : "Project date time should match expected value";
                // Assertions for Board
                assert project.getBoard() != null : "Project board should not be null";
                assert project.getBoard().getBoardName().equals("expectedBoardName") : "Board name should match expected value";
                // Assertions for Comments
                assert project.getComments().equals(expectedCommentsList) : "Project comments should match expected value";
                // Assertions for Contributors
                assert project.getContributors().equals(expectedContributorsList) : "Project contributors should match expected value";
                // ... More assertions for other Project fields
            }

            System.out.println("Load Projects Test Passed");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            assert false : "Load Projects Test Failed";
        }
    }
}