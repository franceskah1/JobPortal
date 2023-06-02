package com.example.jobportalon.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekers extends BaseEntity{

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private LocalDate dateOfBirth;

    private String skills;

    private String education;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;




}
