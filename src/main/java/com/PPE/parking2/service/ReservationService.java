package com.PPE.parking2.service;

import com.PPE.parking2.entity.ReservationEntity;
import com.PPE.parking2.entity.UserEntity;

import java.util.List;

public interface ReservationService {

    public ReservationEntity create(String id);

    public List<ReservationEntity> getAllReservations();
}
