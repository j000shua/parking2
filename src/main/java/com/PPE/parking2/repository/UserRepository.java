package com.PPE.parking2.repository;

import com.PPE.parking2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// A quoi correspondent les classes entre les <> apres MongoRepository ?
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByNom(String nom);
    List<User> findByAdmin(boolean admin);
}
