import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class DataLoader {
    private static final String DATA_FILE_PATH = "data.txt";

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = parseUser(line);
                if (user != null) {
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    

    public static void saveUsers(ArrayList<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH))) {
            for (User user : users) {
                String userData = formatUser(user);
                writer.write(userData);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User parseUser(String userData) {
        String[] parts = userData.split(",");
        if (parts.length == 7) {
            UUID uuid = UUID.fromString(parts[0]);
            String firstName = parts[1];
            String lastName = parts[2];
            String username = parts[3];
            String userEmail = parts[4];
            boolean userType = Boolean.parseBoolean(parts[6]);
            User user = new User(uuid, firstName, lastName, username, userEmail);
            user.setUserType(userType);
            return user;
        }
        return null;
    }

    private static String formatUser(User user) {
        return user.getUuid() + "," + user.getFirstName() + "," + user.getLastName() + ","
                + user.getUsername() + "," + "," + user.getPassword() + ","
                + user.isUserTypeAdmin();
    }
}
