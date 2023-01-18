package com.PPE.parking2.repository;

import com.PPE.parking2.entity.PlaceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<PlaceEntity, String> {
}
