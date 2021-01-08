package com.learn.ecommercewebsite.helper;

import java.util.UUID;
import javax.persistence.Query;

import org.hibernate.Session;

public class helper {

	public static String get10Words(String desc) {
		String[] strs = desc.split(" ");

		if (strs.length > 10) {

			String res = "";
			for (int i = 0; i < 10; i++) {
				res = res + " " + strs[i];
			}
			return (res + "...");

		} else {

			return (desc + "...");

		}
	}

	public static long[] getCounts() {

	long arry[] = new long[3];	
		
		
	Session session = FactoryProvider.getFactory().openSession();

		String q1 = "select count(*) FROM com.learn.ecommercewebsite.entities.User";
		String q2 = "select count(*) FROM com.learn.ecommercewebsite.entities.Product";
		String q3 = "select count(*) FROM com.learn.ecommercewebsite.entities.Category";

		Query query1 = session.createQuery(q1);
		Query query2 = session.createQuery(q2);
		Query query3 = session.createQuery(q3);
		
		long userCount = (long) query1.getSingleResult();
		long productCount = (long) query2.getSingleResult();
		long categoryCount = (long) query3.getSingleResult();
		
		arry[0] = userCount;
		arry[1] = productCount;
		arry[2] = categoryCount;

		session.close();
		return arry;
	}
	
	private static int getOrderNumber() {
		
		
		return 0;
	}
}
