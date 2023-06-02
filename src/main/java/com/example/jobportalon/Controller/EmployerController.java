package com.example.jobportalon.Controller;

import com.example.jobportalon.DTO.EmployerDTO;
import com.example.jobportalon.Entity.Employers;
import com.example.jobportalon.Service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployerController {
    private final EmployerService employerService;




    @PostMapping
    public EmployerDTO saveUpdate(@RequestBody EmployerDTO employerDTO){
     return    employerService.saveUpdate(employerDTO);
    }

    @GetMapping("/{id}")
    public Employers getById(@PathVariable("id")Long id){
       return employerService.getEmployersById(id);
    }


    @GetMapping
    public List<EmployerDTO>getAll(){
        return employerService.findAll();
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")String id){
        employerService.deleteEmployerById(id);
    }

}
