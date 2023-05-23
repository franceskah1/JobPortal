package com.example.jobportalon.DTO;

import com.example.jobportalon.Converter.EmployerDTOtoEmployer;
import com.example.jobportalon.Entity.JobPostings;
import com.example.jobportalon.Utils.JobTypeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobPostingsDTOtoJobPostings implements Converter<JobPostingsDTO , JobPostings> {

    private final EmployerDTOtoEmployer employerDTOtoEmployer;

    @Override
    public JobPostings convert(JobPostingsDTO source) {
        if(source!=null){
            JobPostings jobPostings=new JobPostings();

            jobPostings.setId(source.getId());
            jobPostings.setJobDescription(source.getJobDescription());
            jobPostings.setJobLocation(source.getJobLocation());
            jobPostings.setJobTitle(source.getJobTitle());
            jobPostings.setJobPostDate(source.getJobPostDate());
            jobPostings.setActive(source.isActive());
            jobPostings.setSalaryRangeEnd(source.getSalaryRangeEnd());
            jobPostings.setSalaryRangeStart(source.getSalaryRangeStart());
            jobPostings.setJobExpiryDate(source.getJobExpiryDate());
            jobPostings.setEmployers(employerDTOtoEmployer.convert(source.getEmployerDTO()));
            jobPostings.setJobType(JobTypeUtils.getJobType(source.getJobType()));
            return jobPostings;

        }
        return null;
    }
}
