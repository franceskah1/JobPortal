package com.example.jobportalon.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Applications extends BaseEntity {

   private LocalDate application_date;
   @Lob
   @Column(length = 2147483647)
   private byte[] resume;


   @ManyToOne
   @JoinColumn(name = "jobSeekers_id", referencedColumnName = "id")
   private JobSeekers jobSeekers;

   @ManyToOne
   @JoinColumn(name = "jobPostings_id", referencedColumnName = "id")
   private JobPostings jobPostings;

   @Enumerated(EnumType.STRING)
   Application_status application_status;

}