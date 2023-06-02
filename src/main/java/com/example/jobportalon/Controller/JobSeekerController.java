package com.example.jobportalon.Controller;

import com.example.jobportalon.DTO.JobSeekerDTO;
import com.example.jobportalon.Service.JobSeekerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jobSeeker")
public class JobSeekerController {
    private final JobSeekerService jobSeekerService;


        @GetMapping("/{id}")
         public JobSeekerDTO findById(@PathVariable("id") String id){
         return jobSeekerService.findById(id);

         }

     @GetMapping
     public List<JobSeekerDTO>findAll(){
         return jobSeekerService.findAllJobSeeker();
     }

     @PostMapping
     public JobSeekerDTO saveUpdate(@RequestBody JobSeekerDTO jobSeekerDTO){
         return jobSeekerService.saveUpdate(jobSeekerDTO);

     }
}
