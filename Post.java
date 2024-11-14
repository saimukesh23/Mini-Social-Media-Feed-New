import java.util.ArrayList;
import java.util.List;

public class Post {
    private String postID;
    private String userID;
    private String content;
    private int likes;
    private List<Comment> comments;

    public Post(String postID, String userID, String content) {
        this.postID = postID;
        this.userID = userID;
        this.content = content;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public String getPostID() { return postID; }
    public String getUserID() { return userID; }
    public String getContent() { return content; }
    public int getLikes() { return likes; }
    public List<Comment> getComments() { return comments; }

    public void like() { likes++; }
    public void addComment(Comment comment) { comments.add(comment); }
}
