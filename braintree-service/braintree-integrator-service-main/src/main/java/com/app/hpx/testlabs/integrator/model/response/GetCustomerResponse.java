package com.app.hpx.testlabs.integrator.model.response;

public class GetCustomerResponse {

    private String id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String contactNumber;

    public GetCustomerResponse(String id, String firstName, String lastName,
        String emailAddress, String contactNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "GetCustomerResponse{" + "id='" + id + '\'' + ", firstName='" + firstName + '\'' + ", lastName='"
                   + lastName + '\'' + ", emailAddress='" + emailAddress + '\'' + ", contactNumber='" + contactNumber
                   + '\'' + '}';
    }
}
