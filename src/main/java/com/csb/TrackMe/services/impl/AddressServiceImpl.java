package com.csb.TrackMe.services.impl;

import com.csb.TrackMe.dto.AddressDTO;
import com.csb.TrackMe.model.Address;
import com.csb.TrackMe.repository.UserAddressRepository;
import com.csb.TrackMe.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    UserAddressRepository userAddressRepository;

    @Override
    public void add(AddressDTO address) {
        userAddressRepository.save(new Address(address));
    }

}
