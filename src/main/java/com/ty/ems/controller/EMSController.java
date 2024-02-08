package com.ty.ems.controller;

import java.util.Scanner;

import com.ty.ems.dao.EmployeeDao;
import com.ty.ems.entity.Employee;

public class EMSController {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);

		// to read all employee info and to create employee object we create a new class
		// EmployeeController and create method readEmployyeInfo which reads info
		// and returns employee object

		EmployeeController empController = new EmployeeController();
		EmployeeDao dao = new EmployeeDao();

		while (true) {
			System.out.println("SELECT CHOICE :\n1.LOGIN\n2.REGISTER\n3.EXIT");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				login (sc, empController, dao);
				break;

			case 2:
				register(sc, empController, dao);
				break;

			case 3:
				System.exit(0);
				break;

			default:
				System.out.println(" Invalid choice ");
				break;
			}
		}
	}

	
	public static void login(Scanner sc, EmployeeController empController, EmployeeDao dao) {
		System.out.println("Enter Email ");
		String email = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		Employee employee = dao.findEmployeeByEmailAndPassword(email,password);
		if(employee!=null) {
			System.out.println("I welcome you");
			
			//if employee is manager then manager view
			if(employee.getRole().equalsIgnoreCase("manager"))
			{
				//create task 
				//assigning task
				//see list of employees in company
				
				ManagerController managerController = new ManagerController();
				managerController.operation(sc);
			}
		}
		else
			System.out.println("Credential wrong");
	}
	
	

	public static void register(Scanner sc, EmployeeController empController, EmployeeDao dao) {
		Employee employee = empController.readEmployeeInfo(sc);
		employee = dao.saveEmployee(employee);
		System.out.println("Employee saved " + employee);

	}

}
