public class ContributorDriver {
    public static void main(String[] args) {
        Contributor contributor = new Contributor("johndoe", "John", "Doe");

        System.out.println("Contributor Details:");
        System.out.println("Username: " + contributor.getUsername());
        System.out.println("Full Name: " + contributor.getFullName());
    }
}
