package com.PPE.parking2.controller;

import com.PPE.parking2.model.User;
import com.PPE.parking2.repository.UserRepository;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @CrossOrigin
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try{
            List<User> allUsers = userRepository.findAll();

            if(allUsers.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(allUsers, HttpStatus.OK);

        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable("id") String id) {
        try{
            Optional<User> user = userRepository.findById(id);
            if(user.isPresent())
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
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

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        try {
            Optional<User> updatedUserOp = userRepository.findById(id);
            if (updatedUserOp.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            else {
                User updatedUser = updatedUserOp.get();
                updatedUser.setNom(user.getNom());
                updatedUser.setPrenom(user.getPrenom());
                updatedUser.setMail(user.getMail());
                updatedUser.setTel(user.getTel());
                updatedUser.setMdp(user.getMdp());
                updatedUser.setAdmin(user.isAdmin());
                return new ResponseEntity<>(userRepository.save(updatedUser), HttpStatus.OK);
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id ) {
        try{
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
