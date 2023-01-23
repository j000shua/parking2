package com.PPE.parking2.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("reservation")
public class ReservationEntity {

    @Id
    private String id;

    private UserEntity user;

    private PlaceEntity place;

    private LocalDate date;

    private LocalDate dateFin;

    public ReservationEntity(UserEntity user, PlaceEntity place) {
        this.user = user;
        this.place = place;
        this.date = LocalDate.now();
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ReservationEntity;
    }

}
