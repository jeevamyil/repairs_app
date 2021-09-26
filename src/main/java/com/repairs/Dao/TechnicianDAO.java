package com.repairs.Dao;

import java.util.List;

import com.repairs.model.TechnicianModel;

public interface TechnicianDAO {

	public List<TechnicianModel> technicianSearch(String location, String skill, int rate);

	public List<TechnicianModel> technicianSort(String location, String skill, int rate);

}
