public class ColumnsTest {

    public static void main(String[] args) {
        Columns columns = new Columns("ToDo");

        // Test adding tasks
        Task task1 = new Task("Task 1", "2023-10-28", "10:00 AM", "Complete the assignment", null, "task1-link", null, "Type A");
        Task task2 = new Task("Task 2", "2023-10-29", "11:00 AM", "Review the code", null, "task2-link", null, "Type B");
        columns.addTask(task1);
        columns.addTask(task2);

        // Check if tasks are added
        assert columns.getTasks().contains(task1) : "Task 1 should be added to the column";
        assert columns.getTasks().contains(task2) : "Task 2 should be added to the column";

        // Test removing tasks
        boolean isTask1Removed = columns.removeTask(task1);

        // Check if tasks are removed
        assert isTask1Removed : "Task 1 should be removable from the column";
        assert !columns.getTasks().contains(task1) : "Task 1 should no longer be in the column";

        // Test editing tasks
        Task task3 = new Task("Task 3", "2023-10-30", "12:00 PM", "Write unit tests", null, "task3-link", null, "Type C");
        columns.editTask(0, task3); // Assuming task2 is now at index 0 after removing task1

        // Check if tasks are edited
        assert columns.getTasks().get(0).equals(task3) : "Task at index 0 should be updated to Task 3";

        // Test display method (optional)
        columns.displayColumn();

        System.out.println("All tests passed.");
    }
}