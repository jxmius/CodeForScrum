import java.util.ArrayList;

public class Comments {
    private String username; 
    private String message;
    private ArrayList<String> commentsArray;

    public Comments(String username) {
        this.username = username;
        this.commentsArray = new ArrayList<>();
    }

    public void comment(String comment, Contributor contributor) {
        this.commentsArray.add(contributor.getFullName() + ": " + comment);
    }

    public void addComments() {
        this.commentsArray.add(username + ": " + message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<String> getCommentsArray() {
        return commentsArray;
    }
}
