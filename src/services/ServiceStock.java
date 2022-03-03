/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IhistoriqueStock;
import interfaces.IpointDeVente;
import interfaces.Iproduits;
import interfaces.Istock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Produit;
import models.Stock;
import utils.MaConnexion;

/**
 *
 * @author 21694
 */
public class ServiceStock implements Istock{
    
    Connection cnx = MaConnexion.getInstance().getCnx();
    ServiceProduit interfaceProduits = new ServiceProduit();
    ServicePointDeVente interfacePointDeVente = new ServicePointDeVente();


    @Override
    public boolean ajouterStock(Stock s) {
        String request = "INSERT INTO `stock`(`id_produit`, `id_pointdevente`, `quantite`) VALUES ("+s.getProduit().getId()+","+s.getPointdevente().getReference()+","+s.getQuantite()+")";
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
                stocks.add(new Stock(interfaceProduits.retriveproduit(rs.getInt("id_produit")),interfacePointDeVente.retrievePointDeVente(rs.getInt("id_pointdevente")),rs.getInt("quantite")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return stocks;
    }

    @Override
    public boolean modifierStock(Stock s) {
        String req = "UPDATE `stock` SET `quantite`="+s.getQuantite()+" WHERE `id_produit` = "+s.getProduit().getId()+" AND `id_pointdevente` = "+s.getPointdevente().getReference()+" ";
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
        String req = "DELETE FROM `stock` WHERE `id_produit` = "+s.getProduit().getId()+" AND `id_pointdevente` = "+s.getPointdevente().getReference()+" ";

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
    public Stock retrieveStock(int id_produit, int id_pointDeVente) {
        Stock stock = null;

        String req="SELECT * FROM stock WHERE id_produit = "+id_produit+" AND id_pointdevente = "+id_pointDeVente+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if(rs.next()){
                stock = new Stock(interfaceProduits.retriveproduit(rs.getInt("id_produit")),interfacePointDeVente.retrievePointDeVente(rs.getInt("id_pointdevente")),rs.getInt("quantite"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return stock;

    }

    @Override
    public List<Stock> findProduit(Produit p, int quantite) {
        List<Stock> stocks = new ArrayList<Stock>();

        String req="SELECT * FROM stock where id_produit = "+p.getId()+" AND quantite > "+quantite+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                stocks.add(new Stock(interfaceProduits.retriveproduit(rs.getInt("id_produit")),interfacePointDeVente.retrievePointDeVente(rs.getInt("id_pointdevente")),rs.getInt("quantite")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return stocks;
        
    }

    @Override
    public Stock retrieveStock(Stock stock) {
        Stock newStock = null;

        String req="SELECT * FROM stock WHERE id_produit = "+stock.getProduit().getId()+" AND id_pointdevente = "+stock.getPointdevente().getReference()+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if(rs.next()){
                newStock = new Stock(interfaceProduits.retriveproduit(rs.getInt("id_produit")),interfacePointDeVente.retrievePointDeVente(rs.getInt("id_pointdevente")),rs.getInt("quantite"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return newStock;

    }

    @Override
    public List<Stock> findStockPointDeVente(PointDeVente pt) {
        List<Stock> stocks = new ArrayList<Stock>();

        String req="SELECT * FROM stock where id_pointdevente = "+pt.getReference()+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                stocks.add(new Stock(interfaceProduits.retriveproduit(rs.getInt("id_produit")),interfacePointDeVente.retrievePointDeVente(rs.getInt("id_pointdevente")),rs.getInt("quantite")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return stocks;

    }

   
            
}

