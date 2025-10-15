import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Second {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Bhopal12");
		System.out.println("Conn Done");
		
		
		int rollno = 0;
		do {
			System.out.print("Enter your rollno: ");
			String rollstr = sc.nextLine();
			
			try {
				rollno = Integer.parseInt(rollstr);
				if (String.valueOf(rollno).length() != 4) rollno = 0;
			} catch (Exception e) {}
		} while (rollno == 0);
		
		String studentName = "";
		boolean lower;
		do {
			System.out.print("Enter name: ");
			studentName = sc.nextLine();
			
			lower = false;
			for (int i = 0; i < studentName.length(); i++) {
				if (Character.isLowerCase(studentName.charAt(i))) {
					lower = true;
					break;
				}
			}
			
		} while (studentName.length() > 20 || lower);
		
		String standard = "";
		String[] standards = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
		List<String> list = new ArrayList<>(Arrays.asList(standards));
		do {
			System.out.print("Enter standard: ");
			standard = sc.nextLine();
		} while (!list.contains(standard));

		System.out.print("Enter D.O.B.: ");
		String dob = sc.nextLine();
		
		Double fees = 0.0;
		do {
			System.out.print("Enter fees: ");
			if (sc.hasNextDouble())
				fees = sc.nextDouble();
		} while (fees == 0.0);
		
		String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?)";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rollno);
			pstmt.setString(2, studentName);
			pstmt.setString(3, standard);
			pstmt.setString(4, dob);
			pstmt.setDouble(5, fees);
			pstmt.executeQuery();
			System.out.println("Student Added successfully");
			pstmt.close();
			conn.close();
				
		
		sc.close();
	}
	

}
