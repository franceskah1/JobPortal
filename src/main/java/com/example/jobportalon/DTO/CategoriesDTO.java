package com.example.jobportalon.DTO;

import lombok.Data;


import java.util.Set;
@Data

public class CategoriesDTO {

    private Long id;
    private String name;
    private Set<JobPostingsDTO>jobPostingsDTOS;
}
