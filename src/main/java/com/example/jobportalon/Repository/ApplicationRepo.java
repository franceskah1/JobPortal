package com.example.jobportalon.Repository;

import com.example.jobportalon.Entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends JpaRepository<Applications,Long> {
}
