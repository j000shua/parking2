package com.PPE.parking2.service.impl;

import com.PPE.parking2.dto.UserDto;
import com.PPE.parking2.entity.UserEntity;
import com.PPE.parking2.repository.UserRepository;
import com.PPE.parking2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto map(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .mail(user.getMail())
                .tel(user.getTel())
                .mdp(user.getMdp())
                .admin(user.isAdmin())
                .build();
    }

    public List<UserDto> map (List<UserEntity> userEntities) {
        return userEntities.stream().map(user -> {
            return map(user);
                }
        ).collect(Collectors.toList());
    } //j'ai pas compris ce que j'ai fait la

    public List<UserDto> getAllUsers() {
        List<UserEntity> allUsersEntities = userRepository.findAll();
        return map(allUsersEntities);
    }

    public UserDto getOneUser(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent())
            return map(user.get());
        else
            return null;
    }

    public UserDto createUser(UserEntity user) {
        UserEntity newUser = userRepository.save(new UserEntity(user.getNom(), user.getPrenom(), user.getMail(),
                user.getTel(), user.getMdp(), user.isAdmin() ));
        return map(newUser);
    }

    public UserDto updateUser(String id, UserEntity user) {
        Optional<UserEntity> updatedUserOp = userRepository.findById(id);
        if (updatedUserOp.isEmpty())
            return null;
        else {
            UserEntity updatedUser = updatedUserOp.get();
            updatedUser.setNom(user.getNom());
            updatedUser.setPrenom(user.getPrenom());
            updatedUser.setMail(user.getMail());
            updatedUser.setTel(user.getTel());
            updatedUser.setMdp(user.getMdp());
            updatedUser.setAdmin(user.isAdmin());
            userRepository.save(updatedUser);
            return map(updatedUser);
        }
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
