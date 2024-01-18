package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate("update marksheet set name='MR.C' where id=2");
		System.out.println("Data updated "+i);
	}
}
