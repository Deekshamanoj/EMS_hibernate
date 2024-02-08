package com.ty.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ty.ems.entity.Task;
import com.ty.ems.util.EMSUtil;

public class TaskDao {
	
	public Task saveTask(Task task )
	{
		 EntityManager manager =EMSUtil.getManager();
		 EntityTransaction transaction = manager.getTransaction();
		 
		 transaction.begin();
		 manager.persist(task);
		 transaction.commit();
		 
		 return task;
	}

}
