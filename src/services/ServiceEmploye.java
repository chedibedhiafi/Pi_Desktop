/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iemploye;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Employe;
import utils.MaConnexion;

/**
 *
 * @author 21694
 */
public class ServiceEmploye implements Iemploye{
    
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterEmploye(Employe e) {
        String request = "INSERT INTO `employe`(`login`,`mdp`,`date_naissance`,`nom`, `prenom`, `email`, `role`) VALUES ('"+e.getLogin()+"','"+e.getMdp()+"','"+e.getDate_naissance()+"','"+e.getNom()+"','"+e.getPrenom()+"','"+e.getEmail()+"','"+e.getRole()+"') ";
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
    public List<Employe> afficherEmployes() {
        List<Employe> employes = new ArrayList<Employe>();

        String req="SELECT * FROM employe";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                employes.add(new Employe(rs.getString(8),rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),"yyyy-M-d"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return employes;
    }

    @Override
    public boolean modifierEmploye(Employe e) {
        String req = "UPDATE `employe` SET `login`='"+e.getLogin()+"',`mdp`='"+e.getMdp()+"',`date_naissance`='"+e.getDate_naissance()+"',`nom`='"+e.getNom()+"',`prenom`='"+e.getPrenom()+"',`email`='"+e.getEmail()+"',`role`='"+e.getRole()+"' WHERE `id` = "+e.getId()+" ";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerEmploye(Employe e) {
        String req = "DELETE FROM `employe` WHERE `id` = "+e.getId()+" ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
