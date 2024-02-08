package com.ty.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ty.ems.entity.Address;
import com.ty.ems.util.EMSUtil;

public class AdressDao {
	
	public Address saveAddress(Address address)
	{
		EntityManager manager = EMSUtil.getManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(address);
		transaction.commit();
		
		return address;
	}

}
