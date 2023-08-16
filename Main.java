import java.util.Scanner;
public class Main {
 static Scanner scanner = new Scanner(System.in);
    static Forum forum = new Forum();
 public static void main(String[] args) {
  setup();
  mainMenu();
 }
 
 private static void setup() {
        // Create moderators
  forum.addUser(new User("user1", "1234"));
  forum.addUser(new User("user2", "1234"));
  forum.addMod(new Moderator("moderator1", "1234"));
  forum.addMod(new Moderator("moderator2", "1234"));
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\nLogin Menu:");
           System.out.println("========================");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.println("Reminder: You may only sign up for a new user account. If you are a moderator, please log in using your credentials. ");
            System.out.print("Enter choice: ");
            String choice = scanner.next();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    signup();
                    break;
                case "3":
                    System.out.println("Exiting... Bye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check user login
        for (User user : forum.users) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                userMenu(user);
                return;
            }
        }

        // Check moderator login
        for (Moderator mod : forum.moderators) {
            if (mod.getName().equals(username) && mod.getPassword().equals(password)) {
                moderatorMenu(mod);
                return;
            }
        }

        System.out.println("Invalid login credentials!");
    }
    
    private static void signup() {
        System.out.print("Enter desired username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if the username is already taken
        for (User user : forum.users) {
            if (user.getName().equals(username)) {
                System.out.println("Username already taken! Please choose a different one.");
                return;
            }
        }

        // Otherwise, add the new user
        User newUser = new User(username, password);
        forum.addUser(newUser);
        System.out.println("You have successfully created your account! You can now login.");
    }
    
    private static void userMenu(User user) {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("========================");
            System.out.println("1. Create a post");
            System.out.println("2. View my posts");
            System.out.println("3. View all posts");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    userPost(user);
                    break;
                case 2:
                    viewUserPosts(user);
                    break;
                case 3:
                    userViewAllPosts(user);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userPost(User user){
        System.out.print("Enter post content: ");
                    String content = scanner.nextLine();
                    // user.post(content, user.getName()), forum);

                    Post createdPost = new Post(content, user.getName());
                    user.post(createdPost, forum);
    }
    
    private static void viewUserPosts(User user) {
        forum.displayUserPosts(user);
        System.out.print("Enter your post ID to delete your post, or 0 to go back: ");
        int postId = scanner.nextInt();
        if (postId != 0) {
            user.deletePost(postId, forum);
        }
    }
    
    private static void userViewAllPosts(User user) {
        forum.displayAllPosts();
        System.out.print("Enter 0 to go back: ");
        int num = scanner.nextInt();
        if (num == 0) {
         return;
        }
        else {
         System.out.println("Invalid choice. Please try again.");
        }
         
  }
    
    private static void moderatorMenu(Moderator moderator) {
        while (true) {
            System.out.println("\nModerator Menu:");
            System.out.println("1. View all posts");
            System.out.println("2. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    viewAllPosts(moderator);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
  
    private static void viewAllPosts(Moderator moderator) {
                          forum.displayAllPosts();
                    System.out.print("Enter a post ID to delete the post, or 0 to go back: ");
                    int postId = scanner.nextInt();
                    if (postId != 0) {
                        moderator.deletePost(postId, forum);
                    }
    }

}
