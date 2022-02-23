/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Commande {
  private int id;
  private Date date_creation;
  private Date date_envoie;

    public Commande(int id, Date date_creation, Date date_envoie) {
        this.id = id;
        this.date_creation = date_creation;
        this.date_envoie = date_envoie;
    }

    public Commande(Date date_creation, Date date_envoie) {
        this.date_creation = date_creation;
        this.date_envoie = date_envoie;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public Date getDate_envoie() {
        return date_envoie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setDate_envoie(Date date_envoie) {
        this.date_envoie = date_envoie;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", date_creation=" + date_creation + ", date_envoie=" + date_envoie + '}';
    }
  
    
}
