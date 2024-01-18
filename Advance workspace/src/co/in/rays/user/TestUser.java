package co.in.rays.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUser {
	public static void main(String[] args) throws Exception {
		//testAdd();
		testSearchAll();
		//testUpdate();
		//testDelete();
		//testSearch();
		//testSearchByLogin();
		//testAuthenticate();
		//testSearchByPk();
	}

	private static void testSearchByPk() throws Exception {
		UserModel model=new UserModel();
		UserBean bean=model.searchByPk(6);
		if(bean!=null && bean.getId()>0)
		{
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLoginId());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
	}

	private static void testAuthenticate() throws Exception{
		UserBean bean=new UserBean();
		UserModel model=new UserModel();
		bean=model.authenticate("rohit@g.cm","123");
		if(bean!=null && bean.getId()>0)
		{
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLoginId());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
		else {
			System.out.println("Login id and password does not exist");
		}
		
	}

	private static void testSearchByLogin() throws Exception {
		UserBean bean=new UserBean();
		UserModel model=new UserModel();
		
		bean=model.searchByLogin("air@g.com");
		if(bean!=null)
		{
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLoginId());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
		else {
			System.out.println("Login id does not exist");
		}
	}

	private static void testSearch() throws Exception{
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		List list=new ArrayList();
		
		String dob="11/01/1991";
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		bean.setFirstName("s");
		bean.setDob(sqlDate);
		
		list=model.search(bean,1,3);
		
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			bean=(UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLoginId());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
		
		
		
	}

	private static void testDelete() throws Exception{
		UserModel model=new UserModel();
		UserBean existBean=new UserBean();
		existBean=model.searchByPk(10);
		if(existBean!=null && existBean.getId()>0)
		{
			model.delete(existBean.getId());	
		}
		else {
			System.out.println("Id not found..!!");
		}
	}

	private static void testUpdate() throws Exception {
		String dob="23/10/1990";
		UserBean bean=new UserBean();
		UserModel model=new UserModel();
		bean.setId(2);
		bean.setFirstName("rohit");
		bean.setLastName("ghatge");
		bean.setLoginId("rohit@g.com");
		bean.setPassword("123");
		bean.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
		bean.setAddress("Udaipur");
		model.update(bean);
	}

	private static void testSearchAll() throws Exception {
		UserModel user = new UserModel();

		List list = new ArrayList();
		list = user.searchAll();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserBean bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		}
	}

	private static void testAdd() throws Exception {
		String dob="23/10/1990";
		UserBean bean = new UserBean();
		UserModel user = new UserModel();
		//bean.setId(4);
		bean.setFirstName("suraj");
		bean.setLastName("sahu");
		bean.setLoginId("suraj@gmail.com");
		bean.setPassword("12345");
		bean.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
		bean.setAddress("Indore");
		
		UserBean existBean=user.searchByLogin(bean.getLoginId());
		if(existBean!=null)
		{
			System.out.println("Login id already exist..!");
		}
		else {
			user.add(bean);
		}
		

	}

}
