package com.csb.TrackMe.repository;

import com.csb.TrackMe.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepository extends CrudRepository<Address, Long> {
}
