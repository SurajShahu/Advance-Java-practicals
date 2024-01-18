package co.in.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import in.co.rays.util.JDBCDataSource;

public class TestTranscaction {
	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			int i = stmt.executeUpdate("insert into emp values(20,'aaaa',1400,3)");
			i = stmt.executeUpdate("insert into emp values(21,'aaaa',1400,3)");
			i = stmt.executeUpdate("insert into emp values(21,'aaaa',1400,3)");

			conn.commit();
			System.out.println("Data inserted " + i);
			// conn.close();
		} catch (Exception e) {
			conn.rollback();
		}

	}
}
