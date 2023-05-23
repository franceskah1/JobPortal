package com.example.jobportalon.Service;

import com.example.jobportalon.Converter.UserDTOtoUser;
import com.example.jobportalon.Converter.UserToUserDTO;
import com.example.jobportalon.DTO.UserDTO;
import com.example.jobportalon.Entity.User;
import com.example.jobportalon.Exception.NotFoundException;
import com.example.jobportalon.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDTOtoUser userDTOtoUser;

    private final UserToUserDTO userToUserDTO;
    private final UserRepo userRepo;

   public void  saveOrUpdate(UserDTO userDTO){
       User users = userRepo.save(Objects.requireNonNull(userDTOtoUser.convert(userDTO)));
   }


   public UserDTO getUserById(String id){
       long parseId;
       try {
           parseId = Long.parseLong(id);
       }
       catch (NumberFormatException e){
           throw new NumberFormatException("This id:"+ id + "can't be parsed!");

       }
       return userToUserDTO.convert(userRepo.findById(parseId).orElseThrow(()->new NotFoundException("User with id:"+ id + "not found")));
   }


   public List<UserDTO>findAllUsers(){
       return userRepo.findAll().stream().map(userToUserDTO::convert).collect(Collectors.toList());
   }


   public void deleteUserById(String id){
       long parseId;
   try {
       parseId=Long.parseLong(id);
       userRepo.deleteById(parseId);
   }catch (NumberFormatException e ){
       throw new NumberFormatException("This id:"+ id + "can't be parsed!");
   }catch (NotFoundException e){
       throw new NotFoundException("User with this id :" + id + "not found!");
   }
   }
}
