/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 *
 * @author 21694
 */
public class Utilisateur {
    protected int id;
    protected String login;
    protected String mdp;
    protected LocalDate date_naissance;
    protected String nom;
    protected String prenom;
    protected String email;

    public Utilisateur() {
    }

    public Utilisateur(int id, String login, String mdp, String date_naissance, String nom, String prenom, String email,String pattern) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern , Locale.ENGLISH);
LocalDate dateTime = LocalDate.parse(date_naissance , formatter);
        this.date_naissance = dateTime;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Utilisateur(String login, String mdp, String date_naissance, String nom, String prenom, String email,String pattern) {
        this.login = login;
        this.mdp = mdp;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern , Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(date_naissance , formatter);
        this.date_naissance = dateTime;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", login=" + login + ", mdp=" + mdp + ", date_naissance=" + date_naissance + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
       
    
}
