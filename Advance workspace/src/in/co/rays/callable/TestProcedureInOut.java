package in.co.rays.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import in.co.rays.util.JDBCDataSource;

public class TestProcedureInOut {
	public static void main(String[] args) throws Exception{
		Connection conn=JDBCDataSource.getConnection();
		CallableStatement callStmt=conn.prepareCall("{CALL empInOut(?)}");
		callStmt.setInt(1, 10);
		callStmt.registerOutParameter(1, Types.INTEGER);
		callStmt.execute();
		System.out.println("Salary ="+callStmt.getInt(1));
	}
}
