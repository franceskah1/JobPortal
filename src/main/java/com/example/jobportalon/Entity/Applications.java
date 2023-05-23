package com.example.jobportalon.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Applications extends BaseEntity{

private LocalDate application_date;


@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

@ManyToOne
@JoinColumn(name = "jobPostings_id", referencedColumnName = "id")
private JobPostings jobPostings;

@Enumerated(EnumType.STRING)
Application_status application_status;


}
