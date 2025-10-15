import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class First {

	public static void main(String[] args) throws SQLException {		
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Bhopal12");			
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
		
		String sql = "SELECT empno, ename FROM emp";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println("empno: " + rs.getInt(1) + ", ename: " + rs.getString(2));
		}
		
		stmt.close();		
		conn.close();
	}

}
