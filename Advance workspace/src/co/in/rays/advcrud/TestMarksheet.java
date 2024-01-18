package co.in.rays.advcrud;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testRead();
		//testUpdate();
		//testDelete();
		//testReadById();
	}

	private static void testReadById() throws Exception {
		MarksheetModel model=new MarksheetModel();
		model.readById(11);
	}

	private static void testDelete() throws Exception {
		MarksheetModel model=new MarksheetModel();
		model.delete(10);
	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean=new MarksheetBean();
		bean.setId(2);
		bean.setRollNo(342);
		bean.setName("fff");
		bean.setPhy(78);
		bean.setChem(68);
		bean.setMaths(56);
		MarksheetModel model=new MarksheetModel();
		model.update(bean);
	}

	private static void testRead() throws Exception {
		MarksheetModel model=new MarksheetModel();
		model.read();
	}

	private static void testAdd() throws Exception {
		MarksheetBean bean=new MarksheetBean();
		bean.setId(17);
		bean.setRollNo(225);
		bean.setName("eee");
		bean.setPhy(67);
		bean.setChem(68);
		bean.setMaths(70);
		MarksheetModel model=new MarksheetModel();
		model.add(bean);
	}
}
