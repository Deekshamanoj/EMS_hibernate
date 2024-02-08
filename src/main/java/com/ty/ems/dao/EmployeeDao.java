package com.ty.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jboss.jandex.TypeTarget.Usage;

import com.ty.ems.entity.Address;
import com.ty.ems.entity.Employee;
import com.ty.ems.util.EMSUtil;

public class EmployeeDao {

	public Employee saveEmployee(Employee employee)
	{
		EntityManager manager = EMSUtil.getManager();
		EntityTransaction transaction = manager.getTransaction();
		
		//checking whether address object is present or not
		if(employee.getAddress()!=null) {
			//get address
			 Address address=employee.getAddress();
			 AdressDao addressdao = new AdressDao();
			 //save address
			 address=addressdao.saveAddress(address);
			 //update employee object with saved address object
			 employee.setAddress(address);
		}
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		
		return employee;
	}

	public Employee findEmployeeByEmailAndPassword(String email, String password) {
		String jpql = "select e from Employee e where e.email = ?1 and e.password= ?2 ";
		EntityManager manager = EMSUtil.getManager();
		Query query =manager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Employee> list =query.getResultList();
		if(list!=null && !(list.isEmpty()) )
		{
			return list.get(0);
		}
		
		return null;
	}

	//Find all employees who has role as SE
	public List<Employee> findAllEmployeeAsSE() {
		String jpql = "select e from Employee e where e.role=?1";
		EntityManager manager = EMSUtil.getManager();
		Query query =manager.createQuery(jpql);
		query.setParameter(1, "SE");
		List<Employee> list =query.getResultList();
		return list;
		
	}
}
