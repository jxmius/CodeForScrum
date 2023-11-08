import java.util.ArrayList;
import java.util.List;

public class TaskDriver {
    public static void main(String[] args) {
        // Create a list of links
        List<String> links = new ArrayList<>();
        links.add("Link 1");
        links.add("Link 2");

        // Create a contributor
        Contributor contributor = new Contributor("JohnD", "John", "Doe");

        // Create a task
        Task task = new Task("Task 1", "2023-10-30", "09:00 AM", "Sample task description", links, "Type A", contributor, "2023-11-15");

        // Add comments to the task
        Comments comment1 = new Comments("JohnD", "Adding this to the task", "2023-10-30 09:00 AM");
        task.addComment(comment1);

        // Display task information
        System.out.println("Task Details:");
        System.out.println("Task Name: " + task.getTaskName());
        System.out.println("Date: " + task.getTaskDate());
        System.out.println("Time: " + task.getTaskTime());
        System.out.println("Description: " + task.getTaskDescription());
        System.out.println("Links: " + task.getLinks());
        System.out.println("Type: " + task.getTaskType());
        System.out.println("Assigned User: " + task.getAssignedUser().getUsername());
        System.out.println("Due Date: " + task.getDueDate());

        // Display comments
        System.out.println("\nComments:");
        for (Comments comment : task.getComments()) {
            System.out.println(comment.getText());
        }
    }
}

