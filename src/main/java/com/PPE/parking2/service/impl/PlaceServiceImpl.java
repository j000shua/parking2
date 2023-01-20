package com.PPE.parking2.service.impl;

import com.PPE.parking2.dto.PlaceDto;
import com.PPE.parking2.dto.UserDto;
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

    public PlaceDto map(PlaceEntity place) {
        return PlaceDto.builder()
                .id(place.getId())
                .numero(place.getNumero())
                .build();
    }

    public List<PlaceDto> map (List<PlaceEntity> placeEntities) {
        return placeEntities.stream().map(place -> {
                    return map(place);
                }
        ).collect(Collectors.toList());
    }

    public List<PlaceDto> getAllPlaces() {
        List<PlaceEntity> allPlacesEntities = placeRepository.findAll();
        return map(allPlacesEntities);
    }

    public PlaceDto getOnePlace(String id) {
        Optional<PlaceEntity> place = placeRepository.findById(id);
        if(place.isPresent())
            return map(place.get());
        else
            return null;
    }

    public PlaceDto createPlace(PlaceEntity place) {
        PlaceEntity newPlace = placeRepository.save(new PlaceEntity(place.getId(),place.getNumero()));
        return map(newPlace);
    }

    public PlaceDto updatePlace(String id, PlaceEntity place) {
        Optional<PlaceEntity> updatedPlaceOp = placeRepository.findById(id);
        if (updatedPlaceOp.isEmpty())
            return null;
        else {
            PlaceEntity updatedPlace = updatedPlaceOp.get();
            updatedPlace.setNumero(place.getNumero());
            placeRepository.save(updatedPlace);
            return map(updatedPlace);
        }
    }

    public void deletePlace(String id) {
        placeRepository.deleteById(id);
    }
}
