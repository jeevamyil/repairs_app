package com.repairs.model;


public class TechnicianModel {

	private String technicianName;
	private String technicianRating;
	private String technicianSkill;
	private String technicianLocation;
	private String technicianPay;
	private String technicianAvailablity;

	public TechnicianModel() {
		super();
	}

	public TechnicianModel(String technicianName, String technicianRating, String technicianSkill,
			String technicianLocation, String technicianPay) {
		super();

		this.technicianName = technicianName;
		this.technicianRating = technicianRating;
		this.technicianSkill = technicianSkill;
		this.technicianLocation = technicianLocation;
		this.technicianPay = technicianPay;

	}

	public String getTechnicianName() {
		return technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}

	public String getTechnicianRating() {
		return technicianRating;
	}

	public void setTechnicianRating(String technicianRating) {
		this.technicianRating = technicianRating;
	}

	public String getTechnicianSkill() {
		return technicianSkill;
	}

	public void setTechnicianSkill(String technicianSkill) {
		this.technicianSkill = technicianSkill;
	}

	public String getTechnicianLocation() {
		return technicianLocation;
	}

	public void setTechnicianLocation(String technicianLocation) {
		this.technicianLocation = technicianLocation;
	}

	public String getTechnicianPay() {
		return technicianPay;
	}

	public void setTechnicianPay(String technicianPay) {
		this.technicianPay = technicianPay;
	}

	public String getTechnicianAvailablity() {
		return technicianAvailablity;
	}

	public void setTechnicianAvailablity(String technicianAvailablity) {
		this.technicianAvailablity = technicianAvailablity;
	}

	@Override
	public String toString() {
		return "TechnicianModel [technicianName=" + technicianName + ", technicianRating=" + technicianRating
				+ ", technicianSkill=" + technicianSkill + ", technicianLocation=" + technicianLocation
				+ ", technicianPay=" + technicianPay + ", technicianAvailablity=" + technicianAvailablity + "]";
	}

}
