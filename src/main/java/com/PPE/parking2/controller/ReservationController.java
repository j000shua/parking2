package com.PPE.parking2.controller;

import com.PPE.parking2.dto.PlaceDto;
import com.PPE.parking2.dto.ReservationDto;
import com.PPE.parking2.entity.ReservationEntity;
import com.PPE.parking2.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/{id}")
    public ResponseEntity<ReservationDto> create(@PathVariable("id") String id) {
        try{
            ReservationDto newRes = reservationService.create(id);
            return new ResponseEntity<>(newRes, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
