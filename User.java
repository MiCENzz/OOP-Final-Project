import java.util.ArrayList;


public class User extends Person{
	private ArrayList<Post> myPosts;

	public User(String username, String password) {
		super(username, password);
	    this.myPosts = new ArrayList<>();
	}
	
	public ArrayList<Post> getPosts(){
		return myPosts;
	}
	
	public void post(Post post, Forum forum) {
		    myPosts.add(post);
        forum.addPost(post);
    }
	
	
	public void deletePost(int postId, Forum forum) {
		Post postToDelete = null;
		for (Post post : myPosts) {
			if (post.getPostId() == postId) {
				postToDelete = post;
				break;
			}
		}	    
		if (postToDelete == null) {
			System.out.println("Post with ID " + postId + " not found.");
		    return;
		}else {
		     myPosts.remove(postToDelete);
		     forum.removePost(postId);
		     System.out.println("Post with ID " + postId + " deleted successfully.");
		 }    	
	}
	
	public static void addUser(User user, Forum forum) {
        forum.users.add(user);
    }
}
