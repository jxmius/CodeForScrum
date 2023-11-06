import java.util.ArrayList;

public class Comments {
    private String user; 
    private String text;
    private String dateTime;
    private ArrayList<Comments> comments; 

    public Comments(String user, String text, String dateTime) {
        this.user = user;
        this.text = text;
        this.dateTime = dateTime;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comments comment) {
        this.comments.add(comment);
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public String getDateTime() {
        return dateTime;
    }

    public ArrayList<Comments> getComments() {
        return comments;
    }
}
