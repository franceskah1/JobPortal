package com.example.jobportalon.Converter;

import com.example.jobportalon.DTO.UserDTO;
import com.example.jobportalon.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component

public class UserToUserDTO implements Converter<User, UserDTO> {

    private final RoleToRoleDTO toRoleDTO;
    @Override
    public UserDTO convert(User source) {
        if(source!=null){
            UserDTO userDTO=new UserDTO();
            userDTO.setId(source.getId());
            userDTO.setUsername(source.getUsername());
            userDTO.setLastName(source.getLastName());
            userDTO.setEmail(source.getEmail());
            userDTO.setPhoneNumber(source.getPhoneNumber());
            userDTO.setCity(source.getCity());
            userDTO.setState(source.getState());
            userDTO.setAddress(source.getAddress());
            userDTO.setEnabled(source.isEnabled());
            userDTO.setRole(source.getRoles()!=null ? source.getRoles().stream().map(toRoleDTO::convert).collect(Collectors.toSet()) : null);
            return userDTO;
        }
        return null;
    }
}
