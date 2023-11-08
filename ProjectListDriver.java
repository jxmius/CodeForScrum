import java.io.IOException;
import java.util.UUID;
import org.json.simple.parser.ParseException;

public class ProjectListDriver {

    public static void main(String[] args) throws IOException, ParseException {
        // Initialize the ProjectList
        ProjectList projectList = ProjectList.getInstance();

        // Create a new project
        UUID projectId = UUID.randomUUID();
        Project project = new Project(projectId, "Sample Project", new Board("Sample Board"), "2023-10-26 12:00:00");

        // Add the project to the list
        projectList.addProject(project);

        // Retrieve a project by ID
        Project retrievedProject = projectList.getProjectById(projectId);
        if (retrievedProject != null) {
            System.out.println("Retrieved Project: " + retrievedProject.getProjectName());
        } else {
            System.out.println("Project not found.");
        }

        // Remove the project
        projectList.removeProject(projectId);

        // Save the projects
        projectList.saveProjects();
    }
}
