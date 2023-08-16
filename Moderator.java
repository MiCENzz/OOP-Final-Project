
public class Moderator extends Person{

	public Moderator(String username, String password) {
		super(username, password);
    }
	
	public void deletePost(int postId, Forum forum) {
		 if (forum.removePost(postId)) {
		        System.out.println("Post with ID " + postId + " deleted successfully.");
		    } else {
		        System.out.println("Post with ID " + postId + " not found.");
		    }
	}
	
}
