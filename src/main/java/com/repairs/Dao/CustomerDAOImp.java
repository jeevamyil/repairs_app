package com.repairs.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.repairs.model.CustomerModel;

@Component
public class CustomerDAOImp implements CustomerDAO {

	Connection con = ConnectionHandler.getConnection();

	@Override
	public String customerInsert(CustomerModel cm) throws ParseException {
		// This method will insert the data for new Customer
		String sql = "insert into customer(customer_name,customer_phonenumber,location) values (?,?,?)";
		
		try {
			System.out.println("trying to insert");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cm.getCustomerName());
			ps.setString(2, cm.getCustomerPhone());
			ps.setString(3, cm.getCustomerLocation());
			String rs = "";
			if (ps.executeUpdate() == 1) {
				rs="success";
				System.out.println("success");
				return rs;
			}else {
				System.out.println("failed");
			}


		} catch (SQLIntegrityConstraintViolationException e) {

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override

	public String customerLogin(CustomerModel cm) {
		// This method will validate the Customer
		System.out.println("trying to login");
		String sql = "select location from customer where customer_name=? and customer_phonenumber=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cm.getCustomerName());
			ps.setString(2, cm.getCustomerPhone());

			ResultSet q = ps.executeQuery();
			String rs = "";
			while (q.next()) {
				rs = q.getString("location");
			}
			System.out.println(rs);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void customerRemove(CustomerModel cm) throws ParseException {
		// This method will delete the Customer from database
		System.out.println("trying to delete");
		String sql = "delete from customer where customer_phonenumber=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ps.setString(1, cm.getCustomerName());
			ps.setString(1, cm.getCustomerPhone());
			if (ps.executeUpdate() == 1) {
				System.out.println("deleted");
			} else {
				System.out.println("failed");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void customerRetrival(CustomerModel cm) {
		
	}

	@Override
	public boolean customerEdit(CustomerModel cm) {
		// This method will edit the details of the Customer
		System.out.println("trying to edit");
		String sql = "update customer \r\n" + "set location=? where customer_phonenumber=?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cm.getCustomerLocation());
			ps.setString(2, cm.getCustomerPhone());

			if (ps.executeUpdate() == 1) {
				System.out.println("edited");
				return true;
			} else {
				System.out.println("failed");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
