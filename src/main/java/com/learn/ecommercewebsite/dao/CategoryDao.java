package com.learn.ecommercewebsite.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.ecommercewebsite.entities.Category;
import com.learn.ecommercewebsite.helper.FactoryProvider;

public class CategoryDao {

	public CategoryDao() {

	}

	public boolean saveCategory(Category cat) {
		boolean isSaved = true;
		try {
			Session hibernateSession = FactoryProvider.getFactory().openSession();
			Transaction tx = hibernateSession.beginTransaction();
			hibernateSession.save(cat);
			tx.commit();
			hibernateSession.close();
		} catch (Exception e) {
			e.printStackTrace();
			isSaved = false;
		}
		return isSaved;
	}

	public Category getCategoryByName(String title) {

		Category category = null;
		try (Session session = FactoryProvider.getFactory().openSession()) {
			String query = "FROM com.learn.ecommercewebsite.entities.Category  where categoryTitle =:c ";
			Query q = session.createQuery(query);
			q.setParameter("c", title);

			category = (Category) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	public static List<String> listOfAllcategorieNames() {

		List<String> list = null;
		try (Session session = FactoryProvider.getFactory().openSession()) {
			String query = "select categoryTitle FROM com.learn.ecommercewebsite.entities.Category";
			list = session.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Category> listOfAllcategories() {

		List<Category> list = null;
		try (Session session = FactoryProvider.getFactory().openSession()) {
			String query = "FROM com.learn.ecommercewebsite.entities.Category";
			list = session.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
