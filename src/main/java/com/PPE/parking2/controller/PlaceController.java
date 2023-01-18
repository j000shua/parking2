package com.PPE.parking2.controller;

import com.PPE.parking2.entity.PlaceEntity;
import com.PPE.parking2.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/places")
    public ResponseEntity<List<PlaceEntity>> getAllPlaces() {
        try{
            List<PlaceEntity> allPlaces = placeRepository.findAll();

            if(allPlaces.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(allPlaces, HttpStatus.OK);

        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/places/{id}")
    public ResponseEntity<PlaceEntity> getOnePlace(@PathVariable("id") String id) {
        try{
            Optional<PlaceEntity> place = placeRepository.findById(id);
            if(place.isPresent())
                return new ResponseEntity<>(place.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/places")
    public ResponseEntity<PlaceEntity> createPlace(@RequestBody PlaceEntity place) {
        try{
            PlaceEntity newPlace = placeRepository.save(new PlaceEntity(place.getId(),place.getNumeroPlace()));
            return new ResponseEntity<>(newPlace, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/places/{id}")
    public ResponseEntity<PlaceEntity> updatePlace(@PathVariable("id") String id, @RequestBody PlaceEntity place) {
        try {
            Optional<PlaceEntity> updatedPlaceOp = placeRepository.findById(id);
            if (updatedPlaceOp.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            else {
                PlaceEntity updatedPlace = updatedPlaceOp.get();
                updatedPlace.setNumeroPlace(place.getNumeroPlace());

                return new ResponseEntity<>(placeRepository.save(updatedPlace), HttpStatus.OK);
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/places/{id}")
    public ResponseEntity<HttpStatus> deletePlace(@PathVariable("id") String id ) {
        try{
            placeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
