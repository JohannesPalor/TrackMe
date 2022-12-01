package com.csb.TrackMe.repository;

import com.csb.TrackMe.model.Disease;
import org.springframework.data.repository.CrudRepository;

public interface DiseaseRepository extends CrudRepository<Disease, Long> {
}
