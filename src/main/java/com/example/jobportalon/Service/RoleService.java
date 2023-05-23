package com.example.jobportalon.Service;
import com.example.jobportalon.Converter.RoleToRoleDTO;
import com.example.jobportalon.DTO.RoleDTO;
import com.example.jobportalon.Repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleToRoleDTO roleToRoleDTO;
    private final RoleRepo roleRepo;

    public List<RoleDTO>findAll(){
        return roleRepo.findAll().stream().map(role -> roleToRoleDTO.convert(role)).collect(Collectors.toList());
    }

public RoleDTO findByName(String name){
        return roleToRoleDTO.convert(roleRepo.findByName(name));
}

}
