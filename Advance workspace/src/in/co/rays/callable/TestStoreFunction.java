package in.co.rays.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import javax.security.auth.callback.Callback;

import in.co.rays.util.JDBCDataSource;

public class TestStoreFunction {
public static void main(String[] args) throws Exception{
	Connection conn=JDBCDataSource.getConnection();
	//Class.forName("com.mysql.cj.jdbc.Driver");
	//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11","root","root");
	CallableStatement callStmt=conn.prepareCall("{?=CALL square(?)}");
	callStmt.setInt(2, 4);
	callStmt.registerOutParameter(1, Types.INTEGER);
	callStmt.execute();
	int res=callStmt.getInt(1);
	System.out.println("Square = "+res);
}
}
