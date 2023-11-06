import java.util.ArrayList;
import java.util.UUID;

public class Project {
    private UUID id;
    private String projectName;
    private Board board; 
    private String dateTime;
    private ArrayList<Comments> comments;
    private ArrayList<Contributor> contributors;

    public Project(UUID id, String projectName, Board board, String dateTime) {
        this.id = id;
        this.projectName = projectName;
        this.board = board; 
        this.dateTime = dateTime;
        this.comments = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public Board getBoard() {
        return board;
    }

    public String getDateTime() {
        return dateTime;
    }

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public void addComment(Comments comment) {
        this.comments.add(comment);
    }

    public void addContributor(Contributor contributor) {
        this.contributors.add(contributor);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setBoard(Board board) {
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

    public ArrayList<Contributor> getContributors() {
         return contributors;
    }
}