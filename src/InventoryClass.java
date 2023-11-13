
import DatabaseConnection.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class InventoryClass {
    
    
    
    public ResultSet showInventory(){
          
        
        try{
            
                     
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery("select * from inventory");
          
            return rs;
           
            
            
          }catch(Exception e){
        
                JOptionPane.showMessageDialog(null, e);
                return null;
          }
    }
    
    
    public Boolean increaseInventory(String bloodGroup,int unit){
            
         try{
         
            Connection con = ConnectionProvider.getCon();
            Statement statement = con.createStatement();
            
            statement.executeUpdate("update inventory set units =units+'"+unit+"' where bloodGroup='"+bloodGroup+"'");
            
            JOptionPane.showMessageDialog(null,"Succesfully Updated!!");
            
            return true;
            
        }catch(Exception e){
           
            
            JOptionPane.showMessageDialog(null,e);
            return false;
      
        }

        
        
    }
    
    public Boolean decreaseInventory(String bloodGroup,int unit){
        
        try {
          Connection con = ConnectionProvider.getCon();
          Statement statement = con.createStatement();

          
          ResultSet resultSet = statement.executeQuery("SELECT units FROM inventory WHERE bloodGroup='" + bloodGroup + "'");
      
         if(resultSet.next()){
             
                 int availableUnit = Integer.parseInt(resultSet.getString(1));
          
                  // Checking if the update will make the units negative
                 if((availableUnit-unit)<0){
              
                      JOptionPane.showMessageDialog(null, "Not enough units available to reduce !! ");
              
                 }else{
              
                  statement.executeUpdate("UPDATE inventory SET units = units - " + unit + " WHERE bloodGroup='" + bloodGroup + "'");
                  JOptionPane.showMessageDialog(null, "Successfully Updated!!");
            
                  return true;
           
              
              
                  }
            
               }
   
         } 
        catch (Exception e) {
        
             
          JOptionPane.showMessageDialog(null, e);
          return false;
   
        }
        return false;
        
        
        
        
    }
    
    
    
    
    
}
