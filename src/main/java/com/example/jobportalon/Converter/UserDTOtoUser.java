package com.example.jobportalon.Converter;
import com.example.jobportalon.DTO.UserDTO;
import com.example.jobportalon.Entity.User;
import lombok.AllArgsConstructor;

import org.springframework.core.convert.converter.Converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserDTOtoUser implements Converter<UserDTO, User> {
    private final RoleDTOtoRole roleDTOtoRole;
   private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User convert(UserDTO source) {
        if (source != null) {
            User user = new User();
            if (source.getId() != null) {
                user.setId(source.getId());
            }
            user.setPassword(bCryptPasswordEncoder.encode(source.getPassword()));

            user.setUsername(source.getUsername());
            user.setEmail(source.getEmail());
            user.setEnabled(user.isEnabled());
            if (source.getRole() != null)
                user.setRoles(source.getRole().stream().map(roleDTO -> roleDTOtoRole.convert(roleDTO)).collect(Collectors.toSet()));
            return user;
        }
        return null;
    }
}