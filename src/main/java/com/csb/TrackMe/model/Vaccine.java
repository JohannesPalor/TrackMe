package com.csb.TrackMe.model;

import com.csb.TrackMe.dto.VaccineDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String vaccineName;

    @Column(nullable = false)
    private String vaccineDisease;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private Long doseNumber;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column
    @UpdateTimestamp
    private LocalDateTime dateUpdated;



    public Vaccine(){
    }

    public Vaccine(VaccineDTO vaccineDTO) {
        this.id = vaccineDTO.getId();
        this.vaccineName = vaccineDTO.getVaccineName();
        this.vaccineDisease = vaccineDTO.getVaccineDisease();
        this.manufacturer = vaccineDTO.getManufacturer();
        this.doseNumber = vaccineDTO.getDoseNumber();
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
