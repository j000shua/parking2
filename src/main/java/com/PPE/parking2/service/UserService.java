package com.PPE.parking2.service;


import com.PPE.parking2.entity.UserEntity;
import com.PPE.parking2.repository.UserRepository;

import java.util.List;

public interface UserService {

    public List<UserEntity> getAllUsers();

    public UserEntity getOneUser(String id);

    public UserEntity createUser(UserEntity user);

    public UserEntity updateUser(String id, UserEntity user);

    public void deleteUser(String id);
}
