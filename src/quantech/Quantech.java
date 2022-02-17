/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantech;

import java.time.LocalDate;
import java.sql.Date;
import models.Employe;
import models.PointDeVente;
import models.Stock;
import models.Utilisateur;
import services.ServiceEmploye;
import services.ServicePointDeVente;
import services.ServiceStock;
import services.ServiceUtilisateur;
import models.Commande;
import models.Livraison;
import models.Event;
import models.Reservation;
import models.Client;
import models.Blog;
import models.Commentaire;
import models.Produit;
import models.Catégorie;
import models.HistoriqueStock;

import services.ServiceBlog;
import services.ServiceCommande;
import services.ServiceLivraison;
import services.ServiceBlog;
import services.ServiceCommentaire;
import services.ServiceEvent;
import services.ServiceReservation;
import services.ServiceCatégorie;
import services.ServiceHistoriqueStock;
import services.ServiceProduit;


/**
 *
 * @author 21694
 */
public class Quantech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* CYRINE 
     
        Employe e1 = new Employe("admin","cyrine","123","2022-12-02","essid","cyrine","cyrine@gmail.com","yyyy-M-d");
        ServiceEmploye se = new ServiceEmploye();
        Employe e2 = new Employe("utilisateur",3,"cyrine","123","2022-12-02","essid","cyrine","cyrine@gmail.com","yyyy-M-d");
        
        //se.ajouterEmploye(e1);
        //se.modifierEmploye(e2);
        //se.supprimerEmploye(e2);
        //System.out.println(se.afficherEmployes());
        
        
        
        Utilisateur u1 = new Utilisateur("cyrine","123","2022-12-02","essid","cyrine","cyrine@gmail.com","yyyy-M-d");
        ServiceUtilisateur su = new ServiceUtilisateur();
        Utilisateur u2 = new Utilisateur(2,"cyrine","123","2022-12-02","essid","cycy","cyrine@gmail.com","yyyy-M-d");
        
        //su.ajouterUtilisateur(u1);
        //su.modifierUtilisateur(u2);
        //su.supprimerUtilisateur(u2);
        //System.out.println(su.afficherUtilisateurs());
        
        */
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        /* SOULAYMA
        Event e = new Event ();

        // SERVICE
        ServiceEvent se = new ServiceEvent();
        //se.ajout(new Event(new Date(-1900+2021,1+9,22),"efe",5.2,"fe","fe"));


        //se.modifier(new Event(20,new Date(-1900+2021,1+9,22),"ouuh",5.2,"ouh","ouh"));
        // AFFICHER
        //System.out.println(se.afficher());
        //se.supprimer(20);
        
        Reservation r = new Reservation(10, new Date(-1900+2021,1+9,22), 20.0, 19);
        Reservation r1 = new Reservation(4,10, new Date(-1900+2021,1+9,22), 25.0, 17);
        ServiceReservation sr = new ServiceReservation();
        //sr.ajout(r);
        //sr.modifier(r1);
        //sr.supprimer(4);
        // AFFICHER
        System.out.println(sr.afficher());
        */
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        /*HAROUN
        //blog
        
        
              Blog b1= new Blog ("first", "I am first", "2012-12-12","yyyy-M-d");
              Blog b4= new Blog (8, "first", "I am first", "2012-12-12","yyyy-M-d");
              Commentaire c1= new Commentaire ("first Comment", "2012-12-12","yyyy-M-d");
              
              Commentaire c3= new Commentaire (1, "first Comment", "2012-12-12","yyyy-M-d");
        
        // SERVICE
        ServiceBlog sb = new ServiceBlog();    
        ServiceCommentaire sc = new ServiceCommentaire();
        
        // AJOUT PERSONNE
        //System.out.println(sb.ajouterBlog(b1));
        //System.out.println(sc.ajouterCommentaire(c1));
        //System.out.println(sc.ajouterCommentaire(c2));
       
      //affichercomment
        //System.out.println(sc.afficherCommentaires()); 
      
      // MODIFIER
        Blog b2 = new Blog (1,"changed", "changed", "2012-01-01", "yyyy-M-d");
       Commentaire c2= new Commentaire (1, "second comment changed", "2012-12-13","yyyy-M-d");
      // System.out.println("Update\n");
        //System.out.println(sc.modifierCommentaire(c2));
      //  System.out.println(sb.modifierBlog(b2));
        
        //SUPPRIMER
       //  System.out.println("Delete");
        System.out.println(sb.supprimerBlog(b2));
       
       //SUPPRIMER
       // System.out.println("Delete");
        System.out.println(sc.supprimerCommentaire(c2));
        
        //afficher
        //System.out.println(sb.afficherBlogs()); 
        
        */
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        /* CHEDI
        
        System.out.println("**********************les produits***********************");
        
           // Produit
       Produit p = new Produit("A51",1000,"phone");
       //Produit p2 = new Produit(2,"pc",1400,"pc");

        // SERVICE
        ServiceProduit sp = new ServiceProduit();

        // AJOUT PRODUIT
     //System.out.println(sp.ajouterProduit(p));


        // MODIFIER
       Produit p2= new Produit(6,"fsdg",200,"dsfds");
     //System.out.println("Update\n");
        //System.out.println(sp.modifierProduit(p2));
        
   

        //SUPPRIMER
    //System.out.println("Delete");
    //System.out.println(sp.supprimerProduit(p2));
        
                     // AFFICHER Produits
        //System.out.println(sp.afficherProduit());
        
        
        //System.out.println("*********************** les catégories************************");
        
        //catégories
         // Catégorie c2 = new Catégorie("smartphones");
         // Catégorie c3 = new Catégorie(3,"pcs");
         // Catégorie c4 = new Catégorie(4,"consoles");
          //service
           ServiceCatégorie sc = new ServiceCatégorie();
            
            //AJOUTER catégories
           //System.out.println(sc.ajouterCatégorie(c2));
           
            // MODIFIER
       Catégorie c2= new Catégorie(5,"CONSOLES");
   //System.out.println("Update\n");
      // System.out.println(sc.modifierCatégorie(c2));
            
        
        
        //delete
           // System.out.println("Delete");
    //System.out.println(sc.supprimerCatégorie(c2));
     
                      // AFFICHER catégories
        System.out.println(sc.afficherCatégorie());
        
        */
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        /* WALID
        //var
        PointDeVente p1 = new PointDeVente("theName", "proprio", "adresse", "2022-12-02","yyyy-M-d");
        ServicePointDeVente sp = new ServicePointDeVente();
        PointDeVente p2 = new PointDeVente(1,"name", "proprio", "adresse", "2022-12-02","yyyy-M-d");
        
        //sp.ajouterPointDeVente(p1);
        sp.modifierPointDeVente(p2);
        System.out.println(sp.afficherPointDeVentes());
        
        Stock s1 = new Stock(1, 2, 100);
        ServiceStock ss = new ServiceStock();
        Stock s2 = new Stock(1, 2, 120);
        
        //ss.ajouterStock(s1);
        //System.out.println(ss.afficherStocks());
        //ss.modifierStock(s2);
        //ss.supprimerStock(s2);
        
        HistoriqueStock hs = new HistoriqueStock(1,2,3,"2022-02-14",120,"yyyy-M-d");
        ServiceHistoriqueStock shs = new ServiceHistoriqueStock();
        HistoriqueStock hs1 = new HistoriqueStock(2,1,2,3,"2022-02-14",100,"yyyy-M-d");
        
        //shs.ajouterHistoriqueStock(hs);
        //System.out.println(shs.afficherHistoriqueStocks());
        //shs.modifierHistoriqueStock(hs1);
        //shs.supprimerHistoriqueStock(hs1.getReference());
        
        */
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        /* MARIEM
        // commande
        Commande c1 = new Commande (1,"13 decembre 2022" , "15 decembre 2022");

        // SERVICE
        ServiceCommande sc = new ServiceCommande();

        // AJOUT COMMANDE
        //System.out.println(sc.ajouterCommande(c1));
        
        // AFFICHER COMMANDES
       // System.out.println(sc.afficherCommandes());

        // MODIFIER COMMANDE 
        Commande c = new Commande(24,"mariem","hhh");
        //System.out.println("Update\n");
        //System.out.println(sc.modifierCommande(c));

        //SUPPRIMER COMMANDE
        //System.out.println("Delete");
        //System.out.println(sc.supprimerCommande(c1));
        
        /////////////////////////
         // livraison
        Livraison l1 = new Livraison (41,"en cours de livraison",23555444);

        // SERVICE
        ServiceLivraison sl = new ServiceLivraison();

        // AJOUT LIVRAISON
        //System.out.println(sl.ajouterLivraison(l1));
        
        // AFFICHER Livraison
        //System.out.println(sl.afficherLivraison());

        // MODIFIER COMMANDE 
        Livraison l= new Livraison(41,"livré  avec succé",22450333);
        //System.out.println("Update\n");
        //System.out.println(sl.modifierLivraison(l));

        //SUPPRIMER LIVRAISON
        //System.out.println("Delete");
        //System.out.println(sl.supprimerLivraison(l));
      */  
    }
    
}
