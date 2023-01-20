package com.PPE.parking2.dto;

import com.PPE.parking2.entity.PlaceEntity;
import com.PPE.parking2.entity.UserEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class ReservationDto {

    public ReservationDto(UserDto user, PlaceDto place) {
        this.user= user;
        this.place = place;
        this.date = LocalDate.now();
    }

    private String id;

    private UserDto user;

    private PlaceDto place;

    private LocalDate date;
}
