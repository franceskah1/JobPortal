package com.example.jobportalon.Converter;

import com.example.jobportalon.DTO.CategoriesDTO;
import com.example.jobportalon.Entity.Categories;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriesDTOtoCategories implements Converter<CategoriesDTO, Categories> {

    private final JobPostingsDTOtoJobPostings jobPostings;

    @Override
    public Categories convert(CategoriesDTO source) {
        return null;
    }
}
