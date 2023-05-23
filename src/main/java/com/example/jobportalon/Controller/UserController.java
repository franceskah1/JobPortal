package com.example.jobportalon.Controller;
import com.example.jobportalon.DTO.UserDTO;
import com.example.jobportalon.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void saveOrUpdate(@RequestBody UserDTO usersDTO){
        userService.saveOrUpdate(usersDTO);
    }
@GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id")String id){
        return userService.getUserById(id);
}

@GetMapping
    public List<UserDTO>findAll(){
        return userService.findAllUsers();
}

@DeleteMapping("/{id}")
    public void  deleteUserById(@PathVariable("id")String id){
         userService.deleteUserById(id);
}


}
