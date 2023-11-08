public class BoardDriver {
    public static void main(String[] args) {
        // Create a new Board
        Board board = new Board("Project Board");

        // Add columns to the board
        board.addColumn("To Do");
        board.addColumn("In Progress");
        board.addColumn("Done");

        // Add tasks to columns
        Task task1 = new Task("Task 1", "2023-10-28", "10:00 AM", "Complete the assignment", null, "task1-link", null, "Type A");
        Task task2 = new Task("Task 2", "2023-10-29", "11:00 AM", "Review the code", null, "task2-link", null, "Type B");
        Task task3 = new Task("Task 3", "2023-10-30", "2:00 PM", "Test the application", null, "task3-link", null, "Type A");

        board.addTaskToColumn("To Do", task1);
        board.addTaskToColumn("In Progress", task2);
        board.addTaskToColumn("Done", task3);

        // Display the board
        board.displayBoard();

        // Move a task from one column to another
        board.moveTask("To Do", "In Progress", task1);

        // Display the updated board
        board.displayBoard();
    }
}

