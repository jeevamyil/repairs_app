package com.repairs.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repairs.Dao.TechnicianDAO;
import com.repairs.Dao.TechnicianDAOImp;

import com.repairs.model.TechnicianModel;

@Service
public class TechnicianService {
	//private TechnicianDAO techDAO = new TechnicianDAOImp();
	@Autowired
	private TechnicianDAO techDAO;
		public List<TechnicianModel> searchTechnicianService(String a, String b, int c) throws ParseException {
			return techDAO.technicianSearch(a,b,c);
		}
		public List<TechnicianModel> sortTechnicianService(String a, String b, int c) throws ParseException {
			return techDAO.technicianSort(a,b,c);
		

}
}
