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
    private String contenu;
    private Date date;

    public Blog() {
    }

    public Blog(String titre, String contenu, Date date) {
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;    
    }

    public Blog(int id, String titre, String contenu, Date date) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;     
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

    public Date getDate() {
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

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", date=" + date + '}';
    }
    
    
    
    
    
}
