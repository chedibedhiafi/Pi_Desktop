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
public class Livraison {
    private int frais_livraison;
    private String etat_livraison;
    private int num_livreur;

    public Livraison() {
    }

    public Livraison(int frais_livraison, String etat_livraison, int num_livreur) {
        this.frais_livraison = frais_livraison;
        this.etat_livraison = etat_livraison;
        this.num_livreur = num_livreur;
    }

    public int getFrais_livraison() {
        return frais_livraison;
    }

    public String getEtat_livraison() {
        return etat_livraison;
    }

    public int getNum_livreur() {
        return num_livreur;
    }

    public void setPrix_livraison(int prix_livraison) {
        this.frais_livraison = frais_livraison;
    }

    public void setEtat_livraison(String etat_livraison) {
        this.etat_livraison = etat_livraison;
    }

    public void setNum_livreur(int num_livreur) {
        this.num_livreur = num_livreur;
    }

    @Override
    public String toString() {
        return "Livraison{" + "frias_livraison=" + frais_livraison + ", etat_livraison=" + etat_livraison + ", num_livreur=" + num_livreur + '}';
    }
   
    
}
