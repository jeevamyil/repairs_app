package com.repairs.model;


public class CustomerModel {
	
	
	private String customerName;
	private String customerLocation;
	private String customerPhone;

	public CustomerModel() {
		super();
	}

	public CustomerModel(String customerName, String customerLocation, String customerPhone) {
		super();
		this.customerName = customerName;
		this.customerLocation = customerLocation;
		this.customerPhone = customerPhone;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLocation() {
		return customerLocation;
	}

	public void setCustomerLocation(String customerLocation) {
		this.customerLocation = customerLocation;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Override
	public String toString() {
		return "CustomerModel [customerName=" + customerName + ", customerLocation=" + customerLocation
				+ ", customerPhone=" + customerPhone + "]";
	}

}
