package com.example.jobportalon.Repository;

import com.example.jobportalon.Entity.JobSeekers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepo extends JpaRepository<JobSeekers,Long> {
}
