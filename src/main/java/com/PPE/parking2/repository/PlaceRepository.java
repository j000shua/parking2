package com.PPE.parking2.repository;

import com.PPE.parking2.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<Place, String> {
}
