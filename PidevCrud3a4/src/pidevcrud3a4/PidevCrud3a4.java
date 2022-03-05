/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevcrud3a4;

import java.sql.Connection;
import models.Commande;
import models.Livraison;
import models.ProduitCommande;  
import services.ServiceCommande;
import services.ServiceLivraison;
import services.ServiceProduitCommande;
import utils.MaConnexion;
import java.sql.Date;

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
       //Commande c1 = new Commande (date_creation, date_end);

        // SERVICE
        //ServiceCommande sc = new ServiceCommande();

        // AJOUT COMMANDE
        //System.out.println(sc.ajouterCommande(c1));
        
        // AFFICHER COMMANDES
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
//        Livraison l1 = new Livraison (8,40f,5,23555444,8);
//
//        // SERVICE
//        ServiceLivraison sl = new ServiceLivraison();
//
//        // AJOUT LIVRAISON
//       //System.out.println(sl.ajouterLivraison(l1));
//        
//        // AFFICHER Livraison
//        for (int i=0; i<sl.afficherLivraison().size();i++)
//        {
//            if(sl.afficherLivraison().get(i).getEtat_livraison()==0){
//                System.out.println("id livraison : "+sl.afficherLivraison().get(i).getId()+
//                        " , frais livraison : "+sl.afficherLivraison().get(i).getFrais_livraison()+
//                        " , etat livraison : livraison en cours , num livreur : "+sl.afficherLivraison().get(i).getNum_livreur()+
//                        " , id commande : "+sl.afficherLivraison().get(i).getId_commande());
//            }else if(sl.afficherLivraison().get(i).getEtat_livraison()==1){
//                System.out.println("id livraison : "+sl.afficherLivraison().get(i).getId()+
//                        " , frais livraison : "+sl.afficherLivraison().get(i).getFrais_livraison()+
//                        " , etat livraison : livraison avec succées , num livreur : "+sl.afficherLivraison().get(i).getNum_livreur()+
//                        " , id commande : "+sl.afficherLivraison().get(i).getId_commande());
//            }else if(sl.afficherLivraison().get(i).getEtat_livraison()==2){
//                System.out.println("id livraison : "+sl.afficherLivraison().get(i).getId()+
//                        " , frais livraison : "+sl.afficherLivraison().get(i).getFrais_livraison()+
//                        " , etat livraison : livraison annuler , num livreur : "+sl.afficherLivraison().get(i).getNum_livreur()+
//                        " , id commande : "+sl.afficherLivraison().get(i).getId_commande());
//            }
//        }
//        
//
//        // MODIFIER LIVRAISON 
//        //Livraison l= new Livraison(2,45f,2,24555888,6);
//        //System.out.println("Update\n");
//        //System.out.println(sl.modifierLivraison(l));
//
//        //SUPPRIMER LIVRAISON
//        System.out.println("Delete");
//        System.out.println(sl.supprimerLivraison(l1));
///////////////////////////PRODUIT COMMANDE
//       ProduitCommande s1 = new ProduitCommande ();
//       s1.setId_commande(2);
//       s1.setId_produit(1);
//       s1.setQuantite(3);
//       s1.setId(1);
       

        // SERVICE
        //ServiceProduitCommande s = new ServiceProduitCommande();

        // AJOUT   ProduitCommande
       //System.out.println(s.ajouterProduitCommande(s1));
        
        // AFFICHER Livraison
       //System.out.println(s.afficherProduitCommande());

        // MODIFIER ProduitCommande 
        //ProduitCommande s2= new ProduitCommande();
        //System.out.println("Update\n");
        //System.out.println(s.modifierProduitCommande(s1));

        //SUPPRIMER ProduitCommande
       // System.out.println("Delete");
        //System.out.println(s.supprimerProduitCommande(s1));
        ServiceLivraison s=new ServiceLivraison();
        Livraison liv=new Livraison();
        liv.setId(9);
        System.out.println(s.afficherLivClient(liv));
        
    }
    }
    

