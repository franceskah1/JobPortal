package com.example.jobportalon.Service;

import com.example.jobportalon.Converter.EmployerDTOtoEmployer;
import com.example.jobportalon.Converter.EmployerToEmployerDTO;
import com.example.jobportalon.DTO.EmployerDTO;
import com.example.jobportalon.Entity.Employers;
import com.example.jobportalon.Entity.User;
import com.example.jobportalon.Exception.NotFoundException;
import com.example.jobportalon.Repository.EmployerRepo;
import com.example.jobportalon.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerService {
    private final EmployerRepo employerRepo;

    private final UserRepo userRepo;
    private final EmployerDTOtoEmployer employerDTOtoEmployer;
    private final EmployerToEmployerDTO employerToEmployerDTO;

//TODO does not work
    public EmployerDTO saveUpdate(EmployerDTO employerDTO){
       return employerToEmployerDTO.convert(employerRepo.save(employerDTOtoEmployer.convert(employerDTO)));
    }

public Employers save(Employers employers){
        User userToAdd=userRepo.findById(employers.getUser().getId()).get();
        Employers employers1=new Employers();
        employers1.setUser(userToAdd);
        employers1.setCompanyDescription(employers.getCompanyDescription());
        employers1.setCompanyWebsite(employers.getCompanyWebsite());
        employers1.setCompanyName(employers.getCompanyName());
        employers1.setId(employers.getId());
        employerRepo.save(employers1);
        return employers1;
}


    public List<EmployerDTO>findAll(){
        return employerRepo.findAll().stream().map(employerToEmployerDTO::convert).collect(Collectors.toList());
    }



    public EmployerDTO findById(String id){
        long parseId;
        try {
            parseId=Long.parseLong(id);
        }catch (NumberFormatException e){
            throw  new NumberFormatException("This id:"+ id + " can't be parsed!");
        }
        return employerToEmployerDTO.convert(employerRepo.findById(parseId).orElseThrow(()->new NotFoundException("Employer with this id:"+ id + "not found!")));
    }


    public void deleteEmployerById(String id){
        long parseId;
        try {
            parseId=Long.parseLong(id);
            employerRepo.deleteById(parseId);
        }catch (NumberFormatException e){

            throw new NumberFormatException("This id:"+ id + "can't be parsed!");

        }catch (EmptyResultDataAccessException e){
            throw new NotFoundException("Employer with this id:"+ id + "not found!");
        }
    }
public Employers getEmployersById(Long id){
        return employerRepo.findById(id).orElseThrow(()->new NotFoundException("Employee with this id:"+ id + "does not found!"));
}
}
