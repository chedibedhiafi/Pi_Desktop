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



import javax.xml.ws.Service;
import java.sql.Connection;
import models.Catégorie;
import service.ServiceCatégorie;
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
           // Produit
//       Produit p = new Produit(sc.retrivecatégorie(9),"A51",1000,"phone");
//     Produit p2 = new Produit(13,sc.retrivecatégorie(9),"pc",1400,"pc");
//     Produit p6 = new Produit(sc.retrivecatégorie(9),"A51",1000,"A51");
     Produit p7 = new Produit(25,sc.retrivecatégorie(13),"SMARTTV",1700,"SMARTTV",40);
     Produit p8 = new Produit(18,sc.retrivecatégorie(11),"IPHONE",1100,"IPHONE",10);
     Produit p9 = new Produit(27,sc.retrivecatégorie(11),"IPHONE13",2200,"IPHONE13",20);
      Produit p10 = new Produit(28,sc.retrivecatégorie(9),"XBOBX",750,"XBOX",5);
      Produit p11 = new Produit(48,sc.retrivecatégorie(14),"OMEN",1500,"OMEN",10);
            Produit p12 = new Produit(56,sc.retrivecatégorie(28),"chedi",1500,"OMEN",10);

     
     
       //Produit p5 = new Produit(13,"screen",500,"screens");
       //Produit p3 = new Produit("tv",1750,"tvs");

        // SERVICE
        Iproduits sp = new ServiceProduit();

        // AJOUT PRODUIT
 // System.out.println(sp.ajouterProduit(p12));
   
   
   


        // MODIFIER
//      Produit p8= new Produit(14,sc.retrivecatégorie(11),"SMARTTV",200,"SMARTTV");
 // System.out.println("Update\n");
     // System.out.println(sp.modifierProduit(p7));
        
   

        //SUPPRIMER
   // System.out.println("Delete");
   // System.out.println(sp.supprimerProduit(p10));
    
    //recherche
     //  System.out.println("recherche");
// System.out.println(sp.rechercherProduit("SMARTTV"));
 
 //filtrage
      //System.out.println("filtrage");
 //System.out.println(sp.filtrageproduit(100, 800));
 
 //triASC
      //System.out.println("TRI");
//System.out.println(sp.triproduit());

//retrive id
//System.out.println("RETRIVE");
//       System.out.println(sp.retriveproduit(23));
        
                     // AFFICHER Produits
                     System.out.println("Liste Des Produits:");
    System.out.println(sp.afficherProduit());
    
    //PROMOTION
System.out.println(sp.calculerPromotion(p12));
      
        
        System.out.println("*********************** les catégories************************");
        
        //catégories
          //Catégorie c2 = new Catégorie("smartphones");
         // Catégorie c3 = new Catégorie(3,"pcs");
          //Catégorie c4 = new Catégorie(4,"consoles");
       // Catégorie c5 = new Catégorie(10,5,"chedi");
       Catégorie c7 = new Catégorie (7,"TV");
          Catégorie c8 = new Catégorie ("PC");
          //service
            
            
            //AJOUTER catégories
          // System.out.println(sc.ajouterCatégorie(c8));
           
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
       // System.out.println(sc.retrivecatégorie(11));
     
                      // AFFICHER catégories
                     // System.out.println("Liste Des Catégories:");
       //System.out.println(sc.afficherCatégorie());
        
    }
    
}
