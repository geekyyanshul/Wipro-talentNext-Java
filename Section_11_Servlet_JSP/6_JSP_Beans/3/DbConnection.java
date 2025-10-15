import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    
    public static Connection takeConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Bhop****");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;
        
    }

}
