/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


import java.util.Date;

/**
 *
 * @author Haroun
 */
public class Commentaire {
    
    private int id;
    private String contenu;
    private LocalDate date;

    public Commentaire(int id, String contenu, String date, String pattern) {
        this.id = id;
        this.contenu = contenu;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern , Locale.ENGLISH);
LocalDate dateTime = LocalDate.parse(date , formatter);
        
        this.date = dateTime;
    }

    public Commentaire(String contenu, String date, String pattern) {
        this.contenu = contenu;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern , Locale.ENGLISH);
LocalDate dateTime = LocalDate.parse(date , formatter);

        this.date = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", contenu=" + contenu + ", date=" + date + '}';
    }
    
    
    
}
