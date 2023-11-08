import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.simple.parser.ParseException;

public class ProjectList {
    private static ProjectList instance;
    private List<Project> projects;

    private ProjectList(List<Project> projects) {
        this.projects = projects;
    }

    public static synchronized ProjectList getInstance() throws IOException, ParseException {
        if (instance == null) {
            instance = new ProjectList(DataLoader.loadProjects());
        }
        return instance;
    }

    public Project getProjectById(UUID projectId) {
        return projects.stream()
                .filter(project -> project.getId().equals(projectId))
                .findFirst()
                .orElse(null);
    }

    public void addProject(Project project) throws IOException {
        if (getProjectById(project.getId()) == null) {
            projects.add(project);
            DataWriter.saveProjects(projects);  // Needs (re) implementation
        } else {
            throw new IllegalArgumentException("Project already exists with the ID: " + project.getId());
        }
    }

    public void removeProject(UUID projectId) throws IOException {
        Project project = getProjectById(projectId);
        if (project != null) {
            projects.remove(project);
            DataWriter.saveProjects(projects);  // Needs (re) implementation
        } else {
            throw new IllegalArgumentException("Project not found with ID: " + projectId);
        }
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects);
    }


    public void saveProjects() throws IOException {
        DataWriter.saveProjects(projects);  // Needs implementation
    }
}
