package com.csb.TrackMe.dto;

import com.csb.TrackMe.model.Patient;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class PatientDTO {

    private Long id;

    @NotBlank(message = "Required")
    private String firstName;

    @NotBlank(message = "Required")
    private String lastName;

    @PositiveOrZero(message = "Required")
    private Long age;

    @NotBlank(message = "Required")
    private String symptoms;

    @NotBlank(message = "Required")
    private String travelHistory;

    @PositiveOrZero(message = "Required")
    private Long contactNo;

    @NotBlank(message = "Required")
    private String address;


    public PatientDTO(){
    }

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.age = patient.getAge();
        this.symptoms = patient.getSymptoms();
        this.travelHistory = patient.getTravelHistory();
        this.contactNo = patient.getContactNo();
        this.address = patient.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(String travelHistory) {
        this.travelHistory = travelHistory;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
