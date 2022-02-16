/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Haroun
 */
public class Blog {
    
    private int id;
    private String titre;
    private String contenu;
    private LocalDate date;

    public Blog() {
    }

    public Blog(String titre, String contenu, String date , String pattern) {
        this.titre = titre;
        this.contenu = contenu;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern , Locale.ENGLISH);
LocalDate dateTime = LocalDate.parse(date , formatter);
        this.date = dateTime;
        
    }

    public Blog(int id, String titre, String contenu, String date, String pattern) {
        // "d MMMM, yyyy"
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern , Locale.ENGLISH);
LocalDate dateTime = LocalDate.parse(date , formatter);

        this.date = dateTime;
        
    }

    
     
    
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
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

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", date=" + date + '}';
    }
    
    
    
    
    
}
