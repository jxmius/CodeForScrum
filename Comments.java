import java.util.ArrayList;

public class Comments {
    private String username;
    private ArrayList<String> commentsArray;

    public Comments(String username) {
        this.username = username;
        this.commentsArray = new ArrayList<>();
    }

    public void comment(String comment, Contributor contributor) {
        String commentText = username + " (" + contributor.getUsername() + "): " + comment;
        commentsArray.add(commentText);
    }

    public void addComment(String comment) {
        commentsArray.add(comment);
    }

    public String getMessage(int commentIndex) {
        if (commentIndex >= 0 && commentIndex < commentsArray.size()) {
            return commentsArray.get(commentIndex);
        } else {
            return "Invalid comment index.";
        }
    }

    public void displayComments() {
        System.out.println("Comments:");
        for (String comment : commentsArray) {
            System.out.println(comment);
        }
    }

    public static void main(String[] args) {
        Contributor contributor = new Contributor("Alice", "Alice", "Smith");
        Comments comments = new Comments("Bob");

        comments.comment("This is a great idea!", contributor);
        comments.comment("I agree with Alice.", contributor);
        comments.addComment("Thanks for the input!");

        comments.displayComments();

        // Example of retrieving a comment message
        String message = comments.getMessage(0);
        System.out.println("Retrieved Comment: " + message);
    }
}
