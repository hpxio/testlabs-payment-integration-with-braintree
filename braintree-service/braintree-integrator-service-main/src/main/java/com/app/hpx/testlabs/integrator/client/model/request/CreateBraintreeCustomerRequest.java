package com.app.hpx.testlabs.integrator.client.model.request;

public class CreateBraintreeCustomerRequest {
	private String firstName;
	private String lastName;
	private String contact;
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CreateBraintreeCustomerRequest{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", contact='" + contact + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}