package com.PPE.parking2.service.impl;

import com.PPE.parking2.entity.PlaceEntity;
import com.PPE.parking2.entity.ReservationEntity;
import com.PPE.parking2.entity.UserEntity;
import com.PPE.parking2.repository.ReservationRepository;
import com.PPE.parking2.service.PlaceService;
import com.PPE.parking2.service.ReservationService;
import com.PPE.parking2.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;



@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    UserService userService;

    @Autowired
    PlaceService placeService;

    @Autowired
    ReservationRepository reservationRepository;

    public ReservationEntity create(String id) {
        UserEntity user = userService.getOneUser(id);

        List<PlaceEntity> placesLibres = placeService.getAllPlaces();

        if (placesLibres.isEmpty()) {
            //user.mettreEnAttente();
            return null;
        } else {
            Random rand = new Random();
            PlaceEntity placeLibre = placesLibres.get(rand.nextInt(placesLibres.size()));
            reservationRepository.save(new ReservationEntity(user, placeLibre));
            return null;
        }
    }
}
