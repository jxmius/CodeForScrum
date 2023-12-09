
import java.util.List;
import java.util.UUID;

public class ProjectSystemFacadeTester {

    public static void main(String[] args) {
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();

        // Test getting all projects
        System.out.println("Testing getAllProjects:");
        List<Project> projects = facade.getAllProjects();
        for (Project project : projects) {
            System.out.println("Project: " + project.getProjectName());
            // Add more details as needed
        }

        // Test adding a project
        System.out.println("\nTesting addProject:");
        Project newProject = new Project(UUID.randomUUID(), "New Project", new Board("New Board"), "2023-01-01");
        facade.addProject(newProject);
        System.out.println("Added new project: " + newProject.getProjectName());

        // Test removing a project
        System.out.println("\nTesting removeProject:");
        if (!projects.isEmpty()) {
            UUID projectIdToRemove = projects.get(0).getId();
            facade.removeProject(projectIdToRemove);
            System.out.println("Removed project with ID: " + projectIdToRemove);
        }

        // Test getting all users
        System.out.println("\nTesting getAllUsers:");
        List<User> users = facade.getAllUsers();
        for (User user : users) {
            System.out.println("User: " + user.getUsername());
            // Add more details as needed
        }

        // Add more tests for addUser, removeUser, saveAll, etc.

        // Finally, test saveAll
        System.out.println("\nTesting saveAll:");
        facade.saveAll();
        System.out.println("All data saved.");

        
    }
}
