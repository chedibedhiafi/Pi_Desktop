/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.Icommentaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Commentaire;
import util.MaConnexion;

/**
 *
 * @author Haroun
 */
public class ServiceCommentaire implements Icommentaire {
    
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterCommentaire(Commentaire c) {
        String request = "INSERT INTO `commentaire`(`contenu`, `date`) VALUES ('"+c.getContenu()+"','"+c.getDate()+"')";
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
              commentaires.add(new Commentaire(rs.getInt("id"),rs.getString(2),rs.getString(3),"yyyy-M-d" ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaires;
    }

    @Override
    public boolean modifierCommentaire(Commentaire c) {
        String req = "UPDATE `commentaire` SET `contenu`='"+c.getContenu()+"',`date`='"+c.getDate()+"' WHERE `id` = "+c.getId()+" ";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }
    }
    
}
