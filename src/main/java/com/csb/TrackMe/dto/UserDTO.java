package com.csb.TrackMe.dto;

import com.csb.TrackMe.model.User;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    @NotBlank(message = "Email Address is required")
    private String emailAddress;

    @NotBlank(message = "Password is required")
    private String password;

    private String forgotPassword;

    private String role;

    private Set<AddressDTO> addressList;

    public UserDTO() {}

    public UserDTO(Long id, String firstName, String lastName, String emailAddress, String role, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.role = role;
        this.password = password;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.emailAddress = user.getEmailAddress();
        this.role = user.getRole().getName();
        // Password is intentionally left out for security reasons.
        this.addressList = Optional.ofNullable(user.getAddressList())
                .orElseGet(Collections::emptySet)
                .stream()
                .map(AddressDTO::new)
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AddressDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<AddressDTO> addressList) {
        this.addressList = addressList;
    }

    public String getForgotPassword() {
        return forgotPassword;
    }

    public void setForgotPassword(String forgotPassword) {
        this.forgotPassword = forgotPassword;
    }
}
