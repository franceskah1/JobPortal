package com.example.jobportalon.Service;

import com.example.jobportalon.Converter.UserDTOtoUser;
import com.example.jobportalon.DTO.UserDTO;
import com.example.jobportalon.Entity.User;
import com.example.jobportalon.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDTOtoUser userDTOtoUser;
    private final UserRepo userRepo;

   public void  saveOrUpdate(UserDTO userDTO){
       User users = userRepo.save(Objects.requireNonNull(userDTOtoUser.convert(userDTO)));
   }
}
