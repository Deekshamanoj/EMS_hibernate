package com.ty.ems.controller;

import java.util.Scanner;

import com.ty.ems.entity.Address;

public class AddressContoller {

	public Address readAddressInfo(Scanner sc) {
		Address address = new Address();
		
		System.out.println("Enter line");
		address.setLine(sc.next());
		System.out.println("Enter City");
		address.setCity(sc.next());
		System.out.println("Enter State");
		address.setState(sc.next());
		System.out.println("Enter country");
		address.setCountry(sc.next());
		System.out.println("Enter pincode");
		address.setPincode(sc.nextInt());
		
		return address;
	}

}
