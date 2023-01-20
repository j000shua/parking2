package com.PPE.parking2.service.impl;

import com.PPE.parking2.dto.PlaceDto;
import com.PPE.parking2.dto.ReservationDto;
import com.PPE.parking2.dto.UserDto;
import com.PPE.parking2.entity.ReservationEntity;
import com.PPE.parking2.repository.ReservationRepository;
import com.PPE.parking2.service.PlaceService;
import com.PPE.parking2.service.ReservationService;
import com.PPE.parking2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static com.PPE.parking2.mapper.map;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    UserService userService;

    @Autowired
    PlaceService placeService;

    @Autowired
    ReservationRepository reservationRepository;

    public ReservationDto create(String id) {
        UserDto user = userService.getOneUser(id);

        List<PlaceDto> placesLibres = placeService.getAllPlaces();

        if (placesLibres.isEmpty()) {
            //user.mettreEnAttente();
            return null;
        } else {
            Random rand = new Random();
            PlaceDto placeLibre = placesLibres.get(rand.nextInt(placesLibres.size()));
            reservationRepository.save(new ReservationEntity(map(user), map(placeLibre)));
            return new ReservationDto(user, placeLibre);
        }
    }
}
