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

    public void addComment(Comments comment) {
        this.comments.add(comment);
    }

    public void addContributor(Contributor contributor) {
        this.contributors.add(contributor);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }

    public void setContributors(ArrayList<Contributor> contributors) {
        this.contributors = contributors;
    }
}

