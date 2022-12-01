package com.csb.TrackMe.dto;

import com.csb.TrackMe.model.Disease;
import com.csb.TrackMe.model.Vaccine;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class VaccineDTO {

    private Long id;

    @NotBlank(message = "Name of Vaccine is required")
    private String vaccineName;

    @NotBlank(message = "Description is required")
    private String vaccineDisease;

    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;

    @PositiveOrZero(message = "No. of dose must not be a negative number")
    private Long doseNumber;



    public VaccineDTO(){
    }

    public VaccineDTO(Vaccine vaccine) {
        this.id = vaccine.getId();
        this.vaccineName = vaccine.getVaccineName();
        this.vaccineDisease = vaccine.getVaccineDisease();
        this.manufacturer = vaccine.getManufacturer();
        this.doseNumber = vaccine.getDoseNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineDisease() {
        return vaccineDisease;
    }

    public void setVaccineDisease(String vaccineDisease) {
        this.vaccineDisease = vaccineDisease;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(Long doseNumber) {
        this.doseNumber = doseNumber;
    }
}
