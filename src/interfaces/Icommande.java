/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Commande;

/**
 *
 * @author ASUS
 */
public interface Icommande {
     //ajouter
    public boolean ajouterCommande (Commande c);
    
    //lister
    public List<Commande> afficherCommandes();
    
    public boolean modifierCommande(Commande c);
    
    public boolean supprimerCommande (Commande c);
}
