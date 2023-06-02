package com.example.jobportalon.Controller;

import com.example.jobportalon.DTO.JobPostingsDTO;
import com.example.jobportalon.Service.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jobPosting")
public class JobPostingController {
    private final JobPostingService jobPostingService;

    @PostMapping

    public JobPostingsDTO saveUpdate(@RequestBody JobPostingsDTO jobPostingsDTO){
        return jobPostingService.saveJobPosting(jobPostingsDTO);
    }

@GetMapping("/{id}")
public JobPostingsDTO findById( @PathVariable("id") Long id){
return jobPostingService.getById(id);

   }
@GetMapping("/getBy/{jobLocation}")
public JobPostingsDTO findByLocation(@PathVariable("jobLocation")String jobLocation){
        return jobPostingService.findByLocation(jobLocation);

}

@GetMapping
public List<JobPostingsDTO>findAll(){
return jobPostingService.getAll();
   }
}
