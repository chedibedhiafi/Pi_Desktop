/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Istock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Stock;
import utils.MaConnexion;

/**
 *
 * @author 21694
 */
public class ServiceStock implements Istock{
    
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterStock(Stock s) {
        String request = "INSERT INTO `stock`(`id_produit`, `id_pointdevente`, `quantite`) VALUES ("+s.getId_produit()+","+s.getId_pointdevente()+","+s.getQuantite()+")";
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
    public List<Stock> afficherStocks() {
        List<Stock> stocks = new ArrayList<Stock>();

        String req="SELECT * FROM stock";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                stocks.add(new Stock(rs.getInt("id_produit"),rs.getInt("id_pointdevente"),rs.getInt("quantite")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return stocks;
    }

    @Override
    public boolean modifierStock(Stock s) {
        String req = "UPDATE `stock` SET `quantite`="+s.getQuantite()+" WHERE `id_produit` = "+s.getId_produit()+" AND `id_pointdevente` = "+s.getId_pointdevente()+" ";
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
    public boolean supprimerStock(Stock s) {
        String req = "DELETE FROM `stock` WHERE `id_produit` = "+s.getId_produit()+" AND `id_pointdevente` = "+s.getId_pointdevente()+" ";

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
