package com.example.jobportalon.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationDTO {


    private LocalDate application_date;

    private UserDTO userDTO;



}
