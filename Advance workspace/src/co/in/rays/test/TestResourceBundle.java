package co.in.rays.test;

import java.util.ResourceBundle;

public class TestResourceBundle {
	public static void main(String[] args) {
		ResourceBundle rb=ResourceBundle.getBundle("in.co.rays.bundle.system");
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("initialpoolsize"));
		System.out.println(rb.getString("maxpoolsize"));
		System.out.println(rb.getString("acquireincrement"));
	}
}
