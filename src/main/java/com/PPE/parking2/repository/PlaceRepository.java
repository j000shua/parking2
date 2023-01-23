package com.PPE.parking2.repository;

import com.PPE.parking2.entity.PlaceEntity;
import com.PPE.parking2.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlaceRepository extends MongoRepository<PlaceEntity, String> {

    List<PlaceEntity> findByTaken(boolean taken);
}
