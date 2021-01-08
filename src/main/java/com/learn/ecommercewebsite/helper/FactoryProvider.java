package com.learn.ecommercewebsite.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactoryProvider {

	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		try {

			if (factory == null) {

				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure("hibernate.cfg.xml").build();

				Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();

				factory = metadata.getSessionFactoryBuilder().build();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
}