/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class Livraison {
    private int id;
    private float frais_livraison;
    private int etat_livraison;
    private int num_livreur;
    private Commande c;
    private float Tva;
    private float Somme;
    

    public Livraison() {
    } 

    public Livraison(int id, float frais_livraison, int etat_livraison, int num_livreur, Commande c) {
        this.id = id;
        this.frais_livraison = frais_livraison;
        this.etat_livraison = etat_livraison;
        this.num_livreur = num_livreur;
        this.c = c;
    }

    public Livraison(float frais_livraison, int etat_livraison, int num_livreur, Commande c) {
        this.frais_livraison = frais_livraison;
        this.etat_livraison = etat_livraison;
        this.num_livreur = num_livreur;
        this.c = c;
    }
    
    public Livraison(float frais_livraison, int etat_livraison, int num_livreur, Commande c, float Tva, float Somme) {
        this.frais_livraison = frais_livraison;
        this.etat_livraison = etat_livraison;
        this.num_livreur = num_livreur;
        this.c = c;
        this.Tva = Tva;
        this.Somme = Somme;
    }
    
    

    public float getSomme() {
        return Somme;
    }

    public void setSomme(float Somme) {
        this.Somme = Somme;
    }


    public float getTva() {
        return Tva;
    }

    public void setTva(float Tva) {
        this.Tva = Tva;
    }
    
    

    public int getId() {
        return id;
    }

    public float getFrais_livraison() {
        return frais_livraison;
    }

    public int getEtat_livraison() {
        return etat_livraison;
    }

    public int getNum_livreur() {
        return num_livreur;
    }

    public Commande getC() {
        return c;
    }

    public void setC(Commande c) {
        this.c = c;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFrais_livraison(float frais_livraison) {
        this.frais_livraison = frais_livraison;
    }

    public void setEtat_livraison(int etat_livraison) {
        this.etat_livraison = etat_livraison;
    }

    public void setNum_livreur(int num_livreur) {
        this.num_livreur = num_livreur;
    }


    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", frais_livraison=" + frais_livraison + ", etat_livraison=" + etat_livraison + ", num_livreur=" + num_livreur + ", commande=" + c + ", Tva=" + Tva + ", Somme=" + Somme + '}';
    }



    

  

 
   

}
