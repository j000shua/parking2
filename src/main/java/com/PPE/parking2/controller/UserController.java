package com.PPE.parking2.controller;

import com.PPE.parking2.model.User;
import com.PPE.parking2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PutMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try{
            User newUser = userRepository.save(new User(user.getNom(), user.getPrenom(), user.getMail(), user.getTel(),
                    user.getMdp(), user.isAdmin() ));
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
