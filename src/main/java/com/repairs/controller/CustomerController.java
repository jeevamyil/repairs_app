
package com.repairs.controller;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.repairs.model.CustomerModel;
import com.repairs.model.TechnicianModel;
import java.util.List;
import com.repairs.service.RepairService;
import com.repairs.service.TechnicianService;

@Controller
@SessionAttributes({ "name", "contact" })
public class CustomerController {
	@Autowired
	private RepairService customerService;

	@Autowired
	private TechnicianService technicianService;


	CustomerModel customModel = new CustomerModel();
	TechnicianModel techModel = new TechnicianModel();


	@RequestMapping(value = "/")
	public ModelAndView firstPage(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result) {
		ModelAndView view = new ModelAndView();
		view.setViewName("firstPage");
		return view;
	}

	@RequestMapping(value = "/regstatus")
	public ModelAndView secondPage(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result)
			throws ParseException {
		// inserting customer data into database
		String fla = customerService.insertCustomerService(customerModel);
		System.out.println(fla);
		ModelAndView view = new ModelAndView();
		// returning success message upon successful registration
		if (fla!="") {
			view.setViewName("firstPage");
			String mess = "Registered successfully!!! please proceed to login";
			view.addObject("Success", mess);
			return view;
		} else {
			// returning alert message when user already exists for the given details
			view.setViewName("firstPage");
			String mess = "User already exists!. please select a different phone number";
			view.addObject("message", mess);
			return view;

		}
	}

	// returning login page when login button is pressed
	@RequestMapping(value = "log")
	public ModelAndView login(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result) {
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;

	}

	@RequestMapping(value = "/logstatus")
	public ModelAndView loginPage(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result)
			throws ParseException {
		// validating the login credentials
		String locat = customerService.loginCustomerService(customerModel);
		ModelAndView view = new ModelAndView();
		// returning second page when logged in successfully
		if (locat != "") {
			view.setViewName("secondPage");
			view.addObject("name", customerModel.getCustomerName());
			view.addObject("location", locat);
			view.addObject("contact", customerModel.getCustomerPhone());
			customModel.setCustomerName(customerModel.getCustomerName());
			customModel.setCustomerLocation(locat);
			customModel.setCustomerPhone(customerModel.getCustomerPhone());
			return view;
		} else {
			// return registration page on failure
			view.setViewName("firstPage");
			return view;
		}
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result)
			throws ParseException {
		ModelAndView view = new ModelAndView();
		// deleting the user account
		customerService.deleteCustomerService(customModel);
		view.setViewName("firstPage");
		return view;
	}

	// returning user profile page upon request
	@RequestMapping(value = "/profile")
	public ModelAndView profile(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result)
			throws ParseException {
		ModelAndView view = new ModelAndView();
		view.setViewName("profile");
		view.addObject("name");
		view.addObject("location", customModel.getCustomerLocation());
		view.addObject("contact");
		return view;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView edit(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result)
			throws ParseException {
		ModelAndView view = new ModelAndView();
		// modifying user location
		customModel.setCustomerLocation(customerModel.getCustomerLocation());
		boolean flag = customerService.editCustomerService(customModel);
		if (flag) {
			view.setViewName("profile");
			view.addObject("name");
			view.addObject("location", customModel.getCustomerLocation());
			view.addObject("contact");
			view.addObject("news", "Location updated successfully");
			return view;
		} else {
			view.setViewName("profile");
			view.addObject("name");
			view.addObject("location", customModel.getCustomerLocation());
			view.addObject("contact");
			view.addObject("news", "Sorry.. Try again");
			return view;
		}

	}

	// returning homepage when home button is pressed
	@RequestMapping(value = "/secondPage")
	public ModelAndView homePage(@ModelAttribute("customerModel") CustomerModel customerModel, BindingResult result)
			throws ParseException {
		ModelAndView view = new ModelAndView();
		view.setViewName("secondPage");
		view.addObject("location", customModel.getCustomerLocation());
		return view;
	}

	// show search results
	@RequestMapping(value = "/menu")
	public ModelAndView menu(@RequestParam("techSkill") String skill, @RequestParam("techRate") int rate)
			throws ParseException {
		List<TechnicianModel> j = technicianService.searchTechnicianService(customModel.getCustomerLocation(), skill,
				rate);
		techModel.setTechnicianSkill(skill);
		techModel.setTechnicianPay(String.valueOf(rate));
		techModel.setTechnicianLocation(customModel.getCustomerLocation());
		ModelAndView view = new ModelAndView();
		view.addObject("lis", j);
		view.addObject("location", customModel.getCustomerLocation());
		view.setViewName("searchResults");
		return view;
	}

	// sort the results by rating
	@RequestMapping(value = "/sortbyrating")
	public ModelAndView sort() throws ParseException {
		List<TechnicianModel> js = technicianService.sortTechnicianService(techModel.getTechnicianLocation(),
				techModel.getTechnicianSkill(), Integer.parseInt(techModel.getTechnicianPay()));
		ModelAndView view = new ModelAndView();
		view.addObject("lis", js);
		view.addObject("location", customModel.getCustomerLocation());
		view.setViewName("searchResults");
		return view;
	}

	// sort the results by rate
	@RequestMapping(value = "/sortbyrate")
	public ModelAndView sortb() throws ParseException {
		List<TechnicianModel> js = technicianService.searchTechnicianService(techModel.getTechnicianLocation(),
				techModel.getTechnicianSkill(), Integer.parseInt(techModel.getTechnicianPay()));
		ModelAndView view = new ModelAndView();
		view.addObject("lis", js);
		view.addObject("location", customModel.getCustomerLocation());
		view.setViewName("searchResults");
		return view;
	}

	// raising a service request
	@RequestMapping(value = "/request")
	public ModelAndView request(@RequestParam("technicianName") String technician) throws ParseException {
		ModelAndView view = new ModelAndView();
		List<TechnicianModel> js = technicianService.searchTechnicianService(techModel.getTechnicianLocation(),
				techModel.getTechnicianSkill(), Integer.parseInt(techModel.getTechnicianPay()));
		String string = "Request successful." + " " + "Mr/Ms. " + technician + " " + "will contact you soon";
		view.addObject("alert", string);
		view.addObject("lis", js);
		view.addObject("location", customModel.getCustomerLocation());
		view.setViewName("searchResults");
		return view;
	}

}