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
        String fullComment = contributor.getUsername() + ": " + comment;
        commentsArray.add(fullComment);
    }

    public void addComments(String comment) {
        commentsArray.add(comment);
    }
}