package com.PPE.parking2.repository;

import com.PPE.parking2.entity.ReservationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<ReservationEntity, String> {
}
