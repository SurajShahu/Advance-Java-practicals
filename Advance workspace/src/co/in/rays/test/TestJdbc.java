package co.in.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.util.JDBCDataSource;

public class TestJdbc {
	public static void main(String[] args) throws Exception {
		for(int i=0;i<50;i++)
		{
			System.out.println("Connection "+i);
			testGet();
		}
		
	}

	private static void testGet() throws Exception{
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("select * from user where id=1");
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getDate(6));
			System.out.println("\t"+rs.getString(7));
		}
	}
}
