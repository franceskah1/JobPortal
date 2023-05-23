package com.example.jobportalon.Converter;
import com.example.jobportalon.DTO.EmployerDTO;
import com.example.jobportalon.Entity.Employers;
import com.example.jobportalon.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployerDTOtoEmployer implements Converter<EmployerDTO, Employers> {
    private final UserRepo userRepo;



    @Override
    public Employers convert(EmployerDTO source) {
        if (source != null) {
            Employers employers = new Employers();
        //   if (source.getId() != null) {
                employers.setId(source.getId());
                employers.setCompanyName(source.getCompanyName());
                employers.setCompanyDescription(source.getCompanyDescription());
                employers.setCompanyWebsite(source.getCompanyWebsite());
                employers.setUser(source.getUserId() == null ? null: userRepo.findById(source.getUserId()).get());
              //    employers.setUser(userDTOtoUser.convert(source.getUserDTO()));
                return employers;
            }
       // }
        return null;
    }
}