import java.util.ArrayList;
import java.util.UUID;

public class Project {
    private UUID id;
    private String projectName;
    private Board board;
    private String projectDate;
    private String projectTime;
    private ArrayList<Comments> comments;
    private ArrayList<Contributor> contributors;
    private ArrayList<Columns> columnsList;

    public Project(UUID id, String projectName, Board board, String projectDate, String projectTime) {
        this.id = id;
        this.projectName = projectName;
        this.board = board;
        this.projectDate = projectDate;
        this.projectTime = projectTime;
        this.comments = new ArrayList<>();
        this.contributors = new ArrayList<>();
        this.columnsList = new ArrayList<>();
    }

    public void setDateTime(String date, String time) {
        this.projectDate = date;
        this.projectTime = time;
    }

    public String getDateTime() {
        return projectDate + " " + projectTime;
    }

    public void displayProjectName() {
        System.out.println("Project Name: " + projectName);
    }

    public void editProjectDescription(String newDescription) {
        // Implement logic to edit the project description
    }

    public String displayProject() {
        StringBuilder projectDetails = new StringBuilder();
        projectDetails.append("Project Name: ").append(projectName).append("\n");
        projectDetails.append("Project Date and Time: ").append(getDateTime()).append("\n");
        projectDetails.append("Board: ").append(board.getBoardName()).append("\n");

        projectDetails.append("Comments:\n");
        for (Comments comment : comments) {
            projectDetails.append("- ").append(comment.getMessage()).append("\n");
        }

        projectDetails.append("Contributors:\n");
        for (Contributor contributor : contributors) {
            projectDetails.append("- ").append(contributor.getFullName()).append("\n");
        }

        // Add columns and tasks
        for (Columns columns : columnsList) {
            projectDetails.append("Column: ").append(columns.getColumnName()).append("\n");
            projectDetails.append("Tasks:\n");
            for (String task : columns.getTaskArray()) {
                projectDetails.append("- ").append(task).append("\n");
            }
        }

        return projectDetails.toString();
    }

    public String displayProjectDate() {
        return projectDate;
    }

    public void callBoard() {
        // Implement logic to interact with the board
    }

    public boolean checkContributor(Contributor contributor) {
        return contributors.contains(contributor);
    }

    public void addComment(Comments comment) {
        comments.add(comment);
    }

    public void removeComment(Comments comment) {
        comments.remove(comment);
    }

    public void addContributor(Contributor contributor) {
        contributors.add(contributor);
    }

    public void removeContributor(Contributor contributor) {
        contributors.remove(contributor);
    }

    public void addTask(Columns columns, String task) {
        columns.addTasks(task);
    }
}

