/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Produit;

import java.util.List;

/**
 *
 * @author chedi
 */
public interface Iproduits {
    
    
    
     //ajouter
    public boolean ajouterProduit(Produit p);

    //lister
    public List<Produit> afficherProduit();

    //updata
    public boolean modifierProduit(Produit p);
    
    //promotion
   public  Produit calculerPromotion(Produit p);
   
   public boolean supprimerBynom(String nom);
    
   //recherche
    public List<Produit> rechercherProduit(String nom);
    
    //filtrage
    public List<Produit> filtrageproduit(int price1,int price2);
    
    //triASC
    public List<Produit> triproduit();
    
    //RETRIVE ID 
    public Produit retriveproduit(int id);

    //delete
    public boolean supprimerProduit(Produit p);

    
    
    
    
    
}
