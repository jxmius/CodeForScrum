import java.util.ArrayList;
import java.util.UUID;

public class Project {
    private UUID id;
    private String projectName;
    private Board board;
    private String projectDate;
    private String projectTime;
    private ArrayList<String> comments;
    private ArrayList<String> contributorList;
    private String projectDescription;

    public Project(UUID id, String projectName) {
        this.id = id;
        this.projectName = projectName;
        this.comments = new ArrayList<>();
        this.contributorList = new ArrayList<>();
        this.projectDescription = "";
    }

    public void setDateTime(String date, String time) {
        this.projectDate = date;
        this.projectTime = time;
    }

    public String getDateTime() {
        return projectDate + " " + projectTime;
    }

    public void displayProjectName(String name) {
        System.out.println("Project Name: " + name);
    }

    public void editProjectDescription(String newDescription) {
        this.projectDescription = newDescription;
    }

    public String displayProject() {
        return "Project ID: " + id +
                "\nProject Name: " + projectName +
                "\nProject Date: " + projectDate +
                "\nProject Time: " + projectTime +
                "\nProject Description: " + projectDescription;
    }

    public String displayProjectDate() {
        return "Project Date: " + projectDate;
    }

    public void callBoard() {
        // Implementation for calling the associated board
    }

    public void checkContributor() {
        // Implementation for checking contributors
    }

    public void addComment(String message) {
        comments.add(message);
    }

    public void removeComment(String message) {
        comments.remove(message);
    }

    public void editComment(String oldMessage, String newMessage) {
        int index = comments.indexOf(oldMessage);
        if (index != -1) {
            comments.set(index, newMessage);
        }
    }

    public void addContributor(String contributor) {
        contributorList.add(contributor);
    }

    public void deleteContributor(String contributor) {
        contributorList.remove(contributor);
    }
}
