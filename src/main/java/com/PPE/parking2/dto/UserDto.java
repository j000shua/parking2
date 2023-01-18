package com.PPE.parking2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String id;
    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private String mdp;
    private boolean admin;
    private int rang;
}
