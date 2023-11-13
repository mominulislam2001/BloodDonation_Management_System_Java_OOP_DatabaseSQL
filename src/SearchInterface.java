
import java.sql.ResultSet;


public interface SearchInterface {
   
    public  ResultSet searchDonor(String location,String selectedBloodGroup);
    public  ResultSet searchDonor(String selectedBloodGroup);
}
