package com.csb.TrackMe.dto;

import com.csb.TrackMe.model.Disease;

import javax.validation.constraints.NotBlank;


public class DiseaseDTO {

    private Long id;

    @NotBlank(message = "Disease is required")
    private String disease;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Symptoms is required")
    private String symptoms;

    @NotBlank(message = "Transmission is required")
    private String transmission;

    @NotBlank(message = "Availability of vaccine is required")
    private String vaccineAvailability;

    public DiseaseDTO(){
    }

    public DiseaseDTO(Disease disease) {
        this.id = disease.getId();
        this.disease = disease.getDisease();
        this.description = disease.getDescription();
        this.symptoms = disease.getSymptoms();
        this.transmission = disease.getTransmission();
        this.vaccineAvailability = disease.getVaccineAvailability();
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
