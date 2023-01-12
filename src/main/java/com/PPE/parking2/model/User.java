package com.PPE.parking2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private String mdp;
    private boolean admin;
    private int rang;

    public User(){}

    public User(String nom, String prenom, String mail, String tel, String mdp, boolean admin) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.mdp = mdp;
        this.admin = admin;
    }

    public String getId(){
        return id;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail(){
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel(){
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMdp(){
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public int getRang(){
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    @Override
    public String toString(){
        return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", tel=" + tel +
                ", mdp=" + mdp + ", estAdmin=" + admin + ", rang=" + rang + "]";
    }
}
