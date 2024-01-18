package co.in.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class TestMetaData {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
		PreparedStatement pstmt=conn.prepareStatement("select * from user");
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
		ResultSetMetaData rstmt=(ResultSetMetaData) rs.getMetaData();
		System.out.println("Caltalog Name "+rstmt.getCatalogName(1));
		System.out.println("Table Name "+rstmt.getTableName(2));
		int columnCount=rstmt.getColumnCount();
		System.out.println("Total columns "+columnCount);
		
		for(int i=1;i<=columnCount;i++)
		{
			System.out.println("Column: "+i);
			System.out.println("Label: "+rstmt.getColumnLabel(i));
			System.out.println("Column name: "+rstmt.getColumnName(i));
			System.out.println("Type: "+rstmt.getColumnTypeName(i));
			System.out.println("Size: "+rstmt.getColumnDisplaySize(i));
			System.out.println("Precision: "+rstmt.getPrecision(i));
			System.out.println();
		}
		
	}
}
