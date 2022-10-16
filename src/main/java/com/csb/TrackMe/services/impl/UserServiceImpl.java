package com.csb.TrackMe.services.impl;

import com.csb.TrackMe.dto.UserDTO;
import com.csb.TrackMe.model.User;
import com.csb.TrackMe.repository.RoleRepository;
import com.csb.TrackMe.repository.UserRepository;
import com.csb.TrackMe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(UserDTO userDTO) {
        User user = new User(userDTO);
        user.setRole(roleRepository.findByName(userDTO.getRole()));
        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDTO get(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }

    @Override
    public void update(UserDTO updatedUser) {
        User user = new User(updatedUser);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO validateUser(String emailAddress, String password) throws UsernameNotFoundException {
        User user = userRepository.findByEmailAddress(emailAddress);

        if (passwordEncoder.matches(password, user.getPasswordHash())) {
            return new UserDTO(user);
        } else {
            return null;
        }

    }

    @Override
    public void updatePassword(UserDTO user) {
        User updatedUser = userRepository.findByEmailAddress(user.getEmailAddress());
        updatedUser.setPasswordHash(passwordEncoder.encode(user.getPassword()));

        userRepository.save(updatedUser);
    }

}
