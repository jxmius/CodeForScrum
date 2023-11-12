import java.io.IOException;
import java.util.UUID;
import org.json.simple.parser.ParseException;
import java.util.List; 

public class ProjectListDriver {

    public static void main(String[] args) {
        try {
            // Initialize ProjectList instance
            ProjectList projectList = ProjectList.getInstance();

            // Create a new project
            UUID projectId = UUID.randomUUID();
            Project newProject = new Project(projectId, "Test Project", new Board("Test Board"), "2023-01-01");

            // Add new project to the list
            System.out.println("Adding a new project...");
            projectList.addProject(newProject);

            // Display all projects
            System.out.println("Current projects:");
            displayProjects(projectList.getAllProjects());

            // Remove project
            System.out.println("Removing project...");
            projectList.removeProject(projectId);

            // Display all projects after deletion
            System.out.println("Projects after deletion:");
            displayProjects(projectList.getAllProjects());

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void displayProjects(List<Project> projects) {
        for (Project project : projects) {
            System.out.println("Project: " + project.getProjectName() + ", Date: " + project.getDateTime());
        }
    }
}
