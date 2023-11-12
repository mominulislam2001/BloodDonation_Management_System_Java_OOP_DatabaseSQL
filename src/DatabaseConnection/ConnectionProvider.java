package DatabaseConnection;




import java.sql.DriverManager;
import java.sql.Connection;



public class ConnectionProvider {
    
    public static Connection getCon(){
        
        try{
            
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","Lig8h0us3@");
            
                   
                   
            return con;
            
            
        }catch(Exception e){
           
            return null;
            
        }
    }
    

    
}
