/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import models.Rate;
import utils.MyDB;

/**
 *
 * @author SOULAYMA
 */
public class ServiceRate {
       Connection cnx;

    public ServiceRate() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    public void ajouter(Rate t) {
        try {
            String req = "INSERT INTO Rate (Event_Id ,Client_Id, Sum) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getEvent_Id());
            pst.setInt(2, t.getClient_Id());
            pst.setDouble(3, t.getSum());
            pst.executeUpdate();
            System.out.println("Rate  ajouté avec succès !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public boolean isRated(int Rate_Id, int Event_Id) {
          try {
                    String req = "SELECT * from Rate  where Event_Id= "+Event_Id+"";
                    Statement st = cnx.createStatement();
                    ResultSet rst = st.executeQuery(req);
                    if (rst.next()) {
                        return true;
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
          return false; 
            }

    public void supprimer(int t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void modifier(Rate t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public List<Rate> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     *
     * @param t
     */
    public void ajout(Rate t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   
}

