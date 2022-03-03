/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantech;

import interfaces.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
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
        
        /////////////////////////////////////////////////////////////// CYRINE
        /*IpointDeVente sp = new ServicePointDeVente();
        Employe e1 = new Employe(sp.retrievePointDeVente(3),"admin","aziz","lasfer",Date.valueOf("2020-07-04"),"lasfer","aziz","aziz@gmail.com");
        Employe e3 = new Employe(sp.retrievePointDeVente(3),"employe","walid","quantech",Date.valueOf("2020-07-04"),"maalej","walid","walid@gmail.com");
        Iemploye se = new ServiceEmploye();
        Employe e2 = new Employe(sp.retrievePointDeVente(3),"admin",17,"cyrine","123",Date.valueOf("2020-02-03"),"essid","cyrine","cyrine@gmail.com");*/
        
        //se.ajouterEmploye(e3);
        //System.out.println(se.afficherEmployes());
        //se.modifierEmploye(e2);
        //System.out.println(se.afficherEmployes());
        //se.supprimerEmploye(e3);
        //System.out.println(se.afficherEmployes());
        
        
        //Utilisateur u1 = new Utilisateur("cyrine","12",Date.valueOf("2020-02-03"),"essid","cyrine","cyrine@gmail.com");
        
        //Utilisateur u2 = new Utilisateur(29,"walid","waliiiidmdp",Date.valueOf("2020-07-04"),"me3lej","walid","walid@gmail.com");
        //Iutilisateur su = new ServiceUtilisateur();
        //su.ajouterUtilisateur(u2);
        //System.out.println(su.afficherUtilisateurs());
        //su.modifierUtilisateur(u2);
        //System.out.println(su.afficherUtilisateurs());
        //su.supprimerUtilisateur(u2);
        //System.out.println(su.afficherUtilisateurs());
        //Utilisateur uLogin = new Utilisateur("walid","quantech");
        //System.out.println(uLogin != su.login(uLogin));
        
        
        /////////////////////////////////////////////////////HAROUN
        
        //SERVICE
        Iblog sb = new ServiceBlog();    
        Icommentaire sc = new ServiceCommentaire();
        Ivote sv = new ServiceVote();
        //istantiation
        //blog
        Blog b1= new Blog ("new phones", "Phone sales","We are now selling Iphone11", Date.valueOf("2022-02-02"));
        //Blog b4= new Blog (2, "first", "I am first", Date.valueOf("2012-12-12"));
        //commentaire
        Commentaire c1= new Commentaire ("prix svp", Date.valueOf("2012-12-12"), sb.RetrieveBlog(3));      
        //Commentaire c3= new Commentaire (1, "first Comment", Date.valueOf("2012-12-12"));
        //Commentaire c5= new Commentaire (5,"idk abt this kinda sus", Date.valueOf("2012-12-12"), sb.RetrieveBlog(1));
        //Vote
        Commentaire c3= new Commentaire (8, "I really like this blog", Date.valueOf("2012-12-12"), sb.RetrieveBlog(2));
        Vote v1 = new Vote(1,c3);
        
        
        
        //AJOUT
        //Ajout blog
        //System.out.println(sb.ajouterBlog(b1));
        //Ajout commentaire
        //System.out.println(sc.ajouterCommentaire(c1));
        //Ajout vote
        //System.out.println(sv.ajouterVote(v1));
        
        //MODIFIER
        //Modifier blog
        Blog b2= new Blog (6, "write update here", "write update here","write update here", Date.valueOf("2022-03-03"));
        //System.out.println("Update\n");
        //System.out.println(sb.modifierBlog(b2));
        //Modifier commentaire
        Commentaire c2= new Commentaire (9, "prix svp pas privé", Date.valueOf("2012-12-12"), sb.RetrieveBlog(3)); 
        //System.out.println("Update\n");
        //System.out.println(sc.modifierCommentaire(c2));
        //Modifier vote
        //Vote v2 = new Vote(21,-1,sc.RetrieveCommentaires(10)); //needed for delete too
        //System.out.println("Update\n");
        //System.out.println(sv.modifierVote(v2));
        
        //DELETE
        //Delete Blog
        //System.out.println("Delete");
        //System.out.println(sb.supprimerBlog(b2));
        //Delete commentaire
        Commentaire c5= new Commentaire (7, "Finally, I was really waiting for this product", Date.valueOf("2012-12-12"), sb.RetrieveBlog(3)); 
        //System.out.println("Delete");
        //System.out.println(sc.supprimerCommentaire(c5));
        //Delete vote
        //System.out.println("Delete");
        //System.out.println(sv.supprimerVote(v2));
        
        //AFFICHER
        //afficher tous les blogs
        //System.out.println(sb.afficherBlogs());
        //System.out.println(sb.TriBlogs());
        //System.out.println(sb.SearchBlogs("new phones"));
        //System.out.println(sb.SearchBlogsSub("phone sales")); //recherche by sub (sujet)
        //afficher tous les commentaires
        //System.out.println(sc.afficherCommentaires());
        //System.out.println(sc.TriCommentaires());
        
        //afficher tous les votes
        //Commentaire c7= new Commentaire (2, "second comment changed", Date.valueOf("2012-12-13"));
        //System.out.println(sv.afficherVote());  
        //System.out.println(sv.TriVote());
        //System.out.println(sv.SearchVote(8)); //by id_source
        
        
        
        ////////////////////////////////////////////////////////////MARIEM
        
        
