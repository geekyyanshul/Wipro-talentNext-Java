Stored procedure:
CREATE OR REPLACE PROCEDURE calculate_salary (
	p_empno IN emp.empno % TYPE,
	output OUT emp.sal % TYPE
) IS 
	p_comm emp.comm % TYPE;
	p_sal emp.sal % TYPE;

	gross_salary  emp.sal % TYPE;
	net_salary  emp.sal % TYPE;
	it  emp.sal % TYPE;
BEGIN 
	SELECT comm INTO p_comm FROM emp WHERE empno = p_empno;
	SELECT sal INTO p_sal FROM emp WHERE empno = p_empno;

	IF p_comm IS NULL THEN
		p_comm := 0;
	END IF;

	gross_salary := p_sal + p_comm;
	
	IF p_comm IS NULL THEN
		it := gross_salary * 10 / 100;
	ELSE
		IF p_comm < 500 THEN
			it := gross_salary * 15 / 100;
		ELSE
			it := gross_salary * 20 / 100;
		END IF;	
	END IF;

	net_salary := gross_salary - it;
	
	output := net_salary;
END calculate_salary;
/
commit;

//First.java

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;



public class First {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		CallableStatement cstmt = null;		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Bhopal12");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "SELECT * FROM emp";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				double netSalary = 0;
				String sql2 = "{ call calculate_salary(?, ?) }";
				cstmt = conn.prepareCall(sql2);
				cstmt.setInt(1, empno);
				cstmt.registerOutParameter(2, Types.DOUBLE);
				cstmt.executeQuery();
				netSalary = cstmt.getDouble(2);
				System.out.println("empno: " + empno + ", ename: " + ename + ", net salary: " + netSalary);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error");
			stmt.close();
			cstmt.close();
			conn.close();
		}
	}

}
