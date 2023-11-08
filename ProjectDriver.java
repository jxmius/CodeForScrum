import java.util.UUID;

public class ProjectDriver {
    public static void main(String[] args) {
        // Create a new Board for the project
        Board board = new Board("Task Board");

        // Create a new Project
        UUID projectId = UUID.randomUUID();
        Project project = new Project(projectId, "Sample Project", board, "2023-10-26 15:30:00");

        // Add comments and contributors
        Comments comment1 = new Comments("Comment 1", "Hello", "2023-10-26 15:30:00");
        Comments comment2 = new Comments("Comment 2", "Goodbye", "2023-10-26 15:30:00");
        Contributor contributor1 = new Contributor("JohnD", "John", "Doe");
        Contributor contributor2 = new Contributor("AliceD", "Alice", "Doe");

        project.addComment(comment1);
        project.addComment(comment2);
        project.addContributor(contributor1);
        project.addContributor(contributor2);

        // Display project details
        System.out.println("Project Details:");
        System.out.println("Project ID: " + project.getId());
        System.out.println("Project Name: " + project.getProjectName());
        System.out.println("Board Name: " + project.getBoard().getBoardName());
        System.out.println("Date and Time: " + project.getDateTime());

        System.out.println("\nComments:");
        for (Comments comment : project.getComments()) {
            System.out.println(comment.getText());
        }

        System.out.println("\nContributors:");
        for (Contributor contributor : project.getContributors()) {
            System.out.println(contributor.getUsername());
        }
    }
}
