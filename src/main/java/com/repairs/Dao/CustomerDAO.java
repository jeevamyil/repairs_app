
package com.repairs.Dao;

import java.text.ParseException;

import com.repairs.model.CustomerModel;

public interface CustomerDAO {

	public String customerInsert(CustomerModel cm) throws ParseException;

	public void customerRemove(CustomerModel cm) throws ParseException;

	public void customerRetrival(CustomerModel cm);

	public String customerLogin(CustomerModel cm);

	public boolean customerEdit(CustomerModel cm);
}
