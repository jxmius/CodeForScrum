import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;


public class ProjectManagementController {

    @FXML
    private ListView<String> todoList;
    @FXML
    private ListView<String> inProgressList;
    @FXML
    private ListView<String> doneList;

    @FXML
    private void initialize() {
        // Initialize the lists with example data
        todoList.getItems().addAll("- Design Logo", "- Ship Hardware", "- Create Calendar");
        inProgressList.getItems().addAll("- Coding Project");
        doneList.getItems().addAll("- Conference Call");
    }

    @FXML
    private void handleBack() {
        // Logic to go back to the dashboard
    }

    @FXML
    private void handleAddNewTask() {
        // Logic to add a new task
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
}