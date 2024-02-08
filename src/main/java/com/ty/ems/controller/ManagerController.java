package com.ty.ems.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.ems.dao.EmployeeDao;
import com.ty.ems.entity.Employee;

public class ManagerController {

	public void operation(Scanner sc) {
		while(true)
		{
			System.out.println("----------- Select choice ----------");
			System.out.println("1.Create Task\n2.Display all employees\n3.Exit");
			int choice=sc.nextInt();
			switch (choice) {
			case 1://create task and assign it to employeee
				break;
				
			case 2://Display all employee
				displayEmployee();
				break;
				
			case 3:System.exit(0);
				break;

			default:System.out.println("Invalid choice !!!!");
				break;
			}
		}
	}

	public void displayEmployee() {
		
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.findAllEmployeeAsSE();
		System.out.println("-----------Employee Data----------");
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	

}
