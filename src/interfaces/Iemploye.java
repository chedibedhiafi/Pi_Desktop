/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Employe;

/**
 *
 * @author 21694
 */
public interface Iemploye {
    public boolean ajouterEmploye(Employe e);
    
    //lister
    public List<Employe> afficherEmployes();
    
    public boolean modifierEmploye(Employe e);
    
    public boolean supprimerEmploye(Employe e);
}
