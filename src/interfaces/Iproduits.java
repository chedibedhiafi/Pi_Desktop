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

    //update
    public boolean modifierProduit(Produit p);

    //delete
    public boolean supprimerProduit(Produit p);

    
    
    
    
    
}
