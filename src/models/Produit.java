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
    private Promotion promotion;
    private String nom;
    private int prix;
    private String image;
    private String description;
    private int profit;

    public Produit() {
    }

    public Produit(int id, Catégorie catégorie, Promotion promotion, String nom, int prix, String image, String description, int profit) {
        this.id = id;
        this.catégorie = catégorie;
        this.promotion = promotion;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.profit = profit;
    }
    

    public Produit(Catégorie catégorie, Promotion promotion, String nom, int prix, String image, String description, int profit) {
        this.catégorie = catégorie;
        this.promotion = promotion;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.profit = profit;
    }

    public Produit(Catégorie catégorie, String nom, int prix, String description) {
        this.catégorie = catégorie;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }

    public Produit(Catégorie catégorie, Promotion promotion) {
        this.catégorie = catégorie;
        this.promotion = promotion;
    }
    

    

    

    public Produit(int id, Catégorie catégorie, Promotion promotion, String nom, int prix, String description, int profit) {
        this.id = id;
        this.catégorie = catégorie;
        this.promotion = promotion;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.profit = profit;
    }

    public Produit(Catégorie catégorie, Promotion promotion, String nom, int prix, String description, int profit) {
        this.catégorie = catégorie;
        this.promotion = promotion;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.profit = profit;
    }
    

    
    

 

    //GETTER AND SETTERS
    public int getId() {
        return id;
    }

    public Catégorie getCatégorie() {
        return catégorie;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public String getDescription() {
        return description;
    }

    public int getProfit() {
        return profit;
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

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

  
   

    
     
    //affichage

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", cat\u00e9gorie=" + catégorie + ", promotion=" + promotion + ", nom=" + nom + ", prix=" + prix + ", image=" + image + ", description=" + description + ", profit=" + profit + '}';
    }

    
   

 
   

    

   

    
    
    
    
    
    
}
