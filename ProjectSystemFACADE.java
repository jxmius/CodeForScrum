public class ProjectSystemFACADE {
        private UserList userList;
        private ProjectList projectList;
        private DataWriter dataWriter;
        private DataLoader dataLoader;
    
        public ProjectSystemFACADE() {
            this.userList = UserList.getInstance();
            this.projectList = ProjectList.getInstance();
            this.dataWriter = new DataWriter();
            this.dataLoader = new DataLoader(null, null);
        }
    
        public User login(String userName, String password) {
            // Sample logic to validate user
            // This should be enhanced to check from a stored list of users
            if (userName.equals("admin") && password.equals("password")) {
                return new User(userName, password, password, password);  // Placeholder return
            }
            return null;
        }
    
        public void signingUp(String firstName, String lastName, String userName, String password) {
            // Sample logic to sign up a user
            // This should store the user in a persistent storage
            User newUser = new User(userName, password, password, password); // Placeholder
            userList.addUser(newUser);
            dataWriter.saveUsers(userList);
        }
    
        public Project getProject(String projectName) {
            // Sample logic to retrieve a project
            // This should retrieve a project from a stored list of projects
            return projectList.getProject(projectName);
        }
    }
    
