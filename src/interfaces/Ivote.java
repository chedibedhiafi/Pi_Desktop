/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Vote;

/**
 *
 * @author Haroun
 */
public interface Ivote {
    //ajouter
    public boolean ajouterVote(Vote v);
    
    //lister
    public List<Vote> afficherVote();
    
    public boolean modifierVote(Vote v);
    
    public boolean supprimerVote(Vote v);
    
    public List<Vote> TriVote();
    public List<Vote> SearchVote(int id_source);
}
