package com.csb.TrackMe.services.impl;

import com.csb.TrackMe.dto.DiseaseDTO;
import com.csb.TrackMe.model.Disease;
import com.csb.TrackMe.repository.DiseaseRepository;
import com.csb.TrackMe.services.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public List<DiseaseDTO> list() {
        return StreamSupport.stream(diseaseRepository.findAll().spliterator(), false)
                .map(DiseaseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(DiseaseDTO diseaseDTO) { diseaseRepository.save(new Disease(diseaseDTO));
    }

    @Override
    public DiseaseDTO get(Long id) { return new DiseaseDTO(diseaseRepository.findById(id).get());
    }

    @Override
    public void update(DiseaseDTO diseaseDTO) {
        diseaseRepository.save(new Disease(diseaseDTO));
    }

    @Override
    public void delete(Long id) {
        diseaseRepository.deleteById(id);
    }
}
