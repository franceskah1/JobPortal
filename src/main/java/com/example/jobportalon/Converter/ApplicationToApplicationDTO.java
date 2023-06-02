package com.example.jobportalon.Converter;
import com.example.jobportalon.DTO.ApplicationDTO;
import com.example.jobportalon.Entity.Applications;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationToApplicationDTO implements Converter<Applications,ApplicationDTO> {


    @Override
    public ApplicationDTO convert(Applications source) {
        if (source != null) {
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setApplication_date(source.getApplication_date());
            applicationDTO.setApplication_status(source.getApplication_status().name());
            applicationDTO.setId(source.getId());
            applicationDTO.setJobSeekerId(source.getJobSeekers().getId());
            applicationDTO.setJobPostingsId(source.getJobPostings().getId());
            applicationDTO.setByteResume(source.getResume());

        }
        return null;
    }
}