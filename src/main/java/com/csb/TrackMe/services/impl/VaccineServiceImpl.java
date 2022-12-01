package com.csb.TrackMe.services.impl;



import com.csb.TrackMe.dto.VaccineDTO;
import com.csb.TrackMe.model.Vaccine;
import com.csb.TrackMe.repository.VaccineRepository;
import com.csb.TrackMe.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public List<VaccineDTO> list() {
        return StreamSupport.stream(vaccineRepository.findAll().spliterator(), false)
                .map(VaccineDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(VaccineDTO vaccineDTO) { vaccineRepository.save(new Vaccine(vaccineDTO));
    }

    @Override
    public VaccineDTO get(Long id) { return new VaccineDTO(vaccineRepository.findById(id).get());
    }

    @Override
    public void update(VaccineDTO vaccineDTO) {
        vaccineRepository.save(new Vaccine(vaccineDTO));
    }

    @Override
    public void delete(Long id) {
        vaccineRepository.deleteById(id);
    }
}
