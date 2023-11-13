
import DatabaseConnection.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class SearchClass implements SearchInterface {
    
    public String bloodGroup;
    public String location;

    public SearchClass(String bloodGroup, String location) {
        this.bloodGroup = bloodGroup;
        this.location = location;
    }
    
    public SearchClass(String bloodGroup) {
     
        this.bloodGroup = bloodGroup;
       
    }
    
    public ResultSet searchDonor(String location,String selectedBloodGroup){
            
        
         try{
            
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM donor WHERE (city = '" + location + "' OR address = '" + location + "') AND bloodGroup = '" + selectedBloodGroup + "'");
            
           return rs;
            
            
        }catch(Exception e){
            
               JOptionPane.showMessageDialog(null, e);
               return null;
        }
        
        
        
    }
    

    public ResultSet searchDonor(String selectedBloodGroup){
        
     
        try{
            
            
            
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery("select * from donor where bloodGroup = '"+selectedBloodGroup+"'");
            
            return rs;
            
            
        }catch(Exception e){
            
               JOptionPane.showMessageDialog(null, e);
               return null;
        }
        
       
    }
    
    
    
    
    
    
    
    
    
    
}
