package org.selenium.pom.objects;

public class BillingAddress {
	private String firstName;
	private String lastName;
	private String billingAddress1;
	private String billingCity;
	private String billingPostCode;
	private String email;
	private String country;
	private String state;

	public BillingAddress() {}
	
	public BillingAddress(String billingFirstName,String billingLastName,
			String billingAddress1,String billingCity,String billingPostcode, String billingEmail, String country, String state) {
		this.firstName = billingFirstName;
		this.lastName = billingLastName;
		this.billingAddress1 = billingAddress1;
		this.billingCity = billingCity;
		this.billingPostCode = billingPostcode;
		this.email = billingEmail;
		this.country = country;
		this.state = state;
	}
	
	public BillingAddress setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public BillingAddress setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getBillingAddress1() {
		return billingAddress1;
	}
	public BillingAddress setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
		return this;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public BillingAddress setBillingCity(String billingCity) {
		this.billingCity = billingCity;
		return this;
	}
	public String getBillingPostCode() {
		return billingPostCode;
	}
	public BillingAddress setBillingPostCode(String billingPostCode) {
		this.billingPostCode = billingPostCode;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public BillingAddress setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getCountry() {
		return country;
	}

	public BillingAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getState() {
		return state;
	}

	public BillingAddress setState(String state) {
		this.state = state;
		return this;
	}
}
