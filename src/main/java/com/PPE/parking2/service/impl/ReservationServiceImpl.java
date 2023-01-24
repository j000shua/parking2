package com.PPE.parking2.service.impl;

import com.PPE.parking2.entity.PlaceEntity;
import com.PPE.parking2.entity.ReservationEntity;
import com.PPE.parking2.entity.UserEntity;
import com.PPE.parking2.repository.ReservationRepository;
import com.PPE.parking2.service.PlaceService;
import com.PPE.parking2.service.ReservationService;
import com.PPE.parking2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

        List<PlaceEntity> placesLibres = placeService.getFreePlaces();

        if (placesLibres.isEmpty()) {
            //user.mettreEnAttente();
            return null;
        } else {
            Random rand = new Random();
            PlaceEntity placeLibre = placesLibres.get(rand.nextInt(placesLibres.size()));

            placeLibre = placeService.saveTaken(placeLibre.getId(), true);

            ReservationEntity newRes = new ReservationEntity(user,placeLibre);
            return reservationRepository.save(newRes);
        }
    }

    public List<ReservationEntity> getAllReservations() {
        return reservationRepository.findAll();
    }

    public ReservationEntity end(String id) {

        Optional<ReservationEntity> resToEndOp = reservationRepository.findById(id);
        if(resToEndOp.isPresent()){
            ReservationEntity resToEnd = resToEndOp.get();
            resToEnd.setDateFin(LocalDateTime.now());
            resToEnd.getPlace().setTaken(false);
            PlaceEntity place = resToEnd.getPlace();
            place = placeService.saveTaken(place.getId(), false);

            return reservationRepository.save(resToEnd);
        }
        else
            return null;
    }
}
