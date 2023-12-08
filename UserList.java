import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.json.simple.parser.ParseException;

public class UserList {
    private static UserList instance;
    private List<User> userList;

    private UserList(List<User> users) {
        this.userList = users;
    }

    public static synchronized UserList getInstance() throws IOException, ParseException {
        if (instance == null) {
            instance = new UserList(DataLoader.loadUsers());
        }
        return instance;
    }

    public void addUser(User user) throws IOException  {
            userList.add(user);
            DataWriter.saveUsers(userList);
    }

    public List<User> getUsers() {
        return userList;
    }

    public void updateUser(UUID userId, User updatedUser) throws IOException {
        User user = getUserByUUID(userId);
        if (user != null) {
            userList.remove(user);
            userList.add(updatedUser);
            DataWriter.saveUsers(userList);
        } else {
            throw new IllegalArgumentException("User not found with UUID: " + userId);
        }
    }

    public void deleteUser(UUID userId) throws IOException {
        User user = getUserByUUID(userId);
        if (user != null) {
            userList.remove(user);
            DataWriter.saveUsers(userList);
        } else {
            throw new IllegalArgumentException("User not found with UUID: " + userId);
        }
    }

    public User getUserByUsername(String username) {
        return userList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    public User getUserByUUID(UUID userId) {
        return userList.stream()
                .filter(user -> user.getUuid().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public List<User> getUsersByFullName(String firstName, String lastName) {
        return userList.stream()
                .filter(user -> user.getFirstName().equalsIgnoreCase(firstName) && user.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }
}
