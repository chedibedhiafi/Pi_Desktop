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

/**
 *
 * @author Haroun
 */
public class ServiceVote implements Ivote{
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    Icommentaire interaceCommentaire = new ServiceCommentaire();
    ServiceCommentaire sc = new ServiceCommentaire();

    @Override
    public boolean ajouterVote(Vote v) {
        String request = "INSERT INTO `vote`(`id`, `type`, `id_source`) VALUES ("+v.getId()+","+v.getType()+","+v.getId_source().getId()+")";
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
              votes.add(new Vote(rs.getInt("id"),rs.getInt(2),sc.RetrieveCommentaires(rs.getInt("id_source"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return votes;
    }

    @Override
    public boolean modifierVote(Vote v) {
        String req = "UPDATE `vote` SET `type`="+v.getType()+",`id_source`='"+v.getId_source().getId()+"' WHERE `id` = "+v.getId()+" ";
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
              votes.add(new Vote(rs.getInt("id"),rs.getInt(2),sc.RetrieveCommentaires(rs.getInt("id_source"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return votes;
    }

    @Override
    public List<Vote> SearchVote(int id_source) {
        List<Vote> votes = new ArrayList<>();
        String req="SELECT * FROM vote WHERE id_source='"+id_source+"'";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){               
              votes.add(new Vote(rs.getInt("id"),rs.getInt(2),sc.RetrieveCommentaires(rs.getInt("id_source"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return votes;
    }
    
}
