package com.PPE.parking2.repository;

import com.PPE.parking2.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// A quoi correspondent les classes entre les <> apres MongoRepository ?
public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByNom(String nom);
    List<UserEntity> findByAdmin(boolean admin);
}
