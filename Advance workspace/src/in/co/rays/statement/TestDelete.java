package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate("delete from marksheet where id=5");
		System.out.println("Data deleted "+i);
	}
}
