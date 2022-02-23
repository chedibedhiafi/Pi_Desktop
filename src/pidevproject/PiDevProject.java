/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevproject;
import interfaces.Iblog;
import interfaces.Icommentaire;
import interfaces.Ivote;
import java.sql.Connection;
import java.sql.Date;
import models.Blog;
import models.Commentaire;
import models.Vote;
import services.ServiceBlog;
import services.ServiceCommentaire;
import services.ServiceVote;
import utils.MaConnexion;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;

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
        //SERVICE
        Iblog sb = new ServiceBlog();    
        Icommentaire sc = new ServiceCommentaire();
        Ivote sv = new ServiceVote();
        //istantiation
        //blog
        Blog b1= new Blog ("first", "I am first", Date.valueOf("2012-12-12"));
        Blog b4= new Blog (2, "first", "I am first", Date.valueOf("2012-12-12"));
        //commentaire
        Commentaire c1= new Commentaire ("first Comment", Date.valueOf("2012-12-12"), sb.RetrieveBlog(1));      
        //Commentaire c3= new Commentaire (1, "first Comment", Date.valueOf("2012-12-12"));
        Commentaire c5= new Commentaire (5,"idk abt this kinda sus", Date.valueOf("2012-12-12"), sb.RetrieveBlog(1));
        //Vote
        Commentaire c3= new Commentaire (3, "I really like this blog", Date.valueOf("2012-12-12"), sb.RetrieveBlog(2));
        Vote v1 = new Vote(1,c5);
        
        
        
        //AJOUT
        //Ajout blog
        //System.out.println(sb.ajouterBlog(b1));
        //Ajout commentaire
        //System.out.println(sc.ajouterCommentaire(c5));
        //Ajout vote
        //System.out.println(sv.ajouterVote(v1));
        
        //MODIFIER
        //Modifier blog
        //Blog b2 = new Blog (1,"changed", "changed", Date.valueOf("2012-01-01"));
        //System.out.println("Update\n");
        //System.out.println(sb.modifierBlog(b2));
        //Modifier commentaire
        Commentaire c2= new Commentaire (3, "I like this blog", Date.valueOf("2012-02-02"), sb.RetrieveBlog(1));
        //System.out.println("Update\n");
        //System.out.println(sc.modifierCommentaire(c2));
        //Modifier vote
        //Vote v2 = new Vote(4,-1,sc.RetrieveCommentaires(5)); //needed for delete too
        //System.out.println("Update\n");
        //System.out.println(sv.modifierVote(v2));
        
        //DELETE
        //Delete Blog
        //System.out.println("Delete");
        //System.out.println(sb.supprimerBlog(b4));
        //Delete commentaire
        //Commentaire c5= new Commentaire (4,"first Comment", Date.valueOf("2012-12-12"), sb.RetrieveBlog(1));
        //System.out.println("Delete");
        //System.out.println(sc.supprimerCommentaire(c5));
        //Delete vote
        //System.out.println("Delete");
        //System.out.println(sv.supprimerVote(v2));
        
        //AFFICHER
        //afficher tous les blogs
        //System.out.println(sb.afficherBlogs());
        //System.out.println(sb.TriBlogs());
        //System.out.println(sb.SearchBlogs("first"));
        //afficher tous les commentaires
        //System.out.println(sc.afficherCommentaires());
        //System.out.println(sc.TriCommentaires());
        
        //afficher tous les votes
        //Commentaire c7= new Commentaire (2, "second comment changed", Date.valueOf("2012-12-13"));
        //System.out.println(sv.afficherVote());  
        //System.out.println(sv.TriVote());
        //System.out.println(sv.SearchVote(5)); //by id_source
    }
}
