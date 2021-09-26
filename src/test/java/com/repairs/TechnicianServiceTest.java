package com.repairs;

import static org.mockito.BDDMockito.given;
import static org.powermock.api.mockito.PowerMockito.*;
import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import com.repairs.Dao.CustomerDAO;
import com.repairs.Dao.CustomerDAOImp;
import com.repairs.model.CustomerModel;
import com.repairs.service.RepairService;


public class TechnicianServiceTest {
	
	@Mock
	private CustomerDAOImp cd;
	
	@Mock
	private CustomerModel cm ;
	
	@InjectMocks
	private RepairService cs;

	
	
	@Test
	public void insertserviceTest() throws ParseException {
		//CustomerModel cm= new CustomerModel("kk","cbe","1231231231");
		//given(cd.customerInsert(cm)).willReturn("success");
		
		when(cd.customerInsert(cm)).thenReturn("success");
		String result= cs.insertCustomerService(cm);
		//System.out.println(result);
	}
	
	@Test
	public void ediTest() throws ParseException {
		//CustomerModel cm= new CustomerModel("kk","cbe","1231231231");
		
		when(cd.customerEdit(cm)).thenReturn(true);
		Boolean result= cs.editCustomerService(cm);
		//System.out.println(result);
	}
	

	
}
