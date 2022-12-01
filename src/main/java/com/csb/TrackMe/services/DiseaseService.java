package com.csb.TrackMe.services;

import com.csb.TrackMe.dto.DiseaseDTO;

import java.util.List;

public interface DiseaseService {

    List<DiseaseDTO> list();

    void add(DiseaseDTO diseaseDTO);

    DiseaseDTO get(Long id);

    void update(DiseaseDTO diseaseDTO);

    void delete(Long id);

}
