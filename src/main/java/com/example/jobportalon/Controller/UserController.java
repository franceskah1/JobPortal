package com.example.jobportalon.Controller;

import com.example.jobportalon.DTO.UserDTO;
import com.example.jobportalon.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void saveOrUpdate(@RequestBody UserDTO usersDTO){
        userService.saveOrUpdate(usersDTO);
    }

}
