package com.example.jobportalon.Controller;
import com.example.jobportalon.DTO.RoleDTO;
import com.example.jobportalon.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;


    @GetMapping
    public List<RoleDTO>findAll(){
        return roleService.findAll();

    }

}
