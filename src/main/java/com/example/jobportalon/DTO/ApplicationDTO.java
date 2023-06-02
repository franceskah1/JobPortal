package com.example.jobportalon.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class ApplicationDTO {

    private Long id;

    private LocalDate application_date;

    private Long jobSeekerId;

    private Long jobPostingsId;

    private String application_status;

    private MultipartFile resume;


    private byte[] byteResume;



}
