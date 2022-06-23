package com.app.hpx.testlabs.integrator.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateCustomerRequest {

    @NotBlank(message = "Customer's First-name is mandatory!")
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotBlank(message = "Customer's Last-name is mandatory!")
    @JsonProperty(value = "last_name")
    private String lastName;

    @Email(message = "Customer's Email-address format is invalid!")
    @JsonProperty(value = "email_address")
    private String emailAddress;

    @JsonProperty(value = "contact_number")
    private String contactNumber;

    public CreateCustomerRequest() {
    }

    public CreateCustomerRequest(String firstName, String lastName, String emailAddress, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
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
}
