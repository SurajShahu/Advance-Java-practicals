package in.co.rays.prepares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicPSTMTInsert1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		pstmt.setInt(1, 13);
		pstmt.setInt(2, 324);
		pstmt.setString(3, "MR.D");
		pstmt.setInt(4, 65);
		pstmt.setInt(5, 45);
		pstmt.setInt(6, 76);
		int i = pstmt.executeUpdate();
		System.out.println("Data inserted " + i);
	}
}
