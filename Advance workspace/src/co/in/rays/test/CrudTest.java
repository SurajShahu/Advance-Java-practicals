package co.in.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class CrudTest {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		testSearch();
	}


	private static void testSearch() throws Exception {
		List list=new ArrayList();
		CrudModel model=new CrudModel();
		list=model.search();
		Iterator it=list.iterator();
		CrudBean bean=new CrudBean();
		while (it.hasNext()) {
			bean=(CrudBean) it.next();
			System.out.print(""+bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLoginId());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
	}


	private static void testUpdate() throws Exception {
		CrudBean bean=new CrudBean();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		//int id=nextPk();
		bean.setId(5);
		bean.setFirstName("mr qq");
		bean.setLastName("neon");
		bean.setLoginId("a@abc.com");
		bean.setPassword("12233");
		bean.setDob(sdf.parse("22-01-2024"));
		bean.setAddress("aaa bbb");
		CrudModel model=new CrudModel();
		model.update(bean);
	}
	
	private static void testAdd() throws Exception {
		CrudBean bean=new CrudBean();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		//int id=nextPk();
		bean.setId(nextPk());
		bean.setFirstName("mr b");
		bean.setLastName("abacus");
		bean.setLoginId("mr b");
		bean.setPassword("abacus");
		bean.setDob(sdf.parse("22-01-2024"));
		bean.setAddress("abacus");
		CrudModel model=new CrudModel();
		model.add(bean);
	}
	public static Integer nextPk() throws Exception
	{
		int pk=0;
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("select max(id) from user");
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			pk=rs.getInt(1);
		}
		return pk+1;
	}
	
}
