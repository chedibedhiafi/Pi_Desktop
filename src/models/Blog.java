/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Locale;

/**
 *
 * @author Haroun
 */
public class Blog {
    
    private int id;
    private String titre;
    private String sujet;
    private String contenu;
    private Date date;

    public Blog() {
    }
    //Constructor without id
    public Blog(String titre, String sujet, String contenu, Date date) {
        this.titre = titre;
        this.sujet = sujet;
        this.contenu = contenu;
        this.date = date;
    }
    //Constructor with id
    public Blog(int id, String titre, String sujet, String contenu, Date date) {
        this.id = id;
        this.titre = titre;
        this.sujet = sujet;
        this.contenu = contenu;
        this.date = date;
    }
    
    

    public Blog(String titre, String sujet, String contenu) {
        this.titre = titre;
        this.sujet = sujet;
        this.contenu = contenu;
    }

    public Blog(int id, String titre, String sujet, String contenu) {
        this.id = id;
        this.titre = titre;
        this.sujet = sujet;
        this.contenu = contenu;
    }
    
    
    
    //GETTERS
    public int getId() {
        return id;
    }
    
    public String getTitre() {
        return titre;
    }

    public String getSujet() {
        return sujet;
    }
    
    public String getContenu() {
        return contenu;
    }

    public Date getDate() {
        return date;
    }

    
    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
    
    

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", titre=" + titre + ", sujet=" + sujet + ", contenu=" + contenu + ", date=" + date + '}';
    }

    
    
}
