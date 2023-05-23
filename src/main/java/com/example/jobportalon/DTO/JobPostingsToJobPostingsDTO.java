package com.example.jobportalon.DTO;

import com.example.jobportalon.Converter.EmployerToEmployerDTO;
import com.example.jobportalon.Entity.JobPostings;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobPostingsToJobPostingsDTO implements Converter<JobPostings,JobPostingsDTO> {
    private final EmployerToEmployerDTO employerToEmployerDTO;


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
            jobPostingsDTO.setEmployerDTO(employerToEmployerDTO.convert(source.getEmployers()));
            return jobPostingsDTO;

        }
        return null;
    }
}