
public class Post {
	private static int currentId = 1;
    private int postId;
    private String content;
    private String username;
    
    public Post(String content, String username) {
        this.postId = currentId++;
        this.content = content;
        this.username = username;
    }
    
    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }
    
    public void printPost() {
    	System.out.printf("%-6d |%-14s |%-40s%n", this.postId, this.username, this.content);
    }
}
