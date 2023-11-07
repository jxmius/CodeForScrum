import java.util.List;
import java.util.UUID;

public class UserListDriver {
    public static void main(String[] args) {
        // Get the UserList instance
        UserList userList = UserList.getInstance();

        // Create a new user
        User user1 = new User(UUID.randomUUID(), "John", "Doe", "johndoe", "password123");
        user1.setUserType(false); // Regular user

        // Add the user to the list
        userList.addUser(user1);

        // Get a user by username
        User retrievedUser = userList.getUser("johndoe");
        if (retrievedUser != null) {
            System.out.println("Retrieved User: " + retrievedUser.getFirstName() + " " + retrievedUser.getLastName());
        } else {
            System.out.println("User not found.");
        }

        // Get all users
        List<User> allUsers = userList.getAllUsers();
        System.out.println("All Users:");
        for (User user : allUsers) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }
}
