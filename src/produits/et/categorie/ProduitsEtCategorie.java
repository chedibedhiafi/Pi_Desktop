/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produits.et.categorie;
import service.ServiceProduit;
import modele.Produit;



import javax.xml.ws.Service;
import java.sql.Connection;
import modele.Catégorie;
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
        
           // Produit
       Produit p = new Produit("A51",1000,"phone");
       Produit p2 = new Produit(2,"pc",1400,"pc");

        // SERVICE
        ServiceProduit sp = new ServiceProduit();

        // AJOUT PRODUIT
     System.out.println(sp.ajouterProduit(p));


        // MODIFIER
       // Produit p2= new Produit(2,"fsdg",200,"dsfds");
   //  System.out.println("Update\n");
       // System.out.println(sp.modifierProduit(p2));
        
   

        //SUPPRIMER
    // System.out.println("Delete");
    // System.out.println(sp.supprimerProduit(p2));
        
                     // AFFICHER Produits
        System.out.println(sp.afficherProduit());
        
        
        System.out.println("*********************** les catégories************************");
        
        //catégories
          //Catégorie c2 = new Catégorie("smartphones");
          Catégorie c3 = new Catégorie(3,"pcs");
          Catégorie c4 = new Catégorie(4,"consoles");
          //service
            ServiceCatégorie sc = new ServiceCatégorie();
            
            //AJOUTER catégories
           // System.out.println(sc.ajouterCatégorie(c4));
           
            // MODIFIER
       Catégorie c2= new Catégorie(2,"CONSOLES");
   //System.out.println("Update\n");
       //System.out.println(sc.modifierCatégorie(c2));
            
        
        
        //delete
           // System.out.println("Delete");
    //System.out.println(sc.supprimerCatégorie(c3));
     
                      // AFFICHER catégories
        System.out.println(sc.afficherCatégorie());
        
    }
    
}
