package com.PPE.parking2.repository;

import com.PPE.parking2.entity.ReservationEntity;
import com.PPE.parking2.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReservationRepository extends MongoRepository<ReservationEntity, String> {
}
