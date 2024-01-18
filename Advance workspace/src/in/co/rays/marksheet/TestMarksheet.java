package in.co.rays.marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		//testSearch();
		//testAdd();
	}

	private static void testAdd() throws Exception {
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
		bean.setRollNo(270);
		bean.setName("AAAA");
		bean.setPhy(78);
		bean.setChem(56);
		bean.setMaths(80);
		model.add(bean);
	}

	private static void testSearch() throws Exception {
		List list=new ArrayList();
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
		bean.setName(null);
		bean.setRollNo(0);
		bean.setId(6);
		list=model.search(bean,0, 0);
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			bean=(MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChem());
			System.out.println("\t"+bean.getMaths());
		}
	}
}
