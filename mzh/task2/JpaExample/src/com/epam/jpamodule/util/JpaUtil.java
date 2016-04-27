package com.epam.jpamodule.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private EntityManagerFactory entityManagerFactory;
	private static final JpaUtil INSTANCE = new JpaUtil();

	private JpaUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("JpaExample");
	}

	public static JpaUtil getInstance() {
		return INSTANCE;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
