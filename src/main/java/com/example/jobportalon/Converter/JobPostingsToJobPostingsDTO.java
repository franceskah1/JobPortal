package com.example.jobportalon.Converter;

import com.example.jobportalon.Converter.EmployerToEmployerDTO;
import com.example.jobportalon.DTO.JobPostingsDTO;
import com.example.jobportalon.Entity.JobPostings;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobPostingsToJobPostingsDTO implements Converter<JobPostings, JobPostingsDTO> {
 //   private final EmployerToEmployerDTO employerToEmployerDTO;


    @Override
    public JobPostingsDTO convert(JobPostings source) {
        if (source != null) {
            JobPostingsDTO jobPostingsDTO = new JobPostingsDTO();
            jobPostingsDTO.setId(source.getId());
            jobPostingsDTO.setActive(source.isActive());
            jobPostingsDTO.setJobDescription(source.getJobDescription());
            jobPostingsDTO.setJobExpiryDate(source.getJobExpiryDate());
            jobPostingsDTO.setJobLocation(source.getJobLocation());
            jobPostingsDTO.setJobPostDate(source.getJobPostDate());
            jobPostingsDTO.setJobTitle(source.getJobTitle());
            jobPostingsDTO.setJobType(source.getJobType().name());
            jobPostingsDTO.setSalaryRangeStart(source.getSalaryRangeStart());
            jobPostingsDTO.setSalaryRangeEnd(source.getSalaryRangeEnd());
            jobPostingsDTO.setJob_requirements(source.getJob_requirements());
            jobPostingsDTO.setEducation_required(source.getEducation_required());
            jobPostingsDTO.setEmployersId(source.getEmployers().getId());
         //   jobPostingsDTO.setEmployerDTO(employerToEmployerDTO.convert(source.getEmployers()));
            return jobPostingsDTO;

        }
        return null;
    }
}