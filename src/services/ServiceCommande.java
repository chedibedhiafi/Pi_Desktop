/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icommande;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Commande;
import utils.MaConnexion;

/**
 *
 * @author ASUS
 */

    public class ServiceCommande implements Icommande{
    
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterCommande(Commande c) {
        String request = "INSERT INTO `commande` (`id_commande`,`date_creation`,`date_envoie`)VALUES ("+c.getId_commande()+",'"+c.getDate_creation()+"','"+c.getDate_envoie()+"')";
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
    public List<Commande> afficherCommandes() {
        List<Commande> commandes = new ArrayList<Commande>();

        String req="SELECT * FROM commande";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                commandes.add(new Commande(rs.getInt("id_commande"),rs.getString("date_creation"),rs.getString("date_envoie")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return commandes;
    }
    
   

    @Override
    public boolean supprimerCommande(Commande c) {
        String req = "DELETE FROM `commande` WHERE `id_commande` = "+c.getId_commande()+" ";

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
    public boolean modifierCommande(Commande c) {
        String req = "UPDATE `commande` SET `date_creation`='"+c.getDate_creation()+"',`date_envoie`='"+c.getDate_envoie()+"' WHERE `id_commande` = "+c.getId_commande()+" ";
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
