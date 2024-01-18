package in.co.rays.pscrudobj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(16);
		/*
		 * bean.setRollNo(245); bean.setName("sss"); bean.setPhysics(73);
		 * bean.setChemistry(78); bean.setMaths(76);
		 */

		// testAdd(bean);

		// testUpdate(10, 225, "bbb", 66, 58, 76);
		// testDelete(4);
		// testRead();
		testFindById(bean);
	}

	private static void testFindById(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id=?");
		pstmt.setInt(1, bean.getId());
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		System.out.print(rs.getInt(1));
		System.out.print("\t" + rs.getInt(2));
		System.out.print("\t" + rs.getString(3));
		System.out.print("\t" + rs.getInt(4));
		System.out.print("\t" + rs.getInt(5));
		System.out.print("\t" + rs.getInt(6));

	}

	private static void testAdd(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());
		int i = pstmt.executeUpdate();
		System.out.println("Data inserted " + i);
	}
}
