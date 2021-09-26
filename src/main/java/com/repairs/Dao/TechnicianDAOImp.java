package com.repairs.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.repairs.model.TechnicianModel;
@Component
public class TechnicianDAOImp implements TechnicianDAO {

	Connection con = ConnectionHandler.getConnection();
	List<TechnicianModel> lis = new ArrayList<TechnicianModel>();
	List<TechnicianModel> list = new ArrayList<TechnicianModel>();

	public List<TechnicianModel> technicianSearch(String location, String skill, int rate) {
		// This method will retrieve the available technicians based on the input given

		String sql = "select technician_name,technician_rating,technician_pay from technician\r\n"
				+ "where location=? and services=? and technician_pay <=? and availablity='yes'\r\n"
				+ " order by technician_pay asc;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, location);
			ps.setString(2, skill);
			ps.setLong(3, rate);
			ResultSet q = ps.executeQuery();

			while (q.next()) {

				lis.add(new TechnicianModel(q.getString("technician_name"), q.getString("technician_rating"), skill,
						location, q.getString("technician_pay")));

			}

			List<TechnicianModel> copy = new ArrayList<>(lis);
			lis.clear();
			return copy;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<TechnicianModel> technicianSort(String location, String skill, int rate) {
		// This method will sort the technicians based on their rating

		String sql = "select technician_name,technician_rating,technician_pay from technician\r\n"
				+ "where location=? and services=? and technician_pay <=? and availablity='yes'\r\n"
				+ " order by technician_rating desc;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, location);
			ps.setString(2, skill);
			ps.setLong(3, rate);
			ResultSet qs = ps.executeQuery();
			System.out.println("fetched");

			while (qs.next()) {
				list.add(new TechnicianModel(qs.getString("technician_name"), qs.getString("technician_rating"), skill,
						location, qs.getString("technician_pay")));
				System.out.println(qs.getString("technician_name"));
			}

			List<TechnicianModel> copy1 = new ArrayList<>(list);
			list.clear();
			return copy1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
