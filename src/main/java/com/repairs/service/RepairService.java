package com.repairs.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repairs.Dao.*;
import com.repairs.Dao.CustomerDAO;
import com.repairs.Dao.CustomerDAOImp;
import com.repairs.model.CustomerModel;

@Service
public class RepairService {

	//private CustomerDAO custDAO = new CustomerDAOImp();
	@Autowired
	private CustomerDAO custDAO;
	public String insertCustomerService(CustomerModel cm) throws ParseException {
		return custDAO.customerInsert(cm);
	}

	public String loginCustomerService(CustomerModel cm) throws ParseException {
		String loca = custDAO.customerLogin(cm);
		return loca;
	}

	public void deleteCustomerService(CustomerModel cm) throws ParseException {
		custDAO.customerRemove(cm);
		System.out.println("success");
	}

	public boolean editCustomerService(CustomerModel cm) throws ParseException {
		return custDAO.customerEdit(cm);

	}

}
