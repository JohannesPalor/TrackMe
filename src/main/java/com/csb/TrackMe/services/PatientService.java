package com.csb.TrackMe.services;

import com.csb.TrackMe.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    List<PatientDTO> list();

    void add(PatientDTO patientDTO);

    PatientDTO get(Long id);

    void update(PatientDTO patientDTO);

    void delete(Long id);
}
