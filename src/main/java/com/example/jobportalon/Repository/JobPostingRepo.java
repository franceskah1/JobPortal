package com.example.jobportalon.Repository;

import com.example.jobportalon.Entity.JobPostings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepo extends JpaRepository<JobPostings,Long>{
}
