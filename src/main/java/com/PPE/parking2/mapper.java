package com.PPE.parking2;

import com.PPE.parking2.dto.PlaceDto;
import com.PPE.parking2.dto.ReservationDto;
import com.PPE.parking2.dto.UserDto;
import com.PPE.parking2.entity.PlaceEntity;
import com.PPE.parking2.entity.ReservationEntity;
import com.PPE.parking2.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class mapper {

    public static PlaceDto map(PlaceEntity place) {
        return PlaceDto.builder()
                .id(place.getId())
                .numero(place.getNumero())
                .build();
    }

    public static PlaceEntity map(PlaceDto place) {
        return PlaceEntity.builder()
                .id(place.getId())
                .numero(place.getNumero())
                .build();
    }

    public static UserDto map(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .mail(user.getMail())
                .tel(user.getTel())
                .mdp(user.getMdp())
                .admin(user.isAdmin())
                .build();
    }

    public static UserEntity map(UserDto user) {
        return UserEntity.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .mail(user.getMail())
                .tel(user.getTel())
                .mdp(user.getMdp())
                .admin(user.isAdmin())
                .build();
    }

    public static ReservationDto map(ReservationEntity reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .user(reservation.getUser())
                .place(reservation.getPlace())
                .date(reservation.getDate())
                .build();
    }

    public static ReservationEntity map(ReservationDto reservation) {
        return ReservationEntity.builder()
                .id(reservation.getId())
                .user(reservation.getUser())
                .place(reservation.getPlace())
                .date(reservation.getDate())
                .build();
    }

    public static List<UserDto> map (List<UserEntity> userEntities) {
        return userEntities.stream().map(user -> {
                    return map(user);
                }
        ).collect(Collectors.toList());
    }
}
