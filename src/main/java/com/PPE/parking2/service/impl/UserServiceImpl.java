package com.PPE.parking2.service.impl;

import com.PPE.parking2.entity.UserEntity;
import com.PPE.parking2.entity.UserEntity;
import com.PPE.parking2.repository.UserRepository;
import com.PPE.parking2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        List<UserEntity> allUsersEntities = userRepository.findAll();
        return allUsersEntities;
    }

    public UserEntity getOneUser(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent())
            return user.get();
        else
            return null;
    }

    public UserEntity createUser(UserEntity user) {
        UserEntity newUser = userRepository.save(new UserEntity(user.getNom(), user.getPrenom(), user.getMail(),
                user.getTel(), user.getMdp(), user.isAdmin() ));
        return newUser;
    }

    public UserEntity updateUser(String id, UserEntity user) {
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
            return updatedUser;
        }
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
