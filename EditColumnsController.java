
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EditColumnsController {

    @FXML
    private ListView<String> columnListView;
    @FXML
    private TextField newColumnNameField;
    @FXML
    private TextField addUsersField;

    @FXML
    public void initialize() {
        columnListView.getItems().addAll("To do", "In Progress", "Done");
        // Add any additional initialization here
    }

    @FXML
    private void handleAddColumn() {
        String newColumn = newColumnNameField.getText();
        if (newColumn != null && !newColumn.isEmpty()) {
            columnListView.getItems().add(newColumn);
            newColumnNameField.clear();
        }
        // Add logic to update this information in your data model or database
    }

    @FXML
    private void handleAddUser() {
        String username = addUsersField.getText();
        // Add logic to associate user with the project, potentially searching for the user first
    }
}