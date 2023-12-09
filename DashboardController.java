import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;

public class DashboardController {

    @FXML
    private ListView<String> projectsList;

    @FXML
    private void initialize() {
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        List<Project> projects = facade.getAllProjects();
        for (Project project : projects) {
            projectsList.getItems().add(project.getProjectName());
        }
    }
    @FXML
    private void handleBack() {
        // Logic to go back (e.g., to the login screen)
    }

    @FXML
    private void handleAddNewProject() {
        // Logic to add a new project
    }

    // Modify the DashboardController.java
    @FXML
    private void onProjectSelected() {
        projectsList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switchToProjectManagement(newValue);
            }
        });
    }

    private void switchToProjectManagement(String projectName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_management.fxml"));
            Stage stage = (Stage) projectsList.getScene().getWindow();
            Scene scene = new Scene(loader.load());

            ProjectManagementController controller = loader.getController();
            controller.setProjectName(projectName); // You'll need to implement this method in your controller
            
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}