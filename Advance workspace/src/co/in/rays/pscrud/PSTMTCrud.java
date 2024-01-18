package co.in.rays.pscrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PSTMTCrud {
	public static final String uname = "root";
	public static final String password = "root";
	public static final String url = "jdbc:mysql://localhost:3306/advance11";// jml3
	public static final String className = "com.mysql.cj.jdbc.Driver";// cmcjD

	public static void main(String[] args) throws Exception {
		// testAdd(14, 224, "aaa", 65, 56, 67);
		// testUpdate(10, 225, "bbb", 66, 58, 76);
		// testDelete(4);
		// testRead();
		testFindById(10);
	}

	private static void testFindById(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", uname, password);
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id=?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		System.out.print(rs.getInt(1));
		System.out.print("\t" + rs.getInt(2));
		System.out.print("\t" + rs.getString(3));
		System.out.print("\t" + rs.getInt(4));
		System.out.print("\t" + rs.getInt(5));
		System.out.print("\t" + rs.getInt(6));

	}

	private static void testRead() throws Exception {
		String sql = "select * from marksheet";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, uname, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

	private static void testDelete(int id) throws Exception {
		String sql = "delete from marksheet where id=?";
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, uname, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		int i = pstmt.executeUpdate();
		System.out.println("Data deleted " + i);
	}

	private static void testUpdate(int id, int rollNo, String name, int phy, int chem, int maths) throws Exception {
		String sql = "update marksheet set roll_no=?,name=?,physics=?,chemistry=?,maths=? where id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, uname, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, rollNo);
		pstmt.setString(2, name);
		pstmt.setInt(3, phy);
		pstmt.setInt(4, chem);
		pstmt.setInt(5, maths);
		pstmt.setInt(6, id);
		int i = pstmt.executeUpdate();
		System.out.println("Data updated " + i);
	}

	private static void testAdd(int id, int rollNo, String name, int phy, int chem, int maths) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setInt(2, rollNo);
		pstmt.setString(3, name);
		pstmt.setInt(4, phy);
		pstmt.setInt(5, chem);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();
		System.out.println("Data inserted " + i);
	}
}
