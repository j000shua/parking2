package com.PPE.parking2.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder
@Data
@Document("reservation")
public class ReservationEntity {

    public ReservationEntity(UserEntity user, PlaceEntity place) {
        this.user = user;
        this.place = place;
        this.date = LocalDate.now();
    }

    @Id
    private String id;

    private UserEntity user;

    private PlaceEntity place;

    private LocalDate date;
}
