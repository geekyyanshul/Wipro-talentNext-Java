import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class First {
    public static void main(String args[]){
	try {
		Class.forName(“oracle.jdbc.driver.OracleDriver”);
		Connection con = DriverManager.getConnection(“jdbc:oracle:thin:@localhost:1521:orcl”);
		System.out.println(“Connection Established successfully”);
		Con.close();
   }     catch(Exception e){
            System.out.println("Connection could  not be established");
            System.out.println(e);
        }
}
}
