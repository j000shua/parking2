package com.PPE.parking2.service;

import com.PPE.parking2.dto.UserDto;
import com.PPE.parking2.entity.UserEntity;
import com.PPE.parking2.repository.UserRepository;

import java.util.List;

public interface UserService {

    public List<UserDto> getAllUsers();

    public UserDto getOneUser(String id);

    public UserDto createUser(UserEntity user);

    public UserDto updateUser(String id, UserEntity user);

    public void deleteUser(String id);
}
