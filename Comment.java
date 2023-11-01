import java.util.ArrayList;

<<<<<<< HEAD:Comment.java
public class Comment {
    private String username;
=======
public class Comments {
    private String username; 
    private String message;
>>>>>>> b499abf9ad43f251c8eef5c0b09853a80ef4be08:Comments.java
    private ArrayList<String> commentsArray;

    public Comment(String username) {
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

<<<<<<< HEAD:Comment.java
    public static void main(String[] args) {
        Contributor contributor = new Contributor("Alice", "Alice", "Smith");
        Comment comments = new Comment("Bob");

        comments.comment("This is a great idea!", contributor);
        comments.comment("I agree with Alice.", contributor);
        comments.addComment("Thanks for the input!");

        comments.displayComments();

        // Example of retrieving a comment message
        String message = comments.getMessage(0);
        System.out.println("Retrieved Comment: " + message);
=======
    public ArrayList<String> getCommentsArray() {
        return commentsArray;
>>>>>>> b499abf9ad43f251c8eef5c0b09853a80ef4be08:Comments.java
    }
}
