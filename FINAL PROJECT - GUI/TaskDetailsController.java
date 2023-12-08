import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TaskDetailsController {

    @FXML private TextField taskNameField;
    @FXML private TextField taskTypeField;
    @FXML private ComboBox<String> userComboBox;
    @FXML private TextField descriptionField;
    @FXML private TextField addUserField;
    @FXML private DatePicker dueDateField;
    @FXML private TextField linksField;
    @FXML private TextArea commentsArea;
    @FXML private TextField newCommentField;

    @FXML
    private void initialize() {
        // You can initialize your fields here, depending on the task selected previously
    }

    @FXML
    private void handleBack() {
        // Logic to return to the previous screen (e.g., project management page)
    }

    @FXML
    private void handleAddComment() {
        // Logic to add a new comment to the task
        String newComment = newCommentField.getText();
        if (newComment != null && !newComment.isEmpty()) {
            commentsArea.appendText(newComment + "\n");
            newCommentField.clear();
        }
    }
}