/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevcrud3a4;

import java.sql.Connection;
import models.Commande;
import models.Livraison;
import services.ServiceCommande;
import services.ServiceLivraison;
import utils.MaConnexion;

/**
 *
 * @author ASUS
 */
public class PidevCrud3a4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Connection cnx = MaConnexion.getInstance().getCnx();
        // commande
        Commande c1 = new Commande (2,"12 decembre 2022" , "15 decembre 2022");

        // SERVICE
        ServiceCommande sc = new ServiceCommande();

        // AJOUT COMMANDE
        //System.out.println(sc.ajouterCommande(c1));
        
        // AFFICHER COMMANDES
       // System.out.println(sc.afficherCommandes());

        // MODIFIER COMMANDE 
        //Commande c = new Commande(23,"mariem","hhh");
        //System.out.println("Update\n");
        //System.out.println(sc.modifierCommande(c));

        //SUPPRIMER COMMANDE
        //System.out.println("Delete");
        //System.out.println(sc.supprimerCommande(c1));
        
        /////////////////////////
         // livraison
        Livraison l1 = new Livraison (40,"en cours de livraison",23555444);

        // SERVICE
        ServiceLivraison sl = new ServiceLivraison();

        // AJOUT LIVRAISON
        //System.out.println(sl.ajouterLivraison(l1));
        
        // AFFICHER Livraison
        //System.out.println(sl.afficherLivraison());

        // MODIFIER COMMANDE 
        //Livraison l= new Livraison(40,"livré  avec succé",22450333);
        //System.out.println("Update\n");
        //System.out.println(sl.modifierLivraison(l));

        //SUPPRIMER LIVRAISON
        System.out.println("Delete");
        System.out.println(sl.supprimerLivraison(l1));

    }
    }
    