//        Date date_creation=new Date(2021, 2, 22);
//   Date date_end= new Date(2021,5,23);
//   Date date_creation1=new Date(2021, 2, 22);
//   Date date_end1= new Date(2021,5,23);
////        // commande
//       Commande c1 = new Commande (date_creation, date_end);
////
////         //SERVICE
//      ServiceCommande sc = new ServiceCommande();

         //AJOUT COMMANDE
//        System.out.println(sc.ajouterCommande(c1));
        
         //AFFICHER COMMANDES
//       System.out.println(sc.afficherCommandes());

        // MODIFIER COMMANDE 
//        Commande c = new Commande(3,date_creation1,date_end1);
//        System.out.println("Update\n");
//        System.out.println(sc.modifierCommande(c));

        //SUPPRIMER COMMANDE
//        System.out.println("Delete");
//        c1.setId(13);
//        System.out.println(sc.supprimerCommande(c1));
        
        /////////////////////////
         // livraison
//   Livraison l1 = new Livraison (35f,10,94110535,sc.retrieveCommande(10));
////////
////////        SERVICE
//       ServiceLivraison sl = new ServiceLivraison();
////
////        // AJOUT LIVRAISON
//    // System.out.println(sl.ajouterLivraison(l1));
////        
//        // AFFICHER Livraison (metier 2)
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
////
////        // MODIFIER LIVRAISON 
// Livraison l= new Livraison(9,50f,0,24555445,sc.retrieveCommande(9));
//       System.out.println("Update\n");
//       System.out.println(sl.modifierLivraison(l));

//        //SUPPRIMER LIVRAISON
//        System.out.println("Delete");
//      System.out.println(sl.supprimerLivraison(l));
///////////////////////////PRODUIT COMMANDE
//      Iproduits sp = new ServiceProduit();
//       ProduitCommande s1 = new ProduitCommande ();
//       s1.setC(sc.retrieveCommande(4));
//      s1.setP(sp.retriveproduit(4));
//      s1.setQuantite(4);
//       // SERVICE
//        ServiceProduitCommande s = new ServiceProduitCommande();
//
//        // AJOUT   ProduitCommande
//       //System.out.println(s.ajouterProduitCommande(s1));
//        
//        // AFFICHER Livraison
//       System.out.println(s.afficherProduitCommande());

