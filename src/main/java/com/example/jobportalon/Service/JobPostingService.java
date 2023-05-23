package com.example.jobportalon.Service;
import com.example.jobportalon.DTO.JobPostingsDTO;
import com.example.jobportalon.DTO.JobPostingsDTOtoJobPostings;
import com.example.jobportalon.DTO.JobPostingsToJobPostingsDTO;
import com.example.jobportalon.Repository.JobPostingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobPostingService {
    private final JobPostingsDTOtoJobPostings jobPostingsDTOtoJobPostings;
    private final JobPostingsToJobPostingsDTO jobPostingsToJobPostingsDTO;
    private final JobPostingRepo jobPostingRepo;

//get all jobpostings

 public List<JobPostingsDTO>getAll(){
        return jobPostingRepo.findAll().stream().map(jobPostingsToJobPostingsDTO::convert).collect(Collectors.toList());
    }



public JobPostingsDTO getById(Long id){
    return jobPostingsToJobPostingsDTO.convert(jobPostingRepo.findById(id).get());
}



public JobPostingsDTO saveJobPosting(JobPostingsDTO jobPostingsDTO){
    return jobPostingsToJobPostingsDTO.convert(jobPostingRepo.save(jobPostingsDTOtoJobPostings.convert(jobPostingsDTO)));
}

}
