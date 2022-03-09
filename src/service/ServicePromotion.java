/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.Ipromotion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Promotion;
/**
 *
 * @author chedi
 */
public class ServicePromotion implements Ipromotion{
     Connection cnx = utils.MaConnexion.getInstance().getCnx();

    @Override
    public Promotion retrivepromotion(int id) {
         Promotion promotion =  null;
           String req="SELECT * FROM promotion WHERE id = '"+id+"' ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while(rs.next()){
                promotion=new Promotion(rs.getInt("id"),rs.getInt("percentage"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return promotion;
    }

    @Override
    public Promotion retrievePromotionBypercentage(int percentage) {
           Promotion p = new Promotion();
        String query = "SELECT * FROM promotion WHERE percentage = " + percentage + " ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setPercentage(rs.getInt("percentage"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
       @Override
    public boolean ajouterPromotion(Promotion p) {
String request = "INSERT INTO `promotion`(`percentage`) VALUES ('"+p.getPercentage()+"')"; 
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
    public List<Promotion> afficherPromotion() {
          List<Promotion> promotions = new ArrayList<Promotion>();
           String req="SELECT * FROM promotion";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                promotions.add(new Promotion(rs.getInt("id"),rs.getInt("percentage")));
               
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return promotions;
        
    }

 

   
    
}
