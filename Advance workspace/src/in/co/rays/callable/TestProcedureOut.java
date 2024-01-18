package in.co.rays.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

import in.co.rays.util.JDBCDataSource;

public class TestProcedureOut {
	public static void main(String[] args) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		CallableStatement callStmt=conn.prepareCall("{CALL empOut(?)}");
		callStmt.registerOutParameter(1, Types.INTEGER);
		callStmt.execute();
		int resVal=callStmt.getInt(1);
		System.out.println("Result from empOut procedure salary= "+resVal);
	}
}
