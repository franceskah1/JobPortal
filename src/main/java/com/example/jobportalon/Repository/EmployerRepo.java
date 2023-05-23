package com.example.jobportalon.Repository;

import com.example.jobportalon.Entity.Employers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<Employers,Long> {
}
