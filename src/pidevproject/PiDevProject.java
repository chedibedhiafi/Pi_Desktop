/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevproject;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;

import model.Blog;
import model.Commentaire;
import service.ServiceBlog;
import service.ServiceCommentaire;
import util.MaConnexion;

/**
 *
 * @author Haroun
 */
public class PiDevProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection cnx = MaConnexion.getInstance().getCnx();
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
        System.out.println(sc.afficherCommentaires()); 
      
      // MODIFIER
      //  Blog b2 = new Blog (1,"changed", "changed", "2012-01-01", "yyyy-M-d");
      // Commentaire c2= new Commentaire (2, "second comment changed", "2012-12-13","yyyy-M-d");
      // System.out.println("Update\n");
      //  System.out.println(sc.modifierCommentaire(c2));
      //  System.out.println(sb.modifierBlog(b2));
        
        //SUPPRIMER
       //  System.out.println("Delete");
       // System.out.println(sb.supprimerBlog(b4));
       
       //SUPPRIMER
       // System.out.println("Delete");
        //System.out.println(sc.supprimerCommentaire(c3));
        
        //afficher
        //System.out.println(sb.afficherBlogs()); 
        
    }

    
}
