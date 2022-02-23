/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ilivraison;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Livraison;
import utils.MaConnexion;

/**
 *
 * @author ASUS
 */

    public class ServiceLivraison implements Ilivraison{
    
    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterLivraison(Livraison l) {
       
        String request = "INSERT INTO `livraison`(`frais_livraison`, `etat_livraison`, `num_livreur`) VALUES ("+l.getFrais_livraison()+",'"+l.getEtat_livraison()+"',"+l.getNum_livreur()+")";
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
    public List<Livraison> afficherLivraison() {
      
        List<Livraison> livraison = new ArrayList<Livraison>();

        String req="SELECT * FROM livraison";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

           
            while(rs.next()){
                livraison.add(new Livraison(rs.getInt("frais_livraison"),rs.getString("etat_livraison"),rs.getInt("num_livreur")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return livraison;
    }

    @Override
    public boolean modifierLivraison(Livraison l) {
        String req = "UPDATE `livraison` SET `etat_livraison`='"+l.getEtat_livraison()+"',`num_livreur`="+l.getNum_livreur()+" WHERE `frais_livraison` = "+l.getFrais_livraison()+" ";
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
    public boolean supprimerLivraison(Livraison l) {
       String req = "DELETE FROM `livraison` WHERE `frais_livraison` = "+l.getFrais_livraison()+" ";

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
