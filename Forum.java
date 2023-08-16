import java.util.ArrayList;


public class Forum {
	protected ArrayList<Post> posts;
	protected ArrayList<User> users;
	protected ArrayList<Moderator> moderators;
	public Forum() {
		posts = new ArrayList<>();
	    users = new ArrayList<>();
	    moderators = new ArrayList<>();
	}
	
	public void addPost(Post post) {
        posts.add(post);
        System.out.println("You have successfully posted!");
    }
	
	public boolean removePost(int postId) {
		for (Post post : posts) {
	        if (post.getPostId() == postId) {
	            posts.remove(post);
	            return true;
	        }
	    }
	    return false;
	}
	
	public void displayAllPosts() {
		if(posts.isEmpty()) {
            System.out.println("There are no posts.");
            return;
        }
		System.out.println("PostID |Posted by      |Content");
        System.out.println("-----------------------------------------------------");
        for(Post post : posts) {
            post.printPost();
        }   
	}
	
	public void displayUserPosts(User user) {
		ArrayList<Post> userPosts = user.getPosts();
		if(userPosts.isEmpty()) {
		        System.out.println("There are no posts.");
		        return;
		}
		System.out.println("PostID |Posted by      |Content");
        System.out.println("-----------------------------------------------------");
        for(Post post : userPosts) {
            post.printPost();
        }   
	}
	
	public void addUser(User user) {
        users.add(user);
    }
	public void addMod(Moderator moderator) {
		moderators.add(moderator);
    }
}
