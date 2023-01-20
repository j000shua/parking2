package com.PPE.parking2.service;

import com.PPE.parking2.dto.PlaceDto;
import com.PPE.parking2.entity.PlaceEntity;

import java.util.List;

public interface PlaceService {

    public List<PlaceDto> getAllPlaces();

    public PlaceDto getOnePlace(String id);

    public PlaceDto createPlace(PlaceEntity place);

    public PlaceDto updatePlace(String id, PlaceEntity place);

    public void deletePlace(String id);
}
