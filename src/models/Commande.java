/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ASUS
 */
public class Commande {
  private int id_commande;
  private String date_creation;
  private String date_envoie;

    public Commande() {
    }

    public Commande(int id_commande, String date_creation, String date_envoie) {
        this.id_commande = id_commande;
        this.date_creation = date_creation;
        this.date_envoie = date_envoie;
    }

    public Commande(String date_creation, String date_envoie) {
        this.date_creation = date_creation;
        this.date_envoie = date_envoie;
    }

   

    public int getId_commande() {
        return id_commande;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public String getDate_envoie() {
        return date_envoie;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public void setDate_envoie(String date_envoie) {
        this.date_envoie = date_envoie;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", date_creation=" + date_creation + ", date_envoie=" + date_envoie + '}';
    }
  
  
    
}
