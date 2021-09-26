package com.repairs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.repairs.controller.CustomerController;
import com.repairs.model.CustomerModel;
import com.repairs.model.TechnicianModel;
import com.repairs.service.RepairService;
import com.repairs.service.TechnicianService;

@WebMvcTest(CustomerController.class)
public class customerControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	RepairService rps;
	@MockBean
	TechnicianService ts;
	@MockBean
	TechnicianModel tm;
	@MockBean
	CustomerModel cm;
	
	
	@Test
	public void insertTestfail() throws Exception {
		
		when(rps.insertCustomerService(cm)).thenReturn(null);
		RequestBuilder request= MockMvcRequestBuilders.get("/regstatus")
				.accept(MediaType.APPLICATION_JSON);
		
		ResultActions result = mockmvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/firstPage.jsp"));
		
		//assertFalse(rps.insertCustomerService(cm));
		
	}
	@Test
	public void insertTestPass() throws Exception {
		 
		
		when(rps.insertCustomerService(cm)).thenReturn("success");
		
		RequestBuilder request= MockMvcRequestBuilders.get("/regstatus")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		ResultActions result = this.mockmvc.perform(request)
				.andExpect(status().isOk());
				//.andExpect(forwardedUrl("/WEB-INF/views/loginPage.jsp"));
		
		assertEquals(rps.insertCustomerService(cm),"success");
		
	}
	
	
	@Test
	public void firstPageTest() throws Exception {
		RequestBuilder request= MockMvcRequestBuilders.get("/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		ResultActions result = this.mockmvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/firstPage.jsp"));
	}
	
	@Test
	public void logTest() throws Exception{
		RequestBuilder request= MockMvcRequestBuilders.get("/log")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	
		ResultActions result = this.mockmvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/login.jsp"));
	}
	
	@Test
	public void deleteTest() throws Exception{
		RequestBuilder request= MockMvcRequestBuilders.get("/delete")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	
		ResultActions result = this.mockmvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/firstPage.jsp"));
	}
	
	@Test
	public void profileTest() throws Exception{
		RequestBuilder request= MockMvcRequestBuilders.get("/profile")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	
		ResultActions result = this.mockmvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/profile.jsp"));
	}
	
	@Test
	public void secondPageTest() throws Exception{
		RequestBuilder request= MockMvcRequestBuilders.get("/secondPage")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	
		ResultActions result = this.mockmvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/secondPage.jsp"));
	}
	
	@Test
	public void menuTest() throws Exception{
		RequestBuilder request= MockMvcRequestBuilders.get("/menu")
			.param("techSkill","something")
			.param("techRate","1000")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	
		ResultActions result = this.mockmvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/searchResults.jsp"));
	}
	
	
	@Test
	public void sortbyrateTest() throws Exception{
		RequestBuilder request= MockMvcRequestBuilders.get("/sortbyrate")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	
		ResultActions result = this.mockmvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/searchResults.jsp"));
	}
	@Test
	public void requestTest() throws Exception{
		RequestBuilder request= MockMvcRequestBuilders.get("/request")
			.param("technicianName","something")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
	
		ResultActions result = this.mockmvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/views/searchResults.jsp"));
	}
	
	
	@Test
	public void loginpageTest() throws Exception {
		RequestBuilder request= MockMvcRequestBuilders.get("/logstatus")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		ResultActions result = this.mockmvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/secondPage.jsp"));
		
	}
	
	@Test
	public void editTest() throws Exception {
		RequestBuilder request= MockMvcRequestBuilders.get("/edit")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		ResultActions result = this.mockmvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/profile.jsp"));
		
	}
}
