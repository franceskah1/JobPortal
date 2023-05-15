package com.example.jobportalon.Converter;

import com.example.jobportalon.DTO.RoleDTO;
import com.example.jobportalon.Entity.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleDTOtoRole implements Converter<RoleDTO, Role> {
    @Override
    public Role convert(RoleDTO source) {
       if (source!=null){
           Role role=new Role();
           role.setName(source.getName());
           role.setId(source.getId());
           return role;
       }
        return null;
    }
}
