/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iemploye;
import interfaces.IpointDeVente;
import interfaces.Iutilisateur;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Employe;
import models.Utilisateur;
import utils.MaConnexion;

/**
 *
 * @author 21694
 */
public class ServiceEmploye implements Iemploye{
    
    Connection cnx = MaConnexion.getInstance().getCnx();
    Iutilisateur su = new ServiceUtilisateur();
    IpointDeVente sp = new ServicePointDeVente();

    @Override
        public boolean ajouterEmploye(Employe e) {
        
        if(su.ajouterUtilisateur(e).getId()==0)
            return false;
                
        String request = "INSERT INTO `employe`(`id`,`role`,`id_pointdevente`) VALUES ("+e.getId()+",'"+e.getRole()+"',"+e.getPdv().getReference()+") ";
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

        String req="SELECT * FROM employe RIGHT JOIN utilisateur on employe.id = utilisateur.id";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                employes.add(new Employe(sp.retrievePointDeVente(rs.getInt("id_pointdevente")),rs.getString("role"),rs.getInt("id"),rs.getString("login"),rs.getString("mdp"),rs.getDate("date_naissance"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("tentative"),rs.getDate("unlock_date")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return employes;
    }

    @Override
    public boolean modifierEmploye(Employe e) {
        if(!su.modifierUtilisateur(e))
            return false;
        String req = "UPDATE `employe` SET `id_pointdevente`="+e.getPdv().getReference()+",`role`='"+e.getRole()+"'";
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
            if (st.executeUpdate(req) == 1){
                if(su.supprimerUtilisateur(e))
                    return true;
                }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
    
}
