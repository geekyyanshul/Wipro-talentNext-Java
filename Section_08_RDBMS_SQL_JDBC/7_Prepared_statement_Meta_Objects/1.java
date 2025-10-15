//JDBCCalls.java

class JDBCCalls{

	public static void main(String[] args) {
		try{
			DAOClass e = new DAOClass();
			int c = Integer.parseInt(args[0]);
//insert
			if(c == 1){
				e.insert(args);
			}
			//delete
			else if(c == 2){
				e.delete(args);
			}
			// modify
			else if(c == 3){
				e.modify(args);
			}
			// display
			else
				e.display(args);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
//DbConnection.java
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public static Connection takeConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.aOracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Bhopal12");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
		
	}

}


//DaoClass.java
import java.sql.*;
class DAOClass{

	Connection con;

	DAOClass(){

		 con = DbConnection.takeConnection();
		
	}
	// insert
	void insert(String[] args)throws SQLException{
			
		int Rollno = Integer.parseInt(args[1]);
		String StudentName = args[2];
		String Standard = args[3];
		String Date_Of_Birth = args[4];
		int Fees = Integer.parseInt(args[5]);
		PreparedStatement ps = con.prepareStatement("insert into student values(?, ?, ?, ?, ?)");
		ps.setInt(1, Rollno);
		ps.setString(2, StudentName);
		System.out.print("gt");
		ps.setString(3, Standard);
		ps.setString(4, Date_Of_Birth);
		ps.setInt(5, Fees);
		
		ps.executeUpdate();
	}

	//delete
	void delete(String[] args)throws SQLException{
		int Rollno = Integer.parseInt(args[1]);
		PreparedStatement pst = con.prepareStatement(" delete from student where Rollno = ?");
		pst.setInt(1, Rollno);
		pst.executeUpdate();
	}

	//modifying a record
	void modify(String[] args)throws SQLException{

		int Rollno = Integer.parseInt(args[1]);
		int Fees = Integer.parseInt(args[2]);
		PreparedStatement ps = con.prepareStatement(" Update student set Fees = ? where Rollno = ?");
		ps.setInt(1, Fees);
		ps.setInt(2, Rollno);
		ps.executeUpdate();
		System.out.println("Modified");
	}

	// display
	void display(String[] args)throws SQLException{
		if(args.length == 2){
			int Rollno = Integer.parseInt(args[1]);
			PreparedStatement pst = con.prepareStatement(" Select * from student where Rollno = ?");
			pst.setInt(1, Rollno);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)+ " " + rs.getString(4)
					+ " " + rs.getInt(5));
			}
		}
		else{
			PreparedStatement pst = con.prepareStatement(" Select * from student ");
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)+ " " + rs.getString(4)
					+ " " + rs.getInt(5));
			}
		}
	}

}



