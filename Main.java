import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SocialMediaApp app = new SocialMediaApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Post\n4. View Feed\n5. Like Post\n6. Comment on Post\n7. Logout\n8. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    app.registerUser(username, password);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    app.loginUser(username, password);
                    break;
                case 3:
                    System.out.print("Enter post content: ");
                    String content = scanner.nextLine();
                    app.createPost(content);
                    break;
                case 4:
                    app.viewFeed();
                    break;
                case 5:
                    System.out.print("Enter post ID to like: ");
                    String postID = scanner.nextLine();
                    app.likePost(postID);
                    break;
                case 6:
                    System.out.print("Enter post ID to comment on: ");
                    postID = scanner.nextLine();
                    System.out.print("Enter comment: ");
                    content = scanner.nextLine();
                    app.commentOnPost(postID, content);
                    break;
                case 7:
                    app.logout();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
