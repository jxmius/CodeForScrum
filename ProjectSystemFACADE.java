import java.io.IOException;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ProjectSystemFACADE {

    private static ProjectSystemFACADE instance;
    private UserList userList;

    public boolean validateLogin(String username, String password) {
        User user = userList.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Login successful
        }
        return false; // Login failed
    }
    private ProjectSystemFACADE() {
    }

    public static ProjectSystemFACADE getInstance() {
        if (instance == null) {
            try {
                instance = new ProjectSystemFACADE();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return instance;
    }

    public List<Project> getAllProjects() {
        try {
            return ProjectList.getInstance().getAllProjects();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addProject(Project project) {
        try {
            ProjectList.getInstance().addProject(project);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void removeProject(UUID projectId) {
        try {
            ProjectList.getInstance().removeProject(projectId);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            return UserList.getInstance().getUsers();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addUser(User user) {
        try {
            UserList.getInstance().addUser(user);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(UUID userId) {
        try {
            UserList.getInstance().deleteUser(userId);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveAll() {
        try {
            DataWriter.saveProjects(ProjectList.getInstance().getAllProjects());
            DataWriter.saveUsers(UserList.getInstance().getUsers());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void deleteProject(UUID projectId) {
        try {
            ProjectList.getInstance().removeProject(projectId);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void updateProject(UUID projectId, Project updatedProject) throws IOException {
        List<Project> projects = getAllProjects();

        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(projectId)) {
                projects.set(i, updatedProject);
                saveProjects(); 
                return;
            }
        }

        throw new IllegalArgumentException("Project not found with ID: " + projectId);
    }
    public void saveProjects() {
        try {
            List<Project> projects = ProjectList.getInstance().getAllProjects();
            DataWriter.saveProjects(projects); 
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public List<Task> getTasksForProject(String projectName) {
        List<Project> projects;
        try {
            projects = DataLoader.loadProjects();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        for (Project project : projects) {
            if (project.getProjectName().equals(projectName)) {
                List<Task> tasks = new ArrayList<>();
                for (Columns column : project.getBoard().getColumnsMap().values()) {
                    tasks.addAll(column.getTasks());
                }
                return tasks;
            }
        }
        return new ArrayList<>();
    }

}
