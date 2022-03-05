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
    private int id_commande;
    private List<String> nom;
    private float Tva;
    private float Somme;

    public Livraison(int id, float frais_livraison, int etat_livraison, int num_livreur, int id_commande) {
        this.id = id;
        this.frais_livraison = frais_livraison;
        this.etat_livraison = etat_livraison;
        this.num_livreur = num_livreur;
        this.id_commande = id_commande;
    }

    public float getSomme() {
        return Somme;
    }

    public void setSomme(float Somme) {
        this.Somme = Somme;
    }

    
    public List<String> getNom() {
        return nom;
    }

    public void setNom(List<String> nom) {
        this.nom = nom;
    }

    public float getTva() {
        return Tva;
    }

    public void setTva(float Tva) {
        this.Tva = Tva;
    }
    
    

    public Livraison() {
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

    public int getId_commande() {
        return id_commande;
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

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", frais_livraison=" + frais_livraison + ", etat_livraison=" + etat_livraison + ", num_livreur=" + num_livreur + ", id_commande=" + id_commande + ", nom=" + nom + ", Somme=" + Somme +", Tva=" + Tva +  '}';
    }



    

  

 
   

}
