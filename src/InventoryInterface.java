
import java.sql.ResultSet;

public interface InventoryInterface {
  
    public ResultSet showInventory();
    public Boolean increaseInventory(String bloodGroup,int unit);
    public Boolean decreaseInventory(String bloodGroup,int unit);

}
