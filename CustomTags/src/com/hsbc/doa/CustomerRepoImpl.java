package com.hsbc.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.Customer;


public class CustomerRepoImpl implements doaRepo{

	static Connection con = null;
	static Statement stmt = null;
    private static  CustomerRepoImpl doaImpl;
    private CustomerRepoImpl() {}
	public static CustomerRepoImpl getInstance(String dbname,String username,String password){
		if(doaImpl==null) {
			doaImpl = new CustomerRepoImpl();
			try {
//				String createCommand = "Create table app.customer (customerID int, name varchar(20),age int,address varchar(20))";
				System.out.println("trying to connect to db");
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		        con = DriverManager.getConnection("jdbc:derby:"+dbname+";create=true");
		        stmt = con.createStatement();
//		        stmt.execute(createCommand);
		        System.out.println("db connection completed");
//		        String insertStr= "Insert into app.customer values(?,?,?,?)";
//		        PreparedStatement stmp = con.prepareStatement(insertStr);
//				try {
//					stmp = con.prepareStatement(insertStr);
//					stmp.setInt(1, 1235);
//					stmp.setString(2, "raj");
//					stmp.setInt(3, 24);
//					stmp.setString(4, "MI6");
//					int i = stmp.executeUpdate();
//					if(i>0) {
//						System.out.println("inserted");
//					}
//					stmp = con.prepareStatement(insertStr);
//					stmp.setInt(1, 1568);
//					stmp.setString(2, "James Bond");
//					stmp.setInt(3, 30);
//					stmp.setString(4, "licence to kill");
//					i = stmp.executeUpdate();
//					if(i>0) {
//						System.out.println("inserted");
//					}
//				}catch(SQLException ex) {
//					System.out.println("error in adding data to database ");
//					ex.printStackTrace();
//				}
		        return doaImpl;
			}catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return null;
		}
		else {
			return doaImpl;
		}
	}

	@Override
	public List getCustomerList(String query) throws SQLException{
		// TODO Auto-generated method stub
		ArrayList<Customer> list = new ArrayList();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
	         list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
	    }
		return list;
	}

}
