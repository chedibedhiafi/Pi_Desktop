/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import models.Utilisateur;

/**
 *
 * @author 21694
 */
public interface Iutilisateur {
    public Utilisateur ajouterUtilisateur(Utilisateur u);
    
    //lister
    public List<Utilisateur> afficherUtilisateurs();
    
    public Utilisateur modifierUtilisateur(Utilisateur u);
    
    public boolean supprimerUtilisateur(Utilisateur u);
    
    public Utilisateur login(Utilisateur u);
    
    public Utilisateur retrieveUtilisateur(int id);
    
    public boolean modifierMdpParMail(Utilisateur u);
    
    public boolean modifierMdp(Utilisateur u);
    
    public boolean banUser(LocalDate unlock_date,int id);    
    
}
