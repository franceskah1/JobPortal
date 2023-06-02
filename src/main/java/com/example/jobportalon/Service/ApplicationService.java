package com.example.jobportalon.Service;
import com.example.jobportalon.Converter.ApplicationDTOtoApplication;
import com.example.jobportalon.Converter.ApplicationToApplicationDTO;
import com.example.jobportalon.DTO.ApplicationDTO;
import com.example.jobportalon.Repository.ApplicationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplicationService {

    private  final ApplicationRepo applicationRepo;
    private final ApplicationDTOtoApplication applicationDTOtoApplication;
    private final  ApplicationToApplicationDTO applicationToApplicationDTO;



    public ApplicationDTO saveUpdate(ApplicationDTO applicationDTO){
        return applicationToApplicationDTO.convert(applicationRepo.save(Objects.requireNonNull(applicationDTOtoApplication.convert(applicationDTO))));
    }

    public ApplicationDTO findById(Long id){
        return applicationToApplicationDTO.convert(applicationRepo.findById(id).get());
    }

    public List<ApplicationDTO>findAll(){
        return applicationRepo.findAll().stream().map(applicationToApplicationDTO::convert).collect(Collectors.toList());
    }
}
