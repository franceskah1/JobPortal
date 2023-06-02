package com.example.jobportalon.Controller;

import com.example.jobportalon.DTO.ApplicationDTO;
import com.example.jobportalon.Service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;


    @PostMapping
    private ApplicationDTO saveUpdate(@ModelAttribute ApplicationDTO applicationDTO){
        return applicationService.saveUpdate(applicationDTO);

    }

    @GetMapping
    private List<ApplicationDTO>findAll(){
        return applicationService.findAll();

    }

    @GetMapping("/{id}")
    private ApplicationDTO findBy(@PathVariable("id")Long id){
        return applicationService.findById(id);
    }
}
