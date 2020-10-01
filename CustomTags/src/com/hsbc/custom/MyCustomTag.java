package com.hsbc.custom;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.hsbc.business.CustomerDetails;
import com.hsbc.model.Customer;

public class MyCustomTag extends BodyTagSupport{
	
	String query,database,username,password;
	static CustomerDetails cDetails;
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			cDetails = new CustomerDetails(database,username,password);
			ArrayList<Customer> list = cDetails.getCustomerList(query);
			for(Customer c:list) {
				pageContext.getOut().print("<h2>"+c.getCustomerID()+"\t"+c.getName()+"\t"+c.getAge()+"\t"+c.getAddress()+"\n<h2>");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		try {
//			System.out.println("end tag is called");
			pageContext.getOut().print("</h2>");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
//	@Override
//	public int doAfterBody() throws JspException {
//		// TODO Auto-generated method stub
//		return super.doAfterBody();
//	}
}
