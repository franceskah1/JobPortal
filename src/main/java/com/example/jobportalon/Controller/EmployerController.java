package com.example.jobportalon.Controller;

import com.example.jobportalon.DTO.EmployerDTO;
import com.example.jobportalon.Service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employer")
public class EmployerController {
    private final EmployerService employerService;




    @PostMapping
    public EmployerDTO saveUpdate(@RequestBody EmployerDTO employerDTO){
     return    employerService.saveUpdate(employerDTO);
    }

    @GetMapping("/{id}")
    public EmployerDTO getById(@PathVariable("id")String id){
        return employerService.findById(id);
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
