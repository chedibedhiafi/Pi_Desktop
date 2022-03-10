/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icommentaire;
import interfaces.Ivote;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Commentaire;
import models.Vote;
import utils.MaConnexion;
import interfaces.Iutilisateur;
import models.Utilisateur;

/**
 *
 * @author Haroun
 */
public class ServiceVote implements Ivote{
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    Icommentaire interaceCommentaire = new ServiceCommentaire();
    Iutilisateur su = new ServiceUtilisateur();
    ServiceCommentaire sc = new ServiceCommentaire();
    
    
    @Override
    public boolean checkVote(Utilisateur u, Commentaire c) {
        List<Vote> votes = new ArrayList<>();
        String req="SELECT * FROM vote WHERE id_user="+u.getId()+" and id_source="+c.getId()+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){               
              votes.add(new Vote(rs.getInt("id"),rs.getInt(2),sc.RetrieveCommentaires(rs.getInt("id_source")),su.retrieveUtilisateur(rs.getInt("id_user"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (votes.isEmpty()) 
                return true;
        return false;
    }

    @Override
    public boolean ajouterVote(Vote v) {
        if (checkVote(v.getId_user(), v.getId_source())==false){
        
            System.out.println("vous avez deja voté");
            return false;
        }
        
        String request = "INSERT INTO `vote`(`id`, `type`, `id_source`, `id_user`) VALUES ("+v.getId()+","+v.getType()+","+v.getId_source().getId()+","+v.getId_user().getId()+")";
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
    public List<Vote> afficherVote() {
        List<Vote> votes = new ArrayList<>();
        String req="SELECT * FROM vote";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){               
              votes.add(new Vote(rs.getInt("id"),rs.getInt(2),sc.RetrieveCommentaires(rs.getInt("id_source")),su.retrieveUtilisateur(rs.getInt("id_user"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return votes;
    }

    @Override
    public boolean modifierVote(Vote v) {
        String req = "UPDATE `vote` SET `type`="+v.getType()+",`id_source`='"+v.getId_source().getId()+"', `id_user`='"+v.getId_user().getId()+"' WHERE `id` = "+v.getId()+" ";
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
    public boolean supprimerVote(Vote v) {
        String req = "DELETE FROM `vote` WHERE `id` = "+v.getId()+" ";

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
    public List<Vote> TriVote() {
        List<Vote> votes = new ArrayList<>();
        String req="SELECT * FROM vote ORDER BY type ASC";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){               
              votes.add(new Vote(rs.getInt("id"),rs.getInt(2),sc.RetrieveCommentaires(rs.getInt("id_source")),su.retrieveUtilisateur(rs.getInt("id_user"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return votes;
    }

    @Override
    public List<Vote> SearchVote(int id_source) {
        List<Vote> votes = new ArrayList<>();
        String req="SELECT * FROM vote WHERE id_source="+id_source+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){               
              votes.add(new Vote(rs.getInt("id"),rs.getInt(2),sc.RetrieveCommentaires(rs.getInt("id_source")), su.retrieveUtilisateur(rs.getInt("id_user"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return votes;
    }

    @Override
    public Vote RetrieveVote(int id_source, int id_user) {
        Vote v = null;
        String req="SELECT * FROM vote WHERE id_source="+id_source+" AND id_user="+id_user+"  ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if(rs.next()){
                v = new Vote(rs.getInt("id"),rs.getInt("type"), sc.RetrieveCommentaires(rs.getInt("id_source")), su.retrieveUtilisateur(rs.getInt("id_user")));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        return v;
    }

    
    
}
