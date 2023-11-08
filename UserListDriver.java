import java.io.IOException;
import java.util.UUID;

import org.json.simple.parser.ParseException;

public class UserListDriver {
    public static void main(String[] args) {
        try {
            // Get the singleton instance of UserList
            UserList userList = UserList.getInstance();

            // Create a new user
            User newUser1 = new User(UUID.randomUUID(), "John", "Doe", "johndoe", "password1", null, false);
            User newUser2 = new User(UUID.randomUUID(), "Alice", "Smith", "alicesmith", "password2", null, false);

            // Add users to the list
            userList.addUser(newUser1);
            userList.addUser(newUser2);

            // Print the list of users
            System.out.println("List of Users:");
            for (User user : userList.getUsers()) {
                System.out.println(user.getFirstName() + " " + user.getLastName() + " (" + user.getUsername() + ")");
            }

            // Update a user
            UUID userIdToUpdate = newUser1.getUuid();
            User updatedUser = new User(userIdToUpdate, "John", "Doe", "newjohndoe", "newpassword", null, false);
            userList.updateUser(userIdToUpdate, updatedUser);

            // Print the updated list of users
            System.out.println("\nUpdated List of Users:");
            for (User user : userList.getUsers()) {
                System.out.println(user.getFirstName() + " " + user.getLastName() + " (" + user.getUsername() + ")");
            }

            // Delete a user
            UUID userIdToDelete = newUser2.getUuid();
            userList.deleteUser(userIdToDelete);

            // Print the updated list of users after deletion
            System.out.println("\nUpdated List of Users after Deletion:");
            for (User user : userList.getUsers()) {
                System.out.println(user.getFirstName() + " " + user.getLastName() + " (" + user.getUsername() + ")");
            }

            // Search for a user by username
            String searchUsername = "newjohndoe";
            User foundUser = userList.getUserByUsername(searchUsername);
            if (foundUser != null) {
                System.out.println("\nFound User by Username: " + foundUser.getFirstName() + " " + foundUser.getLastName());
            } else {
                System.out.println("\nUser not found by username: " + searchUsername);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
