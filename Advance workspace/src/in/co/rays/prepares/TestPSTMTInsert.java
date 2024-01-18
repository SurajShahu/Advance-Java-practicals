package in.co.rays.prepares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPSTMTInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
		PreparedStatement pstmt=conn.prepareStatement("insert into marksheet values(12,145,'MR.C',67,57,76)");
		int i=pstmt.executeUpdate();
		System.out.println("Data inserted "+i);
	}
}
