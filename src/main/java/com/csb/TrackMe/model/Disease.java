package com.csb.TrackMe.model;

import com.csb.TrackMe.dto.DiseaseDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String disease;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String symptoms;

    @Column(nullable = false)
    private String transmission;

    @Column(nullable = false)
    private String vaccineAvailability;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column
    @UpdateTimestamp
    private LocalDateTime dateUpdated;


    public Disease(){
    }

    public Disease(DiseaseDTO diseaseDTO) {
        this.id = diseaseDTO.getId();
        this.disease = diseaseDTO.getDisease();
        this.description = diseaseDTO.getDescription();
        this.symptoms = diseaseDTO.getSymptoms();
        this.transmission = diseaseDTO.getTransmission();
        this.vaccineAvailability = diseaseDTO.getVaccineAvailability();
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getVaccineAvailability() {
        return vaccineAvailability;
    }

    public void setVaccineAvailability(String vaccineAvailability) {
        this.vaccineAvailability = vaccineAvailability;
    }
}
