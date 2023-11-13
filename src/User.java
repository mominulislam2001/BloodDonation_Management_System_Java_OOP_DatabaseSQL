public class User extends Individual{
  
    public String userName;
    private String password;

    public User(String fullName,String email,String userName) {
        
        super(fullName,email);
        this.userName = userName;
        
   
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
  
    
}
