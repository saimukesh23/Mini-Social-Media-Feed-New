import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocialMediaApp {
    private List<User> users;
    private List<Post> posts;
    private User currentUser;

    public SocialMediaApp() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
        currentUser = null;
    }

    public void registerUser(String username, String password) {
        String userID = "U" + (users.size() + 1);
        User user = new User(userID, username, password);
        users.add(user);
        System.out.println("User registered with ID: " + userID);
    }

    public void loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Welcome, " + username);
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    public void createPost(String content) {
        if (currentUser == null) {
            System.out.println("You must be logged in to post.");
            return;
        }
        String postID = "P" + (posts.size() + 1);
        Post post = new Post(postID, currentUser.getUserID(), content);
        posts.add(post);
        System.out.println("Post created with ID: " + postID);
    }

    public void viewFeed() {
        System.out.println("Feed:");
        for (Post post : posts) {
            System.out.println("Post ID: " + post.getPostID() + " | Content: " + post.getContent() +
                               " | Likes: " + post.getLikes());
            for (Comment comment : post.getComments()) {
                System.out.println("    Comment: " + comment.getContent());
            }
        }
    }

    public void likePost(String postID) {
        for (Post post : posts) {
            if (post.getPostID().equals(postID)) {
                post.like();
                System.out.println("Liked post: " + postID);
                return;
            }
        }
        System.out.println("Post not found.");
    }

    public void commentOnPost(String postID, String content) {
        if (currentUser == null) {
            System.out.println("You must be logged in to comment.");
            return;
        }
        for (Post post : posts) {
            if (post.getPostID().equals(postID)) {
                String commentID = "C" + (post.getComments().size() + 1);
                Comment comment = new Comment(commentID, currentUser.getUserID(), content);
                post.addComment(comment);
                System.out.println("Comment added to post: " + postID);
                return;
            }
        }
        System.out.println("Post not found.");
    }

    public void logout() {
        currentUser = null;
        System.out.println("Logged out.");
    }
}
