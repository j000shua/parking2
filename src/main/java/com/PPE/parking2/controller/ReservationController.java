package com.PPE.parking2.controller;

import com.PPE.parking2.entity.ReservationEntity;
import com.PPE.parking2.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/{id}")
    public ResponseEntity<ReservationEntity> create(@PathVariable("id") String id) {
        try{
            ReservationEntity newRes = reservationService.create(id);
            return new ResponseEntity<>(newRes, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<ReservationEntity>> getAllReservations() {
        try{
            List<ReservationEntity> allReservations = reservationService.getAllReservations();

            if (allReservations.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<>(allReservations, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