//        // MODIFIER ProduitCommande 
//        ProduitCommande s2= new ProduitCommande(10,sc.retrieveCommande(7),sp.retriveproduit(4),5);
//        System.out.println("Update\n");
//        System.out.println(s.modifierProduitCommande(s2));
//
////        //SUPPRIMER ProduitCommande
//         System.out.println("Delete");
//       System.out.println(s.supprimerProduitCommande(s2));
        
        ///////////////metier
//      ServiceLivraison s1=new ServiceLivraison();
//       Livraison liv=new Livraison();
//       liv.setId(9);
//        System.out.println(s1.afficherLivClient(liv));
////        
//        
        ////////////////////////////////////////////////////////////CHEDI
        
        
//        System.out.println("**********************les produits***********************");
//        Icatégorie sc = new ServiceCatégorie();
//            Produit
//       Produit p = new Produit(sc.retrivecatégorie(9),"A51",1000,"phone");
//     Produit p2 = new Produit(13,sc.retrivecatégorie(5),"pc",1400,"pc");
//     Produit p6 = new Produit(sc.retrivecatégorie(6),"A51",1000,"A51");
//     Produit p7 = new Produit(sc.retrivecatégorie(9),"XIOMI",700,"XIOMI");
//    Produit p8 = new Produit(,sc.retrivecatégorie(11),"IPHONE",1100,"IPHONE");
//     Produit p9 = new Produit(sc.retrivecatégorie(7),"PS4",650,"PS4");
    
     
     
       //Produit p5 = new Produit(13,"screen",500,"screens");
       //Produit p3 = new Produit("tv",1750,"tvs");

        // SERVICE
//        Iproduits sp = new ServiceProduit();

        // AJOUT PRODUIT
 // System.out.println(sp.ajouterProduit(p9));


        // MODIFIER
      // Produit p8= new Produit(5,sc.retrivecatégorie(7),"SMARTTV",200,"SMARTTV");
 // System.out.println("Update\n");
      //System.out.println(sp.modifierProduit(p8));
        
   

        //SUPPRIMER
    //System.out.println("Delete");
   // System.out.println(sp.supprimerProduit(p8));
    
    //recherche
      //System.out.println("recherche");
 //System.out.println(sp.rechercherProduit("pc"));
 
 //filtrage
  /* System.out.println("filtrage");
 System.out.println(sp.filtrageproduit(900, 1500));
// 
//triASC
    System.out.println("TRI");
System.out.println(sp.triproduit());
//
//retrive id
System.out.println("RETRIVE");
       System.out.println(sp.retriveproduit(4));

 */
 
        
    
    
        
                     // AFFICHER Produits
//                     System.out.println("Liste Des Produits:");
//  System.out.println(sp.afficherProduit());
//        
//        
//        System.out.println("*********************** les catégories************************");
        
        //catégories
          //Catégorie c2 = new Catégorie("smartphones");
         // Catégorie c3 = new Catégorie(3,"pcs");
          //Catégorie c4 = new Catégorie(4,"consoles");
       // Catégorie c5 = new Catégorie(10,5,"chedi");
//       Catégorie c7 = new Catégorie ("TV");
//          Catégorie c8 = new Catégorie ("PC");
//           Catégorie c9 = new Catégorie ("SMARTPHONES");
//            Catégorie c10 = new Catégorie ("CONSOLES");
          //service
            
            
            //AJOUTER catégories
          // System.out.println(sc.ajouterCatégorie(c10));
           
            // MODIFIER
     //  Catégorie c5= new Catégorie(9,5,"CONSOLES");
  // System.out.println("Update\n");
      // System.out.println(sc.modifierCatégorie(c5));
            
        
                        // RECHERCHE catégories
                        //System.out.println("recherche");
    // System.out.println(sc.rechercheCatégorie("TV"));
     
     
        //delete
           // System.out.println("Delete");
    //System.out.println(sc.supprimerCatégorie(c5));
    
    //RETRIVE
       // System.out.println("RETRIVE");
       // System.out.println(sc.retrivecatégorie(6));
     
                      // AFFICHER catégories
                      //System.out.println("Liste Des Catégories:");
       //System.out.println(sc.afficherCatégorie());
        
        
        
        /////////////////////////////////////////////////SOULAYMA
        
        
        // Event
