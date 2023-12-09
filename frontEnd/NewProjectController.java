import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewProjectController {

    @FXML
    private TextField projectNameField;
    @FXML
    private TextField teamMembersField;
    @FXML
    private TextField todoColumnField;
    @FXML
    private TextField inProgressColumnField;
    @FXML
    private TextField doneColumnField;

    @FXML
    private void handleBack() {
        // Logic to go back to the previous screen
    }

    @FXML
    private void handleAddColumn() {
        // Logic to add a new column to the list of project columns
    }

    @FXML
    private void handleCreateProject() {
        // Logic to create a new project with the specified details
    }
}