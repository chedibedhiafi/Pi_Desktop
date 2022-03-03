/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author chedi
 */
public class Produit {
    
    private int id ;
    private Catégorie catégorie;
    private String nom;
    private int prix;
    private String image;
    private double promotion;

    public Produit() {
    }

    public Produit(int id, double promotion) {
        this.id = id;
        this.promotion = promotion;
    }
    

    public Produit(int id, Catégorie catégorie, String nom, int prix, String image, double promotion) {
        this.id = id;
        this.catégorie = catégorie;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.promotion = promotion;
    }   

    public Produit(Catégorie catégorie, String nom, int prix, double promotion) {
        this.catégorie = catégorie;
        this.nom = nom;
        this.prix = prix;
        this.promotion = promotion;
    }

    public Produit(int id, Catégorie catégorie, String nom, int prix, double promotion) {
        this.id = id;
        this.catégorie = catégorie;
        this.nom = nom;
        this.prix = prix;
        this.promotion = promotion;
    }
    
    
    
    
    //ID AUTOINCRIMENT
    public Produit(Catégorie catégorie, String nom, int prix, String image, double promotion) {
        this.catégorie = catégorie;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.promotion = promotion;
    }

    //GETTER AND SETTERS
    public int getId() {
        return id;
    }

    public Catégorie getCatégorie() {
        return catégorie;
    }

    public double getPromotion() {
        return promotion;
    }

  

   
    

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCatégorie(Catégorie catégorie) {
        this.catégorie = catégorie;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

   

    
     
    //affichage

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", cat\u00e9gorie=" + catégorie + ", nom=" + nom + ", prix=" + prix + ", image=" + image + ", promotion=" + promotion + '}';
    }

   

    

   

    
    
    
    
    
    
}
