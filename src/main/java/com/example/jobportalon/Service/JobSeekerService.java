package com.example.jobportalon.Service;
import com.example.jobportalon.Converter.JobSeekerDTOtoJobSeeker;
import com.example.jobportalon.Converter.JobSeekerToJobSeekerDTO;
import com.example.jobportalon.DTO.JobSeekerDTO;
import com.example.jobportalon.Exception.NotFoundException;
import com.example.jobportalon.Repository.JobSeekerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobSeekerService {

    private final JobSeekerRepo jobSeekerRepo;
    private final JobSeekerDTOtoJobSeeker jobSeeker;
    private final JobSeekerToJobSeekerDTO toJobSeekerDTO;

    public List<JobSeekerDTO> findAllJobSeeker(){
        return jobSeekerRepo.findAll().stream().map(jobSeekers -> toJobSeekerDTO.convert(jobSeekers)).collect(Collectors.toList());
    }

    public JobSeekerDTO findById(String id){
        long parseId;
        try {
            parseId=Long.parseLong(id);

        }catch (NumberFormatException exception){
            throw new NotFoundException("This id:"+ id + "can't be parsed!");
        }
      return   toJobSeekerDTO.convert(jobSeekerRepo.findById(parseId).orElseThrow(()->new NotFoundException("JobSeeker with this id:"+ id + "not found!")));
    }


    public JobSeekerDTO saveUpdate(JobSeekerDTO jobSeekerDTO){
       return toJobSeekerDTO.convert(jobSeekerRepo.save(jobSeeker.convert(jobSeekerDTO)));
}

}
