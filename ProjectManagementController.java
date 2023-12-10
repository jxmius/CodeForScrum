import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.List;


public class ProjectManagementController {
    @FXML
    private Label titleLabel;
    @FXML
    private ListView<String> todoList;
    @FXML
    private ListView<String> inProgressList;
    @FXML
    private ListView<String> doneList;
    private String projectName; 


    @FXML
    private void initialize() {
        // Assuming projectName is already set before initialize is called
        titleLabel.setText(projectName);

        // Load project-specific tasks
        loadProjectTasks(projectName);
    }
    public void setProjectName(String projectName) {
        titleLabel.setText(projectName);
    }
    @FXML
    private void handleBack() {
        // Logic to go back to the dashboard
    }

    @FXML
    private void handleUserOptions() {
        // Logic for user options or settings
    }

    @FXML
    private void handleAddNewTask() {
        try {
            Stage stage = (Stage) todoList.getScene().getWindow(); // Use any list reference here
            Parent root = FXMLLoader.load(getClass().getResource("/add_task.fxml"));
            
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        private void loadProjectTasks(String projectName) {
        // Clear existing items
        todoList.getItems().clear();
        inProgressList.getItems().clear();
        doneList.getItems().clear();

        // Fetch tasks for this project from the facade
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        List<Task> tasks = facade.getTasksForProject(projectName); // This method should be implemented in the facade

        for (Task task : tasks) {
            switch (task.getStatus()) { // Assuming Task has a getStatus() method
                case TODO:
                    todoList.getItems().add(task.getName());
                    break;
                case IN_PROGRESS:
                    inProgressList.getItems().add(task.getName());
                    break;
                case DONE:
                    doneList.getItems().add(task.getName());
                    break;
            }
        }
    }
}