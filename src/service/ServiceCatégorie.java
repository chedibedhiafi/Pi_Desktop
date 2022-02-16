/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.Icatégorie;
import modele.Catégorie;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author chedi
 */
public class ServiceCatégorie implements Icatégorie{
    
    
    Connection cnx = util.MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterCatégorie(Catégorie c) {
        String request = "INSERT INTO `catégorie`(`nom`) VALUES ('"+c.getNom()+"')";
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
    public List<Catégorie> afficherCatégorie() {
         List<Catégorie> catégories = new ArrayList<Catégorie>();
                   String req="SELECT * FROM catégorie";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                catégories.add(new Catégorie(rs.getInt("id"),rs.getString("nom")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return catégories;
         
    }

    @Override
    public boolean modifierCatégorie(Catégorie c) {
         String req = "UPDATE `catégorie` SET `nom`='"+c.getNom()+"' WHERE id = "+c.getId()+" ";
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
    public boolean supprimerCatégorie(Catégorie c) {
               String req = "DELETE FROM `catégorie` WHERE id = "+c.getId()+" ";

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
    

