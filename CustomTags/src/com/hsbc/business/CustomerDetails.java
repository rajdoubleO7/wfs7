package com.hsbc.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hsbc.doa.CustomerRepoImpl;
import com.hsbc.doa.doaRepo;
import com.hsbc.model.Customer;

public class CustomerDetails {
	static doaRepo cRepo;
	public CustomerDetails(String dbname,String username,String password) {
		cRepo = CustomerRepoImpl.getInstance(dbname, username, password);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Customer> getCustomerList(String query) {
		ArrayList<Customer> list = new ArrayList();
		try {
			list = (ArrayList<Customer>)cRepo.getCustomerList(query);
			System.out.println("Query executed!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
