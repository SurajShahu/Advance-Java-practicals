package in.co.rays.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {
	private static JDBCDataSource dataSource;
	private ComboPooledDataSource cpds = null;

	private JDBCDataSource() {

	}

	public static JDBCDataSource getInstance() {
		if (dataSource == null) {
			dataSource = new JDBCDataSource();
			dataSource.cpds = new ComboPooledDataSource();
			try {
				dataSource.cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			dataSource.cpds.setJdbcUrl("jdbc:mysql://localhost:3306/advance11");
			dataSource.cpds.setUser("root");
			dataSource.cpds.setPassword("root");
			dataSource.cpds.setInitialPoolSize(5);
			dataSource.cpds.setAcquireIncrement(5);
			dataSource.cpds.setMaxPoolSize(30);
		}
		return dataSource;
	}

	public static Connection getConnection() throws Exception {

		return getInstance().cpds.getConnection();
	}
	public static void closeConnection(Connection connection)
	{
		if(connection !=null)
		{
			try {
				connection.close();
			} catch (Exception e) {
				
			}
		}
	}
	public static void trnRollback(Connection connection) throws Exception
	{
		try {
			if(connection!=null)
			{
				connection.rollback();
			}
		} catch (Exception ex) {
			throw new Exception(ex.toString());
		}
		
	}
}
