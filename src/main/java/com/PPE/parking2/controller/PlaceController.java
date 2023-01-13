package com.PPE.parking2.controller;

import com.PPE.parking2.model.Place;
import com.PPE.parking2.model.User;
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
    public ResponseEntity<List<Place>> getAllPlaces() {
        try{
            List<Place> allPlaces = placeRepository.findAll();

            if(allPlaces.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(allPlaces, HttpStatus.OK);

        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/places/{id}")
    public ResponseEntity<Place> getOnePlace(@PathVariable("id") String id) {
        try{
            Optional<Place> place = placeRepository.findById(id);
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
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        try{
            Place newPlace = placeRepository.save(new Place(place.getId(),place.getNumeroPlace()));
            return new ResponseEntity<>(newPlace, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/places/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable("id") String id, @RequestBody Place place) {
        try {
            Optional<Place> updatedPlaceOp = placeRepository.findById(id);
            if (updatedPlaceOp.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            else {
                Place updatedPlace = updatedPlaceOp.get();
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
