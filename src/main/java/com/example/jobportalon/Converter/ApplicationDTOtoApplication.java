package com.example.jobportalon.Converter;
import com.example.jobportalon.DTO.ApplicationDTO;
import com.example.jobportalon.Entity.Applications;
import com.example.jobportalon.Repository.JobPostingRepo;
import com.example.jobportalon.Repository.JobSeekerRepo;
import com.example.jobportalon.Utils.ApplicationStatusUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class ApplicationDTOtoApplication implements Converter<ApplicationDTO, Applications> {
    private final JobSeekerRepo jobSeekerRepo;
    private final JobPostingRepo jobPostingRepo;

    @Override
    public Applications convert(ApplicationDTO source) {
        if (source != null) {
            Applications applications = new Applications();
            applications.setId(source.getId());
            applications.setApplication_status(ApplicationStatusUtils.getApplication_status(source.getApplication_status()));
            applications.setApplication_date(source.getApplication_date());
            applications.setJobSeekers(jobSeekerRepo.findById(source.getJobSeekerId()).get());
            applications.setJobPostings(jobPostingRepo.findById(source.getJobPostingsId()).get());
            try {
                applications.setResume(source.getResume().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return applications;
        }

        return null;
    }
}