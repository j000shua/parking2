package com.PPE.parking2.service;

import com.PPE.parking2.model.User;
import com.PPE.parking2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

}
