package com.example.jobportalon.Repository;

import com.example.jobportalon.Entity.JobPostings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPostingRepo extends JpaRepository<JobPostings,Long>{

   Optional<JobPostings>  getJobPostingsByJobLocation(String jobLocation);
}
