public class User {
    public String fullName;
    public String userName;
    public String email;
    private String password;

    public User(String fullName, String userName, String email, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
  

    
    
    
    
    
}
