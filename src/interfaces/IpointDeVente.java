/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.PointDeVente;

/**
 *
 * @author 21694
 */
public interface IpointDeVente {
    public PointDeVente ajouterPointDeVente(PointDeVente p);
    
    //lister
    public List<PointDeVente> afficherPointDeVentes();
    
    public boolean modifierPointDeVente(PointDeVente p);
    
    public boolean supprimerPointDeVente(PointDeVente p);
    
    public List<PointDeVente> chercherPointDeVente(List<PointDeVente> initialList ,String input);
    
    public PointDeVente retrievePointDeVente(int reference);
}
