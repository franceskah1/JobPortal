package com.example.jobportalon.DTO;

import lombok.Data;

@Data
public class EmployerDTO {
    private Long id;

    private String companyName;

    private String companyWebsite;

    private String companyDescription;

    Long userId;


  // private UserDTO userDTO;
}
