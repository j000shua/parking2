package com.PPE.parking2.service.impl;

import com.PPE.parking2.entity.PlaceEntity;
import com.PPE.parking2.entity.UserEntity;
import com.PPE.parking2.repository.PlaceRepository;
import com.PPE.parking2.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    public List<PlaceEntity> getAllPlaces() {
        List<PlaceEntity> allPlacesEntities = placeRepository.findAll();
        return allPlacesEntities;
    }

    public PlaceEntity getOnePlace(String id) {
        Optional<PlaceEntity> place = placeRepository.findById(id);
        if(place.isPresent())
            return place.get();
        else
            return null;
    }

    public PlaceEntity createPlace(PlaceEntity place) {
        PlaceEntity newPlace = placeRepository.save(new PlaceEntity(place.getId(),place.getNumero(), false));
        return newPlace;
    }

    public PlaceEntity updatePlace(String id, PlaceEntity place) {
        Optional<PlaceEntity> updatedPlaceOp = placeRepository.findById(id);
        if (updatedPlaceOp.isEmpty())
            return null;
        else {
            PlaceEntity updatedPlace = updatedPlaceOp.get();
            updatedPlace.setNumero(place.getNumero());
            placeRepository.save(updatedPlace);
            return updatedPlace;
        }
    }

    public void deletePlace(String id) {
        placeRepository.deleteById(id);
    }

    public PlaceEntity saveTaken(String id, boolean taken) {
        PlaceEntity place = placeRepository.findById(id).get();
        place.setTaken(taken);
        return placeRepository.save(place);
    }

    public List<PlaceEntity> getFreePlaces(){
        System.out.println("DEBUG");
        return placeRepository.findByTaken(false);
    }

}
