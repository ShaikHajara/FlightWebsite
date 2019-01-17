package com.automate.flight.registerpage;

public class RegisterPageSetGetValues {

	public String firstName;
	public String lastName;
	public String city;
	public String state;
	public int phone;
	public int postalCode;
	public String username;
	public String password;
	public String confirmPassword;
	private String address1;
	private String address2;
	private String email;

	public RegisterPageSetGetValues() {
		super();
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public int getPhone() {
		return phone;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getState() {
		return state;
	}

	public String getUsername() {
		return username;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "RegisterPageSetGetValues [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", state=" + state + ", phone=" + phone + ", postalCode=" + postalCode + ", username=" + username
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", address1=" + address1
				+ ", address2=" + address2 + ", email=" + email + "]";
	}

}
