import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private ArrayList<User> userList;

    private UserList() {
        userList = new ArrayList<>();
    }

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public void addUser(String firstName, String lastName, String username, String userEmail, String password) {
        User newUser = new User(firstName, lastName, username, userEmail, password);
        userList.add(newUser);
    }

    public User getUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    public void saveUser() {
        // Implement the logic to save user data to a file or database.
    }
}