//        Event e = new Event ();
//        // SERVICE
//        IService se = new ServiceEvent();
//        // se.ajout(new Event(new Date(-1900+2021,1+9,22),"efe",5.2,"fe","fe"));
        // se.modifier(new Event(13,new Date(-1900+2021,1+9,22),"ouuh",5.2,"ouh","ouh"));
        // AFFICHER
        //System.out.println(se.afficher());
       // se.supprimer(se.retrieve(14));
        
        //reservation
//        Reservation r = new Reservation(10, new Date(-1900+2021,1+9,22), 20.0,(Event)se.retrieve(17));
//        //Reservation r1 = new Reservation(4,10, new Date(-1900+2021,1+9,22), 25.0, 17);
//        //service
//        IService sr = new ServiceReservation();
        //sr.ajout(r);
        //sr.modifier(r);
        //sr.supprimer(r);
        // AFFICHER
        //System.out.println(sr.afficher());
        
        
       //rate
      //Rate r2 = new Rate();
      //service
     //ServiceRate sr1 = new ServiceRate();
     //sr1.ajouter (new Rate( 19 ,1, 23.0));
 //boolean Ok ;
     //Ok = sr1.isRated(14, 14 );
      //afficher
     // System.out.println(Ok);
      
      /////////////////////////////////////////////////////////WALID

        
//        Iproduits serviceProduit = new ServiceProduit();
//        IpointDeVente serviceDeVente = new ServicePointDeVente();
//        Istock serviceStock = new ServiceStock();
//        IhistoriqueStock serviceHistoriqueStock = new ServiceHistoriqueStock();
//        
//        Produit pc = serviceProduit.retriveproduit(4);
//        Produit ps4 = serviceProduit.retriveproduit(6);
//
//        
//        PointDeVente tunis = serviceDeVente.retrievePointDeVente(3);
//        
//        HistoriqueStock hist = new HistoriqueStock(new Stock(ps4, tunis), Date.valueOf(LocalDate.now()), -2, "sale");
//        System.out.println(serviceStock.afficherStocks());
//        System.out.println("Trying to remove from inexisting stock");
//        System.out.println(serviceHistoriqueStock.insertInHistoriqueStock(hist));
//        System.out.println(serviceStock.afficherStocks());
//        
//        System.out.println("RESTOCKING");
//        hist = new HistoriqueStock(new Stock(ps4, tunis), Date.valueOf(LocalDate.now()), 8, "restock");
//        System.out.println(serviceHistoriqueStock.insertInHistoriqueStock(hist));
//        System.out.println(serviceStock.afficherStocks());
//        
//        System.out.println("Trying to remove from stock while i dont have");
//        hist = new HistoriqueStock(new Stock(ps4, tunis), Date.valueOf(LocalDate.now()), -10, "sale");
//        System.out.println(serviceHistoriqueStock.insertInHistoriqueStock(hist));
//        System.out.println(serviceStock.afficherStocks());
//        
//        System.out.println("SELLING");
//        hist = new HistoriqueStock(new Stock(ps4, tunis), Date.valueOf(LocalDate.now()), -6, "sale");
//        System.out.println(serviceHistoriqueStock.insertInHistoriqueStock(hist));
//        System.out.println(serviceStock.afficherStocks());
//        

        //AUTRE METIERS
//        String str = "Walid";
//        System.out.println("Les points de ventes that contains : " + str);
//        List<PointDeVente> list = serviceDeVente.afficherPointDeVentes();
//        System.out.println(serviceDeVente.chercherPointDeVente(list, str));
//        
//        System.out.println("rechercher une quantité d'un produit dans les stocks de tous les points de ventes");
//        System.out.println(serviceStock.findProduit(pc, 2));
//        System.out.println(serviceStock.findProduit(ps4, 2));
       
            }
    
}
