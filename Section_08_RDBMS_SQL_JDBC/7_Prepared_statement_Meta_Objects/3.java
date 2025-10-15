import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Third {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Bhopal12");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		int rollno = Integer.parseInt(args[0]);
		try {
			sql = "INSERT INTO student_log SELECT * FROM student WHERE rollno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rollno);
			int logged = pstmt.executeUpdate();
			sql = "DELETE FROM student WHERE rollno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rollno);
			if (ps.executeUpdate() == 1 && logged == 1)
				System.out.println("Student having rollno :” + rollno + " deleted ");
			else
				System.out.println("Error occurred");
			ps.close();	
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
sc.close();
	}
}

