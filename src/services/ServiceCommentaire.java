/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icommentaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Commentaire;
import utils.MaConnexion;
/**
 *
 * @author Haroun
 */
public class ServiceCommentaire implements Icommentaire {
    
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    
    ServiceBlog sb = new ServiceBlog();

    @Override
    public boolean ajouterCommentaire(Commentaire c) {
        String request = "INSERT INTO `commentaire`(`contenu`, `date`, `id_blog`) VALUES ('"+c.getContenu()+"','"+c.getDate()+"',"+c.getId_blog().getId()+")";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                return true;
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Commentaire> afficherCommentaires() {
        List<Commentaire> commentaires = new ArrayList<>();
        String req="SELECT * FROM commentaire";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            //SOB HEDHA FI HEDHA
            // "yyyy-M-d"
            while(rs.next()){               
              commentaires.add(new Commentaire(rs.getInt("id"),rs.getString(2),rs.getDate(3),sb.RetrieveBlog(rs.getInt("id_blog"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaires;
    }

    @Override
    public boolean modifierCommentaire(Commentaire c) {
        String req = "UPDATE `commentaire` SET `contenu`='"+c.getContenu()+"',`date`='"+c.getDate()+"',`id_blog`='"+c.getId_blog().getId()+"' WHERE `id` = "+c.getId()+" ";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean supprimerCommentaire(Commentaire c) {
        String req = "DELETE FROM `commentaire` WHERE `id` = "+c.getId()+" ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            return false;
        }
        
        
    
        
     
    
}

    @Override
    public Commentaire RetrieveCommentaires(int id) {
        
         Commentaire c = null;
                   String req="SELECT * FROM commentaire WHERE id="+id+" ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if(rs.next()){
                c = new Commentaire(rs.getInt("id"),rs.getString("contenu"),rs.getDate("date"), sb.RetrieveBlog(rs.getInt("id_blog")));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        return c;
    }

    @Override
    public List<Commentaire> TriCommentaires() {
        List<Commentaire> commentaires = new ArrayList<>();
        String req="SELECT * FROM commentaire ORDER BY date DESC";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            //SOB HEDHA FI HEDHA
            // "yyyy-M-d"
            while(rs.next()){               
              commentaires.add(new Commentaire(rs.getInt("id"),rs.getString(2),rs.getDate(3),sb.RetrieveBlog(rs.getInt("id_blog"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaires;
    }
}
