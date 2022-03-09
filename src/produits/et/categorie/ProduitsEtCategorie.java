/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produits.et.categorie;
import service.ServiceProduit;
import models.Produit;
import interfaces.Iproduits;
import interfaces.Icatégorie;
import models.Promotion;
import interfaces.Ipromotion;


import javax.xml.ws.Service;
import java.sql.Connection;
import models.Catégorie;
import service.ServiceCatégorie;
import service.ServicePromotion;
/**
 *
 * @author chedi
 */
public class ProduitsEtCategorie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("**********************les produits***********************");
        Icatégorie sc = new ServiceCatégorie();
        Ipromotion ip = new ServicePromotion();
           // Produit
//       Produit p = new Produit(sc.retrivecatégorie(9),"A51",1000,"phone");
//     Produit p2 = new Produit(13,sc.retrivecatégorie(9),"pc",1400,"pc");
//     Produit p6 = new Produit(sc.retrivecatégorie(9),"A51",1000,"A51");
//     Produit p7 = new Produit(25,sc.retrivecatégorie(13),"SMARTTV",1700,"SMARTTV",40);
//     Produit p8 = new Produit(18,sc.retrivecatégorie(11),"IPHONE",1100,"IPHONE",10);
//     Produit p9 = new Produit(27,sc.retrivecatégorie(11),"IPHONE13",2200,"IPHONE13",20);
//      Produit p10 = new Produit(28,sc.retrivecatégorie(9),"XBOBX",750,"XBOX",5);
//      Produit p11 = new Produit(48,sc.retrivecatégorie(14),"OMEN",1500,"OMEN",10);
//            Produit p12 = new Produit(56,sc.retrivecatégorie(28),"chedi",1500,"OMEN",10);
  Produit p13 = new Produit(81,sc.retrivecatégorie(36),ip.retrivepromotion(1),"S22",1500,"OMEN","lol",10);
Produit p14 = new Produit(82,sc.retrivecatégorie(31),ip.retrivepromotion(1),"hahahaha",1500,"sdfdf","qsfsqf",10);
  Produit p15 = new Produit(84,sc.retrivecatégorie(36),ip.retrivepromotion(2),"PROOO",1000,"OMEN","lol",10);
Produit p16 = new Produit(95,sc.retrivecatégorie(36),ip.retrivepromotion(2),"lllllllllllllllll",1000,"OMEN","lol",30);
    Produit p17 = new Produit(97,sc.retrivecatégorie(36),ip.retrivepromotion(7),"TEST",1000,"OMEN","lol",30);
     Produit p18 = new Produit(99,sc.retrivecatégorie(36),ip.retrivepromotion(7),"TESTqsfdf",1000,"lol",30);
     Produit p19 = new Produit(sc.retrivecatégorie(36),ip.retrivepromotion(7),"chedi",1000,"lol",30);
     Produit p20 = new Produit(109,sc.retrivecatégorie(36),ip.retrivepromotion(7),"ok",1000,"lol",30);
   Promotion pro11 = new Promotion(15);
        Produit p21 = new Produit(122,sc.retrivecatégorie(36),ip.retrivepromotion(7),"TESTqsfdf",1000,"lol",30);

       Produit p1 = new Produit(125,sc.retrivecatégorie(36),ip.retrivepromotion(8),"S22",1500,"OMEN","lol",10);

       //Produit p5 = new Produit(13,"screen",500,"screens");
       //Produit p3 = new Produit("tv",1750,"tvs");

        // SERVICE
        Iproduits sp = new ServiceProduit();

        // AJOUT PRODUIT
//System.out.println(sp.ajouterProduit(p1));

        //System.out.println(ip.ajouterPromotion(pro11));
   
   
      //  System.out.println(ip.afficherPromotion());


        // MODIFIER
//      Produit p8= new Produit(14,sc.retrivecatégorie(11),"SMARTTV",200,"SMARTTV");
 //System.out.println("Update\n");
    //  System.out.println(sp.modifierProduit(p20));
        
   //
     //   System.out.println(ip.retrivepromotion(1));

        //SUPPRIMER
//   System.out.println("Delete");
//   System.out.println(sp.supprimerProduit(p14));
//System.out.println(ip.afficherPromotion());
    
    //recherche
     //  System.out.println("recherche");
//System.out.println(sp.rechercherProduit("aaa"));
 
 //filtrage
      //System.out.println("filtrage");
 //System.out.println(sp.filtrageproduit(100, 800));
 
 //triASC
      //System.out.println("TRI");
//System.out.println(sp.triproduit());

//retrive id
//System.out.println("RETRIVE");
//       System.out.println(sp.retriveproduit(79));
        
                     // AFFICHER Produits
//                     System.out.println("Liste Des Produits:");
//    System.out.println(sp.afficherProduit());
    
    //PROMOTION
System.out.println(sp.calculerPromotion(p1));

       // System.out.println(sp.supprimerBynom("chedi"));
      
        
        System.out.println("*********************** les catégories************************");
        
        //catégories
          //Catégorie c2 = new Catégorie("smartphones");
         // Catégorie c3 = new Catégorie(3,"pcs");
          //Catégorie c4 = new Catégorie(4,"consoles");
       // Catégorie c5 = new Catégorie(10,5,"chedi");
       Catégorie c7 = new Catégorie (7,"TV");
          Catégorie c8 = new Catégorie ("PC");
          Catégorie c9 = new Catégorie (42,"TEST");
          
          //service
            
            
            //AJOUTER catégories
           //System.out.println(sc.ajouterCatégorie(c9));
           
            // MODIFIER
     //  Catégorie c5= new Catégorie(9,5,"CONSOLES");
  // System.out.println("Update\n");
      // System.out.println(sc.modifierCatégorie(c5));
            
        
                        // RECHERCHE catégories
                        //System.out.println("recherche");
    // System.out.println(sc.rechercheCatégorie("TV"));
     
     
        //delete
           // System.out.println("Delete");
  //  System.out.println(sc.supprimerCatégorie(c9));
    
    //RETRIVE
       // System.out.println("RETRIVE");
       // System.out.println(sc.retrivecatégorie(11));
     
                      // AFFICHER catégories
                     // System.out.println("Liste Des Catégories:");
       //System.out.println(sc.afficherCatégorie());
        
    }
    
}
