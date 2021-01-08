package com.learn.ecommercewebsite.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learn.ecommercewebsite.entities.Product;
import com.learn.ecommercewebsite.helper.FactoryProvider;

public class ProductDao {

	private Object factory;
	private Query query;

	public boolean saveProduct(Product product) {
		boolean isSaved = true;
		try (Session hibernateSession = FactoryProvider.getFactory().openSession()) {
			Transaction tx = hibernateSession.beginTransaction();
			hibernateSession.save(product);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			isSaved = false;
		}
		return isSaved;
	}

	// get all products
	public List<Product> getAllProducts() {

		List<Product> list = new ArrayList();
		try (Session session = FactoryProvider.getFactory().openSession()) {
			String query = "FROM com.learn.ecommercewebsite.entities.Product";
			list = session.createQuery(query).getResultList();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Product> getProductsByCategoryId(int cid) {

		List<Product> list = new ArrayList();
		try (Session session = FactoryProvider.getFactory().openSession()) {
			String query = "FROM com.learn.ecommercewebsite.entities.Product where category.categoryId =:id";
			Query q = session.createQuery(query);
			q.setParameter("id", cid);
			list = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
