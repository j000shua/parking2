package com.PPE.parking2.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class UserEntity {
    @Id
    private String id;

    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private String mdp;
    private boolean admin;
    private int rang;

    public UserEntity(){}

    public UserEntity(String nom, String prenom, String mail, String tel, String mdp, boolean admin) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.mdp = mdp;
        this.admin = admin;
    }

}
