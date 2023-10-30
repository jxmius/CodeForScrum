import java.util.ArrayList;

public class Project {
    private String id;
    private String projectName;
    private String board;
    private String dateTime;
    private ArrayList<Comments> comments;
    private ArrayList<Contributor> contributors;

    public Project(String id, String projectName, String board, String dateTime) {
        this.id = id;
        this.projectName = projectName;
        this.board = board;
        this.dateTime = dateTime;
        this.comments = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }


    public String getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getBoard() {
        return board;
    }

    public String getDateTime() {
        return dateTime;
    }

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public ArrayList<Contributor> getContributors() {
        return contributors;
    }
}


