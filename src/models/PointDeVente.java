/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author 21694
 */
public class PointDeVente {
    private int reference;
    private String name;
    private String proprietaire;
    private String adresse;
    private Date date_ouverture;

    public PointDeVente() {
    }

    public PointDeVente(String name, String proprietaire, String adresse, Date date_ouverture) {
        this.name = name;
        this.proprietaire = proprietaire;
        this.adresse = adresse;
        this.date_ouverture = date_ouverture;
    }

    public PointDeVente(int reference, String name, String proprietaire, String adresse, Date date_ouverture) {
        this.reference = reference;
        this.name = name;
        this.proprietaire = proprietaire;
        this.adresse = adresse;
        this.date_ouverture = date_ouverture;
    }
    
    public int getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDate_ouverture() {
        return date_ouverture;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDate_ouverture(Date date_ouverture) {
        this.date_ouverture = date_ouverture;
    }

    @Override
    public String toString() {
        return "PointDeVente{" + "reference=" + reference + ", name=" + name + ", proprietaire=" + proprietaire + ", adresse=" + adresse + ", date_ouverture=" + date_ouverture + '}';
    }
    
    public String concat(){
        return reference + ".@." + name + ".@." + proprietaire + ".@." + adresse + ".@." + date_ouverture ;
    }
    
    
    
}
