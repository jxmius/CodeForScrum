import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateAccountController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private void handleCreateAccount() {
        // Handle create account logic here
        System.out.println("Create account for user: " + usernameField.getText());
        // Add logic to save these details
    }
}
