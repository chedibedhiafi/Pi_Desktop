/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iutilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Utilisateur;
import utils.MaConnexion;

/**
 *
 * @author 21694
 */
public class ServiceUtilisateur implements Iutilisateur{
    
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterUtilisateur(Utilisateur u) {
        String request = "INSERT INTO `utilisateur`(`login`,`mdp`,`date_naissance`,`nom`, `prenom`, `email`) VALUES ('"+u.getLogin()+"','"+u.getMdp()+"','"+u.getDate_naissance()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getEmail()+"')";
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
    public List<Utilisateur> afficherUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        String req="SELECT * FROM utilisateur";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                utilisateurs.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),"yyyy-M-d"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return utilisateurs;
    }

    @Override
    public boolean modifierUtilisateur(Utilisateur u) {
        String req = "UPDATE `utilisateur` SET `login`='"+u.getLogin()+"',`mdp`='"+u.getMdp()+"',`date_naissance`='"+u.getDate_naissance()+"',`nom`='"+u.getNom()+"',`prenom`='"+u.getPrenom()+"',`email`='"+u.getEmail()+"' WHERE `id` = "+u.getId()+" ";
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
    public boolean supprimerUtilisateur(Utilisateur u) {
        String req = "DELETE FROM `utilisateur` WHERE `id` = "+u.getId()+" ";

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
