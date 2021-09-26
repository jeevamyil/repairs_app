package com.repairs;

import static org.powermock.api.mockito.PowerMockito.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import com.repairs.Dao.TechnicianDAO;
import com.repairs.Dao.TechnicianDAOImp;
import com.repairs.model.TechnicianModel;
import com.repairs.service.TechnicianService;


public class RepairServiceTest {
	
	@Mock
	private TechnicianDAOImp td;
	
	@Mock
	private TechnicianModel tm ;
	
	@InjectMocks
	private TechnicianService ts;

	
	
	@Test
	public void searchserviceTest() throws ParseException {
		//CustomerModel cm= new CustomerModel("kk","cbe","1231231231");
		//given(cd.customerInsert(cm)).willReturn("success");
		List<TechnicianModel> cj=new ArrayList<TechnicianModel>();
		cj.add(0,new TechnicianModel("jj","4", "carpenter","cbe", "500"));
		when(td.technicianSearch("j", "kj", 122)).thenReturn(cj);
		List<TechnicianModel> result= ts.searchTechnicianService("j","kj", 122);
		//System.out.println(result);
	}
	
	

	
}
