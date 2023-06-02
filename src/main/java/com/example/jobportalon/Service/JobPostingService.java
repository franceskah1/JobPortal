package com.example.jobportalon.Service;
import com.example.jobportalon.DTO.JobPostingsDTO;
import com.example.jobportalon.Converter.JobPostingsDTOtoJobPostings;
import com.example.jobportalon.Converter.JobPostingsToJobPostingsDTO;
import com.example.jobportalon.Exception.NotFoundException;
import com.example.jobportalon.Repository.JobPostingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobPostingService {
    private final JobPostingsDTOtoJobPostings jobPostingsDTOtoJobPostings;
    private final JobPostingsToJobPostingsDTO jobPostingsToJobPostingsDTO;
    private final JobPostingRepo jobPostingRepo;

//get All JobPostings

 public List<JobPostingsDTO>getAll(){
        return jobPostingRepo.findAll().stream().map(jobPostingsToJobPostingsDTO::convert).collect(Collectors.toList());
    }



public JobPostingsDTO getById(Long id){
    return jobPostingsToJobPostingsDTO.convert(jobPostingRepo.findById(id).get());
}
// get job posting by keyword
public JobPostingsDTO findByLocation(String jobLocation){
     return jobPostingsToJobPostingsDTO.convert(jobPostingRepo.getJobPostingsByJobLocation(jobLocation).orElseThrow(()->new NotFoundException("Please select another location!")));
}

public JobPostingsDTO saveJobPosting(JobPostingsDTO jobPostingsDTO){
    return jobPostingsToJobPostingsDTO.convert(jobPostingRepo.save(Objects.requireNonNull(jobPostingsDTOtoJobPostings.convert(jobPostingsDTO))));
}

}
