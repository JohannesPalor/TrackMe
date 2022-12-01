package com.csb.TrackMe.model;


import com.csb.TrackMe.dto.PatientDTO;
import com.csb.TrackMe.dto.VaccineDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false)
    private String symptoms;

    @Column(nullable = false)
    private String travelHistory;

    @Column(nullable = false)
    private Long contactNo;

    @Column(nullable = false)
    private String address;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column
    @UpdateTimestamp
    private LocalDateTime dateUpdated;



    public Patient(){
    }

    public Patient(PatientDTO patientDTO) {
        this.id = patientDTO.getId();
        this.firstName = patientDTO.getFirstName();
        this.lastName = patientDTO.getLastName();
        this.age = patientDTO.getAge();
        this.symptoms = patientDTO.getSymptoms();
        this.travelHistory = patientDTO.getTravelHistory();
        this.contactNo = patientDTO.getContactNo();
        this.address = patientDTO.getAddress();
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
