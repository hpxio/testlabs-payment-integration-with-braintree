package com.app.hpx.testlabs.integrator.model;

public class CustomerDetailsModel {

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String contactNumber;

    private String createdTimestamp;

    private String updatedTimestamp;

    private String paymentMethodTypeIdentifier;

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

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(String updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getPaymentMethodTypeIdentifier() {
        return paymentMethodTypeIdentifier;
    }

    public void setPaymentMethodTypeIdentifier(String paymentMethodTypeIdentifier) {
        this.paymentMethodTypeIdentifier = paymentMethodTypeIdentifier;
    }

    @Override
    public String toString() {
        return "CustomerDetailsModel{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                   + ", emailAddress='" + emailAddress + '\'' + ", contactNumber='" + contactNumber + '\''
                   + ", createdTimestamp='" + createdTimestamp + '\'' + ", updatedTimestamp='" + updatedTimestamp + '\''
                   + ", paymentMethodTypeIdentifier='" + paymentMethodTypeIdentifier + '\'' + '}';
    }
}
