package com.example.jobportalon.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data

public class JobSeekerDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private LocalDate dateOfBirth;

    private String skills;

    private String education;

    private Long userId;


}
