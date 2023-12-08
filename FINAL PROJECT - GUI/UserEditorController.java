import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UserEditorController {

    @FXML private TextField emailField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField adminField;
    @FXML private TextField usernameField;

    @FXML
    private void handleBack() {
        // Logic to return to the previous screen
    }

    @FXML
    private void handleEditUser() {
        // Here you would have logic to validate and save the user details to the backend.
        // For example, updating user details in the database.
        String email = emailField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        boolean isAdmin = Boolean.parseBoolean(adminField.getText());
        String username = usernameField.getText();
        
        // Update user logic goes here
    }
}