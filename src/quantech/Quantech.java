/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantech;

import java.time.LocalDate;
import models.Employe;
import models.Utilisateur;
import services.ServiceEmploye;
import services.ServiceUtilisateur;

/**
 *
 * @author 21694
 */
public class Quantech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Employe e1 = new Employe("admin","cyrine","123","2022-12-02","essid","cyrine","cyrine@gmail.com","yyyy-M-d");
        ServiceEmploye se = new ServiceEmploye();
        Employe e2 = new Employe("utilisateur",1,"cyrine","123","2022-12-02","essid","cyrine","cyrine@gmail.com","yyyy-M-d");
        
        //se.ajouterEmploye(e1);
        //se.modifierEmploye(e2);
        //se.supprimerEmploye(e2);
        //System.out.println(se.afficherEmployes());
        
        
        
        Utilisateur u1 = new Utilisateur("cyrine","123","2022-12-02","essid","cyrine","cyrine@gmail.com","yyyy-M-d");
        ServiceUtilisateur su = new ServiceUtilisateur();
        Utilisateur u2 = new Utilisateur(1,"cyrine","123","2022-12-02","essid","cycy","cyrine@gmail.com","yyyy-M-d");
        
        //su.ajouterUtilisateur(u1);
        //su.modifierUtilisateur(u2);
        //su.supprimerUtilisateur(u2);
        //System.out.println(su.afficherUtilisateurs());
        
        
    }
    
}
