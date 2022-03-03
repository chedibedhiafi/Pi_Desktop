/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;


/**
 *
 * @author 21624
 */
public class HistoriqueStock {
    private int reference;
    private Stock stock;
    private Date date;
    private int quantite;
    private String reason;

    public HistoriqueStock() {
    }

    public HistoriqueStock(int reference, Stock stock, Date date, int quantite, String reason) {
        this.reference = reference;
        this.stock = stock;
        this.date = date;
        this.quantite = quantite;
        this.reason = reason;
    }

    public HistoriqueStock(Stock stock, Date date, int quantite, String reason) {
        this.stock = stock;
        this.date = date;
        this.quantite = quantite;
        this.reason = reason;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "HistoriqueStock{" + "reference=" + reference + ", stock=" + stock + ", date=" + date + ", quantite=" + quantite + ", reason=" + reason + '}';
    }

    

    
    
}
