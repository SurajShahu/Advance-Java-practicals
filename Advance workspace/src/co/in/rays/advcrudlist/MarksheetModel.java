package co.in.rays.advcrudlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	/*
	 * public void add(MarksheetBean bean) {
	 * 
	 * }
	 * 
	 * public void update(MarksheetBean bean) {
	 * 
	 * }
	 * 
	 * public void delete(int id) {
	 * 
	 * }
	 */

	public List readAll() throws Exception {
		List list = new ArrayList();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			MarksheetBean bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		return list;
	}

	public MarksheetBean findByPk(int id) throws Exception{
		MarksheetBean bean = new MarksheetBean();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
		PreparedStatement pstmt= conn.prepareStatement("select * from marksheet where id=?");
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		bean.setId(rs.getInt(1));
		bean.setRollNo(rs.getInt(2));
		bean.setName(rs.getString(3));
		bean.setPhy(rs.getInt(4));
		bean.setChem(rs.getInt(5));
		bean.setMaths(rs.getInt(6));
		return bean;
	}
}
