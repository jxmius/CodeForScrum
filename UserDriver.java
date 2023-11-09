import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDriver 
{ public static void main(String[] args) 
    { User user1 = new User(UUID.randomUUID(), "JohnD", "John", "Doe", "johndoe@email.com", "password", false); 
    System.out.println("User1 UUID: " + user1.getUuid());
     System.out.println("User1 First Name: " + user1.getFirstName());
      System.out.println("User1 Last Name: " + user1.getLastName());
       System.out.println("User1 Username: " + user1.getUsername());
        System.out.println("User1 Password: " + user1.getPassword()); 
        System.out.println("User1 isUserTypeAdmin: " + user1.isUserTypeAdmin());
         System.out.println("User1 Project IDs: " + user1.getProjectIds());

             user1.addProjectId(UUID.randomUUID());
    System.out.println("User1 Project IDs after adding: " + user1.getProjectIds());

    user1.setUserType(true);
    System.out.println("User1 isUserTypeAdmin after changing user type: " + user1.isUserTypeAdmin());

    List<UUID> newProjectIds = new ArrayList<>();
    newProjectIds.add(UUID.randomUUID());
    newProjectIds.add(UUID.randomUUID());
    user1.setProjectIds(newProjectIds);
    System.out.println("User1 Project IDs after changing: " + user1.getProjectIds());
}
}
