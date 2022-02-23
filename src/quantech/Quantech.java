/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantech;

import interfaces.*;
import java.sql.Date;
import services.*;
import models.*;


/**
 *
 * @author 21694
 */
public class Quantech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IpointDeVente sp = new ServicePointDeVente();
        Employe e1 = new Employe(sp.retrievePointDeVente(3),"admin","aziz","lasfer",Date.valueOf("2020-07-04"),"lasfer","aziz","aziz@gmail.com");
        Employe e3 = new Employe(sp.retrievePointDeVente(3),"employe","walid","waliiiidmdp",Date.valueOf("2020-07-04"),"me3lej","walid","walid@gmail.com");
        Iemploye se = new ServiceEmploye();
        Employe e2 = new Employe(sp.retrievePointDeVente(3),"admin",17,"cyrine","123",Date.valueOf("2020-02-03"),"essid","cyrine","cyrine@gmail.com");
        
        se.ajouterEmploye(e3);
        //System.out.println(se.afficherEmployes());
        //se.modifierEmploye(e2);
        //System.out.println(se.afficherEmployes());
        //se.supprimerEmploye(e3);
        //System.out.println(se.afficherEmployes());
        
        
        //Utilisateur u1 = new Utilisateur("cyrine","12",Date.valueOf("2020-02-03"),"essid","cyrine","cyrine@gmail.com");
        
        Utilisateur u2 = new Utilisateur(29,"walid","waliiiidmdp",Date.valueOf("2020-07-04"),"me3lej","walid","walid@gmail.com");
        Iutilisateur su = new ServiceUtilisateur();
        //su.ajouterUtilisateur(u2);
        //System.out.println(su.afficherUtilisateurs());
        //su.modifierUtilisateur(u2);
        //System.out.println(su.afficherUtilisateurs());
        //su.supprimerUtilisateur(u2);
        //System.out.println(su.afficherUtilisateurs());
        Utilisateur uLogin = new Utilisateur("walid","waliiiidmdp");
        //System.out.println(uLogin != su.login(uLogin));
        
        

       
            }
    
}
