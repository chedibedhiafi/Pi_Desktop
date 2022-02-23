/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.ProduitCommande;

/**
 *
 * @author ASUS
 */
public interface Iproduitcommande {
     //ajouter
    public boolean ajouterProduitCommande(ProduitCommande s);
    
    //lister
    public List<ProduitCommande> afficherProduitCommande();
    
    public boolean modifierProduitCommande(ProduitCommande s);
    
    public boolean supprimerProduitCommande(ProduitCommande s);  
}
