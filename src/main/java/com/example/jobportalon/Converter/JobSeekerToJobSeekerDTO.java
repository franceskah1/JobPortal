package com.example.jobportalon.Converter;

import com.example.jobportalon.DTO.JobSeekerDTO;
import com.example.jobportalon.Entity.JobSeekers;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobSeekerToJobSeekerDTO implements Converter<JobSeekers, JobSeekerDTO> {

    @Override
    public JobSeekerDTO convert(JobSeekers source) {
        if (source!=null){
            JobSeekerDTO jobSeekerDTO=new JobSeekerDTO();
            jobSeekerDTO.setId(source.getId());
            jobSeekerDTO.setUserId(source.getUser().getId());
            jobSeekerDTO.setAddress(source.getAddress());
            jobSeekerDTO.setEducation(source.getEducation());
            jobSeekerDTO.setFirstName(source.getFirstName());
            jobSeekerDTO.setLastName(source.getLastName());
            jobSeekerDTO.setSkills(source.getSkills());
            jobSeekerDTO.setPhoneNumber(source.getPhoneNumber());
            jobSeekerDTO.setDateOfBirth(source.getDateOfBirth());
      return jobSeekerDTO;
        }
        return null;
    }
}
