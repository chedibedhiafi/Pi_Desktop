/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevcrud3a4;

import interfaces.Iproduits;
import java.sql.Connection;
import models.Commande;
import models.Livraison;
import models.ProduitCommande;  
import services.ServiceCommande;
import services.ServiceLivraison;
import services.ServiceProduitCommande;
import utils.MaConnexion;
import java.sql.Date;
import models.Produit;
import services.ServiceProduit;

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
   Date date_creation=new Date(2021, 2, 22);
   Date date_end= new Date(2021,5,23);
   Date date_creation1=new Date(2021, 2, 22);
   Date date_end1= new Date(2021,5,23);
        // commande
       Commande c1 = new Commande (date_creation, date_end);

         //SERVICE
        ServiceCommande sc = new ServiceCommande();

         //AJOUT COMMANDE
        //System.out.println(sc.ajouterCommande(c1));
        
         //AFFICHER COMMANDES
       //System.out.println(sc.afficherCommandes());

        // MODIFIER COMMANDE 
        //Commande c = new Commande(3,date_creation1,date_end1);
        //System.out.println("Update\n");
        //System.out.println(sc.modifierCommande(c));

        //SUPPRIMER COMMANDE
        //System.out.println("Delete");
       //c1.setId(5);
        //System.out.println(sc.supprimerCommande(c1));
        
        /////////////////////////
         // livraison
       Livraison l1 = new Livraison (35f,10,94110535,sc.retrieveCommande(10));
//
//        SERVICE
        ServiceLivraison sl = new ServiceLivraison();
//
//        // AJOUT LIVRAISON
     //System.out.println(sl.ajouterLivraison(l1));
//        
//        // AFFICHER Livraison
//        for (int i=0; i<sl.afficherLivraison().size();i++)
//        {
//            if(sl.afficherLivraison().get(i).getEtat_livraison()==0){
//                System.out.println("id livraison : "+sl.afficherLivraison().get(i).getId()+
//                        " , frais livraison : "+sl.afficherLivraison().get(i).getFrais_livraison()+
//                        " , etat livraison : livraison en cours , num livreur : "+sl.afficherLivraison().get(i).getNum_livreur()+
//                        " , id commande : "+sl.afficherLivraison().get(i).getC().getId());
//            }else if(sl.afficherLivraison().get(i).getEtat_livraison()==1){
//                System.out.println("id livraison : "+sl.afficherLivraison().get(i).getId()+
//                        " , frais livraison : "+sl.afficherLivraison().get(i).getFrais_livraison()+
//                        " , etat livraison : livraison avec succès , num livreur : "+sl.afficherLivraison().get(i).getNum_livreur()+
//                        " , id commande : "+sl.afficherLivraison().get(i).getC().getId());
//            }else if(sl.afficherLivraison().get(i).getEtat_livraison()==2){
//                System.out.println("id livraison : "+sl.afficherLivraison().get(i).getId()+
//                        " , frais livraison : "+sl.afficherLivraison().get(i).getFrais_livraison()+
//                        " , etat livraison : livraison annulée , num livreur : "+sl.afficherLivraison().get(i).getNum_livreur()+
//                        " , id commande : "+sl.afficherLivraison().get(i).getC().getId());
//            }
//        }
//        
//
//        // MODIFIER LIVRAISON 
 Livraison l= new Livraison(10,45f,2,24555888,sc.retrieveCommande(9));
//        System.out.println("Update\n");
//        System.out.println(sl.modifierLivraison(l));

//        //SUPPRIMER LIVRAISON
//        System.out.println("Delete");
//      System.out.println(sl.supprimerLivraison(l));
///////////////////////////PRODUIT COMMANDE
//      Iproduits sp = new ServiceProduit();
////       ProduitCommande s1 = new ProduitCommande ();
////       s1.setC(sc.retrieveCommande(3));
////      s1.setP(sp.retriveproduit(3));
////      s1.setQuantite(2);
////       
//
//        // SERVICE
//        ServiceProduitCommande s = new ServiceProduitCommande();

        // AJOUT   ProduitCommande
       //System.out.println(s.ajouterProduitCommande(s1));
        
        // AFFICHER Livraison
//       System.out.println(s.afficherProduitCommande());
//
//        // MODIFIER ProduitCommande 
//        ProduitCommande s2= new ProduitCommande(9,sc.retrieveCommande(6),sp.retriveproduit(3), 10);
//        System.out.println("Update\n");
//        //System.out.println(s.modifierProduitCommande(s2));
//
//        //SUPPRIMER ProduitCommande
//       // System.out.println("Delete");
//        System.out.println(s.supprimerProduitCommande(s2));
        
        ///////////////metier
        ServiceLivraison s1=new ServiceLivraison();
        Livraison liv=new Livraison();
        liv.setId(9);
        System.out.println(s1.afficherLivClient(liv));
        
    }
    }
    

