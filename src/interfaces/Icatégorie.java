/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Catégorie;

import java.util.List;

/**
 *
 * @author chedi
 */
public interface Icatégorie {
    
       public boolean ajouterCatégorie(Catégorie c);

    //lister
    public List<Catégorie> afficherCatégorie();

    //update
    public boolean modifierCatégorie(Catégorie c);

    //delete
    public boolean supprimerCatégorie(Catégorie c);
    
}
