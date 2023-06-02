package com.example.jobportalon.Converter;
import com.example.jobportalon.DTO.JobPostingsDTO;
import com.example.jobportalon.Entity.JobPostings;
import com.example.jobportalon.Repository.EmployerRepo;
import com.example.jobportalon.Utils.JobTypeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobPostingsDTOtoJobPostings implements Converter<JobPostingsDTO, JobPostings> {

    private final EmployerRepo employerRepo;

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
            jobPostings.setEducation_required(source.getEducation_required());
            jobPostings.setJob_requirements(source.getJob_requirements());
            jobPostings.setEmployers(employerRepo.findById(source.getEmployersId()).get());
           // jobPostings.setEmployers(source.getEmployersId() == null ? null: employerRepo.findById(source.getEmployersId()).get());
           // jobPostings.setEmployers(employerDTOtoEmployer.convert(source.getEmployerDTO()));
            jobPostings.setJobType(JobTypeUtils.getJobType(source.getJobType()));
            return jobPostings;

        }
        return null;
    }
}
