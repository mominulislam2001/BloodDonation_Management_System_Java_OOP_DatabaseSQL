
import DatabaseConnection.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainClass {
    
    
 
    
    public static void main(String[] args){
        
       new Login().setVisible(true);
        
    }
    
    
    public Boolean addUserToDatabase(User user){
        
         try {
            
                
                Connection con = ConnectionProvider.getCon();
      
                Statement statement = con.createStatement();
                
                String emailCheckQuery = "SELECT * FROM user WHERE email = '" + user.email + "'";
        
                ResultSet emailResultSet = statement.executeQuery(emailCheckQuery);

        
                boolean emailExists = emailResultSet.next(); // Check if email exists

                // Check if the username already exists in the database
               String usernameCheckQuery = "SELECT * FROM user WHERE userName = '" + user.userName + "'";
               ResultSet usernameResultSet = statement.executeQuery(usernameCheckQuery);

                
               boolean usernameExists = usernameResultSet.next(); // Check if username exists

             // Close the result sets to release resources
             emailResultSet.close();
             usernameResultSet.close();

        
             if (emailExists) {
            
                 JOptionPane.showMessageDialog(null, "Email already exists in the database.");
      
             } else if (usernameExists) {
           
                 JOptionPane.showMessageDialog(null, "Username already exists in the database.");
        
             } else {
           
          
                 String insertQuery = "INSERT INTO user (fullName, userName, password, email) VALUES ('" + user.fullName + "','" + user.userName + "','" + user.getPassword() + "','" + user.email + "')";
            
                 statement.executeUpdate(insertQuery);

                 JOptionPane.showMessageDialog(null, "Successfully Signed Up");
            
                 return true;
       
             }
             
         }catch (Exception e) {
       
                JOptionPane.showMessageDialog(null, e);
                return false;
         }
         
         return false;
             
    }
    
    public Boolean loginUser(String username,String password){
        
            try{
               
                 Connection con = ConnectionProvider.getCon();
                 Statement statement = con.createStatement();
                 
            
                 String query = "SELECT password FROM user WHERE userName = '" + username + "'";
                 ResultSet resultSet = statement.executeQuery(query);

                  if (resultSet.next()) {
                  String storedPassword = resultSet.getString("password");

                     if (password.equals(storedPassword)) {
                           // Passwords match; user is authenticated
                             return true;
                     } else {
                            
                        JOptionPane.showMessageDialog(null, "Incorrect Password");
                         
                        return false;
                     }
               
                     
                   
                     
                  } else {
                      
                          JOptionPane.showMessageDialog(null, "User not found");
                          return false;
             
                  }
          
      
        }catch(Exception e){
              JOptionPane.showMessageDialog(null,e);
              return false;
        }
        
    }
    
     public Boolean addDonorToDatabase(Donor donor){
       
         
         try{
            
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            
                
            st.executeUpdate("insert into donor values('"+donor.donorId+"','"+donor.name+"','"+donor.fatherName+"','"+donor.motherName+"','"+donor.DOB+"','"+donor.mobileNo+"','"+donor.gender+"','"+donor.email+"','"+donor.bloodGroup+"','"+donor.city+"','"+donor.address+"')");
            
            JOptionPane.showMessageDialog(null,"Successfully Added New Donor !!");
            return true;
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
        
                   
     }
     
     public Boolean updateDonorInfoDatabase(Donor donor){ 
        
         try{
            
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            
            statement.executeUpdate("update donor set name='"+donor.name+"',fatherName='"+donor.fatherName+"',motherName='"+donor.motherName+"',DOB='"+donor.DOB+"',mobileNo='"+donor.mobileNo+"',gender='"+donor.gender+"',email='"+donor.email+"',bloodGroup='"+donor.bloodGroup+"',city='"+donor.city+"',address='"+donor.address+"' where donorId= '"+donor.donorId+"'");
            
            JOptionPane.showMessageDialog(null,"Succesfully Update");
            
            return true;
            
        }catch(Exception e){
            
             JOptionPane.showMessageDialog(null,e);
             return false;
        }
         
          
     }
    
    
    
    
       public Boolean removeDonorFromDatabase(String donorId){
           try{
                       
               
               Connection con = ConnectionProvider.getCon();
                  
               Statement statement = con.createStatement();  
                  
               int deleted = statement.executeUpdate("delete from donor where donorId = '"+donorId+"'");
                    
                  
               if(deleted > 0){
                    
                      
                   JOptionPane.showMessageDialog(null, "Successfully Deleted Donor");
                         
                   return true;
                          
                        
               }else{
                             
                   JOptionPane.showMessageDialog(null, "Could not delete donor. Sorry. ");
                         
                   return false;
                    
               }
                     
           }catch(Exception e){
            
              
               JOptionPane.showMessageDialog(null, e);
                 
               return false;
                 
           }
    
       
       }
    
    
    
    
    
    
    
}
