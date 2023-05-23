package com.example.jobportalon.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {


    private  Long id;

    private String username;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String address;

    private String city;

    private String State;

    private String password;


    private boolean enabled;

   private Set<RoleDTO> role;
}
