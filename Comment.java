public class Comment {
    private String commentID;
    private String userID;
    private String content;

    public Comment(String commentID, String userID, String content) {
        this.commentID = commentID;
        this.userID = userID;
        this.content = content;
    }

    public String getCommentID() { return commentID; }
    public String getUserID() { return userID; }
    public String getContent() { return content; }
}
