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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        String request = "INSERT INTO `commande` (`id`,`date_creation`,`date_envoie`)VALUES ("+c.getId()+",'"+c.getDate_creation()+"','"+c.getDate_envoie()+"')";
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
                Commande c=new Commande(rs.getInt("id"),rs.getDate("date_creation"),rs.getDate("date_envoie"));
                System.out.println(c.toString()+"***********");
                commandes.add(new Commande(rs.getInt("id"),rs.getDate("date_creation"),rs.getDate("date_envoie")));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return commandes;
    }
    
   

    @Override
    public boolean supprimerCommande(Commande c) {
        String req = "DELETE FROM `commande` WHERE `id` = "+c.getId()+" ";

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
        String req = "UPDATE `commande` SET `date_creation`='"+c.getDate_creation()+"',`date_envoie`='"+c.getDate_envoie()+"' WHERE `id` = "+c.getId()+" ";
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
    public Commande retrieveCommande(int id) {
        Commande c = null;

        String req="SELECT * FROM commande where id = "+id+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if(rs.next()){
                c=new Commande(rs.getInt("id"),rs.getDate("date_creation"),rs.getDate("date_envoie"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

public ObservableList<Commande> afficherCommandesV2() {
      
        ObservableList<Commande> commandes = FXCollections.observableArrayList();

        String req="SELECT * FROM commande";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                commandes.add(new Commande(rs.getInt("id"),rs.getDate("date_creation"),rs.getDate("date_envoie")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return commandes;
    }  

    public Boolean iSRemise(int id){
        Boolean hasRemise;

        String req="SELECT MOD(count(*),3) FROM commande where id_user="+id;
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                if(rs.getInt(1)==0)
                {
                    return true;
                    
                }
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
}
