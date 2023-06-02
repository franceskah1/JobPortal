package com.example.jobportalon.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categories extends BaseEntity {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "job_categories",
            joinColumns = @JoinColumn(name = "categories_id"),
            inverseJoinColumns = @JoinColumn(name = "jobPostings_id", referencedColumnName = "id"))
    private Set<JobPostings> jobPostings;
}
