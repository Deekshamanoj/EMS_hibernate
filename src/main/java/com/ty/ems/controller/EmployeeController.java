package com.ty.ems.controller;

import java.util.Scanner;
import com.ty.ems.entity.Address;
import com.ty.ems.entity.Employee;

public class EmployeeController {

	public Employee readEmployeeInfo(Scanner sc) {
		Employee employee = new Employee();
		
		System.out.println("Enter name ");
		employee.setName(sc.next());
		System.out.println("Enter email");
		employee.setEmail(sc.next());
		System.out.println("Enter Password");
		employee.setPassword(sc.next());
		System.out.println("Enter Role");
		employee.setRole(sc.next());
		
		//to read all Address info and to create Address object we create a new class
		//ADdressController and create method readADdressInfo which reads info
	    //and returns Address object 
		
		AddressContoller addressContoller=new AddressContoller();
		Address address= addressContoller.readAddressInfo(sc);
		
		employee.setAddress(address);
		
		
		return employee;
	}

}
