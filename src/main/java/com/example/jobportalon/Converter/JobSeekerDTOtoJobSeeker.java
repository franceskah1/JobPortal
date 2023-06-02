package com.example.jobportalon.Converter;

import com.example.jobportalon.DTO.JobSeekerDTO;
import com.example.jobportalon.Entity.JobSeekers;
import com.example.jobportalon.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class JobSeekerDTOtoJobSeeker implements Converter<JobSeekerDTO , JobSeekers> {
    private final UserRepo userRepo;

    @Override
    public JobSeekers convert(JobSeekerDTO source) {
        if (source != null) {
            JobSeekers jobSeekers = new JobSeekers();
            jobSeekers.setId(source.getId());
            jobSeekers.setFirstName(source.getFirstName());
            jobSeekers.setLastName(source.getLastName());
            jobSeekers.setAddress(source.getAddress());
            jobSeekers.setEducation(source.getEducation());
            jobSeekers.setSkills(source.getSkills());
            jobSeekers.setPhoneNumber(source.getPhoneNumber());
            jobSeekers.setDateOfBirth(source.getDateOfBirth());
            jobSeekers.setUser(userRepo.findById(source.getUserId()).get());
            return jobSeekers;

        }
        return null;
    }
}