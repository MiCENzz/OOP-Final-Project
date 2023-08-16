public abstract class Person {
	protected String username;
    protected String password;
    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public void deletePost() {}
}
