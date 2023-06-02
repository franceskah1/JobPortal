package com.example.jobportalon.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class JobPostings extends BaseEntity{


    private String jobTitle;

    private String jobDescription;

    private  String jobLocation;

    private double salaryRangeStart;

    private double salaryRangeEnd;

   private LocalDate jobPostDate;

   private LocalDate jobExpiryDate;

   private boolean isActive;

   private String education_required;

   private String job_requirements;

   @Enumerated(EnumType.STRING)
    JobType jobType;


    @ManyToOne
    @JoinColumn(name = "employers_id", referencedColumnName = "id")
    private Employers employers;

}



