import java.util.ArrayList;

public class ProjectList {
    private ArrayList<Project> myProjects;

    // Private constructor to enforce singleton pattern
    private ProjectList() {
        myProjects = new ArrayList<>();
    }

    // Singleton instance
    private static ProjectList instance = new ProjectList();

    public static ProjectList getInstance() {
        return instance;
    }

    public void addProject(Project project) {
        myProjects.add(project);
    }

    public Project getProject(String keyWord) {
        for (Project project : myProjects) {
            if (project.getProjectName().contains(keyWord)) {
                return project;
            }
        }
        return null; // Project not found
    }

    public ArrayList<Project> getMyProjects() {
        return myProjects;
    }

}

