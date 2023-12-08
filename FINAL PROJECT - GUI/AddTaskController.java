import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddTaskController {

    @FXML
    private ComboBox<String> columnChoice;
    @FXML
    private TextField taskNameField;
    @FXML
    private TextField taskDescriptionField;
    @FXML
    private DatePicker dueDateField;
    @FXML
    private TextField addUsersField;

    @FXML
    private void initialize() {
        // Initialize ComboBox with column choices, e.g., To Do, In Progress, Done
        columnChoice.getItems().addAll("To Do", "In Progress", "Done");
    }

    @FXML
    private void handleMakeTask() {
        // Logic to create a new task based on the fields
        System.out.println("Creating task: " + taskNameField.getText());
        // You would likely have a method here to add the task to the project management system.
    }
}