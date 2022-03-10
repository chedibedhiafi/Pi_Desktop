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
    private int quantite;
    private int total;
     private int description;

    public Produit() {
    }

    public Produit(int id, Catégorie catégorie, String nom, int prix, String image) {
        this.id = id;
        this.catégorie = catégorie;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    

   
    
    //ID AUTOINCRIMENT

    public Produit(Catégorie catégorie, String nom, int prix, String image) {
        this.catégorie = catégorie;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
    }

    //GETTER AND SETTERS
    public int getId() {
        return id;
    }

    public Catégorie getCatégorie() {
        return catégorie;
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

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

     
    //affichage

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", cat\u00e9gorie=" + catégorie + ", nom=" + nom + ", prix=" + prix + ", image=" + image + '}';
    }

    

   

    
    
    
    
    
    
}
