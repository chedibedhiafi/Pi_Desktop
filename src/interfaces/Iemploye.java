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
    public Employe ajouterEmploye(Employe e);
    
    //lister
    public List<Employe> afficherEmployes();
    
    public Employe modifierEmploye(Employe e);
    
    public boolean supprimerEmploye(Employe e);
    
    public Employe retrieveEmploye(Employe e);
    
    public boolean modifierMdp(Employe e);
    
    
    
}
