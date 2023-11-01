import java.util.ArrayList;
import java.util.List;

public class ProjectList {
    private static ProjectList instance;
    private List<Project> myProjects;

    private ProjectList() {
        myProjects = new ArrayList<>();
    }

    public static ProjectList getInstance() {
        if (instance == null) {
            instance = new ProjectList();
        }
        return instance;
    }

    public void addProject(Project project) {
        myProjects.add(project);
    }

    public Project getProject(String keyword) {
        for (Project project : myProjects) {
            if (project.getKeyword().equals(keyword)) {
                return project;
            }
        }
        return null; // Project not found
    }
}
