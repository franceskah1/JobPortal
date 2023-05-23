package com.example.jobportalon.Converter;

import com.example.jobportalon.DTO.EmployerDTO;
import com.example.jobportalon.Entity.Employers;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployerToEmployerDTO implements Converter<Employers, EmployerDTO> {

    @Override
    public EmployerDTO convert(Employers source) {
        if(source!=null){
            EmployerDTO employerDTO=new EmployerDTO();
            employerDTO.setId(source.getId());
            employerDTO.setCompanyName(source.getCompanyName());
            employerDTO.setCompanyDescription(source.getCompanyDescription());
            employerDTO.setCompanyWebsite(source.getCompanyWebsite());
            employerDTO.setUserId(source.getUser().getId());
            return employerDTO;
        }
        return null;
    }
}
