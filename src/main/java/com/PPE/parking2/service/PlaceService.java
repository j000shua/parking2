package com.PPE.parking2.service;

import com.PPE.parking2.entity.PlaceEntity;

import java.util.List;

public interface PlaceService {

    public List<PlaceEntity> getAllPlaces();

    public PlaceEntity getOnePlace(String id);

    public PlaceEntity createPlace(PlaceEntity place);

    public PlaceEntity updatePlace(String id, PlaceEntity place);

    public void deletePlace(String id);

    public PlaceEntity saveTaken(String id, boolean taken);

    public List<PlaceEntity> getFreePlaces();
}
