package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	
	public void add(MarksheetBean bean) throws Exception
	{
		int pk=nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
		
		PreparedStatement pstmt=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		pstmt.setInt(1,pk);
		pstmt.setInt(2,bean.getRollNo());
		pstmt.setString(3,bean.getName());
		pstmt.setInt(4,bean.getPhy());
		pstmt.setInt(5,bean.getChem());
		pstmt.setInt(6,bean.getMaths());
		
		int i=pstmt.executeUpdate();
		System.out.println("Data inserted "+pk);
	}
	 
	public Integer nextPk() throws Exception
	{
		int pk=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
		
		PreparedStatement pstmt=conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			pk=rs.getInt(1);
		}
		
		return pk+1;
	}
	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		List list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}

			if (bean.getRollNo() > 0) {
				sql.append(" and roll_no=" + bean.getRollNo());
			}
			if (bean.getId() > 0) {
				sql.append(" and id=" + bean.getId());
			}
			
		}

		if (pageSize > 0 && pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		System.out.println("SQL ==>" + sql);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new MarksheetBean();
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

}
