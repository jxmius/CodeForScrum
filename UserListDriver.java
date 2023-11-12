import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.json.simple.parser.ParseException;

public class UserListDriver {

    public static void main(String[] args) {
        try {
            // Init
            UserList userList = UserList.getInstance();

            // Create new
            UUID userId = UUID.randomUUID();
            User newUser = new User(userId, "testuser", "Test", "User", "test@example.com", "password123", false);

            // Add 
            System.out.println("Adding a new user...");
            userList.addUser(newUser);

            // Display
            System.out.println("Current users:");
            displayUsers(userList.getUsers());

            // Update
            System.out.println("Updating user...");
            User updatedUser = new User(userId, "updateduser", "Updated", "User", "updated@example.com", "newpassword", true);
            userList.updateUser(userId, updatedUser);

            // Display
            System.out.println("Users after update:");
            displayUsers(userList.getUsers());

            // Delete user
            System.out.println("Deleting user...");
            userList.deleteUser(userId);

            System.out.println("Users after deletion:");
            displayUsers(userList.getUsers());

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void displayUsers(List<User> users) {
        for (User user : users) {
            System.out.println("User: " + user.getUsername() + ", " + user.getFirstName() + " " + user.getLastName());
        }
    }
}
