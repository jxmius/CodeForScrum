import java.util.ArrayList;

public class Comment {
    private String text;
    private String dateTime;
    private String user;
    private List<Comment> comments;

    public Comment(String text, String dateTime, String user, List<Comment> comments) {
        this.text = text;
        this.dateTime = dateTime;
        this.user = user;
        this.comments = comments;
    }


    public void comment(String comment, Contributor contributor) {
        String fullComment = contributor.getUsername() + ": " + comment;
        comments.add(fullComment);
    }

    public void addComments(String comment) {
        comments.add(comment);
    }
}