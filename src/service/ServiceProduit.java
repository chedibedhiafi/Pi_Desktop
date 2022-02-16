/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.Iproduits;
import modele.Produit;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chedi
 */
public class ServiceProduit implements Iproduits{
    
     Connection cnx = util.MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterProduit(Produit p) {
            String request = "INSERT INTO `produits`(`nom`, `prix`, `image`) VALUES ('"+p.getNom()+"',"+p.getPrix()+",'"+p.getImage()+"')";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                    return true;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        
    }

    @Override
    public List<Produit> afficherProduit() {
        List<Produit> produits = new ArrayList<Produit>();
           String req="SELECT * FROM produits";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                produits.add(new Produit(rs.getInt("id"),rs.getString("nom"),rs.getInt("prix"),rs.getString("image")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return produits;
    }
    

    @Override
    public boolean modifierProduit(Produit p) {
       String req = "UPDATE `produits` SET `nom`='"+p.getNom()+"',`prix`="+p.getPrix()+",`image`='"+p.getImage()+"' WHERE id = "+p.getId()+" ";
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
    public boolean supprimerProduit(Produit p) {
       String req = "DELETE FROM `produits` WHERE id = "+p.getId()+" ";

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
