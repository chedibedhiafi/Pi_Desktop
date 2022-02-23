/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author 21624
 */
public class HistoriqueStock {
    private int reference;
    private int id_produit;
    private int id_pointdevente;
    private int id_employe;
    private LocalDate date;
    private int quantite;

    public HistoriqueStock() {
    }

    public HistoriqueStock(int id_produit, int id_pointdevente, int id_employe, LocalDate date, int quantite) {
        this.id_produit = id_produit;
        this.id_pointdevente = id_pointdevente;
        this.id_employe = id_employe;
        this.date = date;
        this.quantite = quantite;
    }
    
    public HistoriqueStock(int id_produit, int id_pointdevente, int id_employe, String date, int quantite, String format) {
        this.id_produit = id_produit;
        this.id_pointdevente = id_pointdevente;
        this.id_employe = id_employe;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format , Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(date , formatter);
        this.date = dateTime;
        this.quantite = quantite;
    }

    public HistoriqueStock(int reference, int id_produit, int id_pointdevente, int id_employe, LocalDate date, int quantite) {
        this.reference = reference;
        this.id_produit = id_produit;
        this.id_pointdevente = id_pointdevente;
        this.id_employe = id_employe;
        this.date = date;
        this.quantite = quantite;
    }
    
    public HistoriqueStock(int reference, int id_produit, int id_pointdevente, int id_employe, String date, int quantite, String format) {
        this.reference = reference;
        this.id_produit = id_produit;
        this.id_pointdevente = id_pointdevente;
        this.id_employe = id_employe;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format , Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(date , formatter);
        this.date = dateTime;
        this.quantite = quantite;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_pointdevente() {
        return id_pointdevente;
    }

    public void setId_pointdevente(int id_pointdevente) {
        this.id_pointdevente = id_pointdevente;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }
    
    

    @Override
    public String toString() {
        return "HistoriqueStock{" + "reference=" + reference + ", id_produit=" + id_produit + ", id_pointdevente=" + id_pointdevente + ", id_employe=" + id_employe + ", date=" + date + ", quantite=" + quantite + '}';
    }

   
    
    
    
    
}
