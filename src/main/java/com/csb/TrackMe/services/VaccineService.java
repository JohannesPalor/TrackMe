package com.csb.TrackMe.services;

import com.csb.TrackMe.dto.VaccineDTO;

import java.util.List;

public interface VaccineService {

    List<VaccineDTO> list();

    void add(VaccineDTO vaccineDTO);

    VaccineDTO get(Long id);

    void update(VaccineDTO vaccineDTO);

    void delete(Long id);
}
