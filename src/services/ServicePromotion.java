/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ipromotion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String query = "SELECT * FROM promotion WHERE percentage = '" + p.getPercentage() + "' ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setPercentage(rs.getInt(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

   
    
}
