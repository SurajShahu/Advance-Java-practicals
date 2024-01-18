package co.in.rays.advcrudlist;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		//testReadAll();
		testFindByPk();
	}

	private static void testFindByPk() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		bean = model.findByPk(3);
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getRollNo());
		System.out.print("\t" + bean.getName());
		System.out.print("\t" + bean.getPhy());
		System.out.print("\t" + bean.getChem());
		System.out.println("\t" + bean.getMaths());
	}

	private static void testReadAll() throws Exception {
		MarksheetModel model = new MarksheetModel();

		List list = model.readAll();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			MarksheetBean bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChem());
			System.out.println("\t" + bean.getMaths());
		}
	}
}
