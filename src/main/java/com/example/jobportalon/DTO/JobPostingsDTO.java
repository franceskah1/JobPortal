package com.example.jobportalon.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class JobPostingsDTO {


     private Long id;

    private String jobTitle;

    private String jobDescription;


    private  String jobLocation;


    private double salaryRangeStart;


    private double salaryRangeEnd;


    private LocalDateTime jobPostDate;


    private LocalDate jobExpiryDate;


    private boolean isActive;


    private String  jobType;


    private EmployerDTO employerDTO;



}
