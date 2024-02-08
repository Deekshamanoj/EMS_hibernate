package com.ty.ems.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.service.spi.Manageable;

public class EMSUtil {

	public static EntityManager getManager()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dee");
		return factory.createEntityManager();
		
	}
}
