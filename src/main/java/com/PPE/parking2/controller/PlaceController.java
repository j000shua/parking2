package com.PPE.parking2.controller;

import com.PPE.parking2.dto.PlaceDto;
import com.PPE.parking2.entity.PlaceEntity;
import com.PPE.parking2.repository.PlaceRepository;
import com.PPE.parking2.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping
    public ResponseEntity<List<PlaceDto>> getAllPlaces() {
        try{
            List<PlaceDto> allPlaces = placeService.getAllPlaces();

            if(allPlaces.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(allPlaces, HttpStatus.OK);

        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDto> getOnePlace(@PathVariable("id") String id) {
        try{
            PlaceDto place = placeService.getOnePlace(id);
            if(place != null)
                return new ResponseEntity<>(place, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<PlaceDto> createPlace(@RequestBody PlaceEntity place) {
        try{
            PlaceDto newPlace = placeService.createPlace(place);
            return new ResponseEntity<>(newPlace, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceDto> updatePlace(@PathVariable("id") String id, @RequestBody PlaceEntity place) {
        try {
            PlaceDto updatedPlace = placeService.updatePlace(id, place);
            if (updatedPlace == null)
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            else {
                return new ResponseEntity<>(updatedPlace, HttpStatus.OK);
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlace(@PathVariable("id") String id ) {
        try{
            placeService.deletePlace(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
