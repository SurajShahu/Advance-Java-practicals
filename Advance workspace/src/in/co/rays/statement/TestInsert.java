package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("insert into marksheet values(11,101,'mr. a',67,78,87)");
		System.out.println("Data inserted " + i);
	}
}
