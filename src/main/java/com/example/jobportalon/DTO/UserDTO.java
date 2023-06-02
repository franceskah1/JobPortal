package com.example.jobportalon.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {


    private  Long id;

    private String username;

    private String email;


    private String password;


    private boolean enabled;

   private Set<RoleDTO> role;
}
