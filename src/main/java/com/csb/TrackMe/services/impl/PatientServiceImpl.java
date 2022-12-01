package com.csb.TrackMe.services.impl;

import com.csb.TrackMe.dto.PatientDTO;
import com.csb.TrackMe.model.Patient;
import com.csb.TrackMe.repository.PatientRepository;
import com.csb.TrackMe.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<PatientDTO> list() {
        return StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .map(PatientDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(PatientDTO patientDTO) { patientRepository.save(new Patient(patientDTO));
    }

    @Override
    public PatientDTO get(Long id) { return new PatientDTO(patientRepository.findById(id).get());
    }

    @Override
    public void update(PatientDTO patientDTO) {
        patientRepository.save(new Patient(patientDTO));
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
