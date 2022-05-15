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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Produit;
import models.Stock;
import utils.MaConnexion;

/**
 *
 * @author 21624
 */
public class ServiceHistoriqueStock implements IhistoriqueStock{
    Connection cnx = MaConnexion.getInstance().getCnx();
    ServiceStock interfaceStock = new ServiceStock();
    ServiceProduit interfaceProduits = new ServiceProduit();
    ServicePointDeVente interfacePDeVente = new ServicePointDeVente();

    @Override
    public boolean ajouterHistoriqueStock(HistoriqueStock h) {
        
        if (interfaceStock.retrieveStock(h.getStock().getProduit().getId(), h.getStock().getPointdevente().getReference()) == null)
            interfaceStock.ajouterStock(h.getStock());
            
        String request = "INSERT INTO `historiquestock`(`id_produit`, `id_pointdevente`, `date`, `quantite`, `reason`) VALUES ("+h.getStock().getProduit().getId()+","+h.getStock().getPointdevente().getReference()+",'"+h.getDate()+"',"+h.getQuantite()+",'"+h.getReason()+"')";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1){
                
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<HistoriqueStock> afficherHistoriqueStocks() {
        List<HistoriqueStock> historiquestocks = new ArrayList<HistoriqueStock>();

        String req="SELECT * FROM historiquestock";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                historiquestocks.add(new HistoriqueStock(rs.getInt("reference"),interfaceStock.retrieveStock(rs.getInt("id_produit"), rs.getInt("id_pointdevente")),rs.getDate("date"), rs.getInt("quantite"), rs.getString("reason")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return historiquestocks;
    }

    @Override
    public boolean modifierHistoriqueStock(HistoriqueStock h) {
        String req = "UPDATE `historiquestock` SET `id_produit`="+h.getStock().getProduit().getId()+",`id_pointdevente`="+h.getStock().getPointdevente().getReference()+",`date`='"+h.getDate()+"',`quantite`="+h.getQuantite()+" WHERE reference = "+h.getReference()+"";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1){
                
                return true;}
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerHistoriqueStock(HistoriqueStock h) {
        String req = "DELETE FROM `historiquestock` WHERE `reference` = "+h.getReference()+"";
        

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1){
                
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertInHistoriqueStock(HistoriqueStock h) {
        if(h.getQuantite()>=0){
            ajouterHistoriqueStock(h);
            return true;
        }
        else{
            if(interfaceStock.retrieveStock(h.getStock()) == null){
                System.out.println("You don't have that item in stock");
                return false;
            }
            else if (interfaceStock.retrieveStock(h.getStock()).getQuantite() < (-h.getQuantite())){
                System.out.println("You don't have enough items in the stock");
                return false;
            }
            else{
                ajouterHistoriqueStock(h);
                return true;
            }
                
        }
    }

    @Override
    public List<HistoriqueStock> getFromStock(Stock s) {
    List<HistoriqueStock> historiquestocks = new ArrayList<HistoriqueStock>();

        String req="SELECT * FROM historiquestock where id_produit = "+s.getProduit().getId()+" AND id_pointdevente = "+s.getPointdevente().getReference()+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                historiquestocks.add(new HistoriqueStock(rs.getInt("reference"),interfaceStock.retrieveStock(rs.getInt("id_produit"), rs.getInt("id_pointdevente")),rs.getDate("date"), rs.getInt("quantite"), rs.getString("reason")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return historiquestocks;
    }
    
    

    @Override
    public List<Produit> bestSellersThisMonth(Date date) {
        List<HistoriqueStock> historiquestocks = new ArrayList<HistoriqueStock>();
        List<Produit> list = new ArrayList<Produit>();
        //String req="SELECT * FROM historiquestock where WHERE MONTH(dqte) = 1 ";
        String req1="SELECT id_produit,SUM(quantite) from historiquestock WHERE quantite < 0 AND MONTH(date) = MONTH('"+date+"') GROUP BY id_produit ORDER BY quantite ASC ; ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req1);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                historiquestocks.add(new HistoriqueStock(new Stock (interfaceProduits.retriveproduit(rs.getInt(1)), new PointDeVente()),date, rs.getInt(2), ""));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        Collections.sort(historiquestocks, (HistoriqueStock o1, HistoriqueStock o2) -> ((int) (o2.getStock().getProduit().getPrix()*o2.getStock().getProduit().getProfit())*(-o2.getQuantite())) - ((int) (o1.getStock().getProduit().getPrix()*o1.getStock().getProduit().getProfit())*(-o1.getQuantite())));
        
        for (HistoriqueStock hist : historiquestocks){
            list.add(hist.getStock().getProduit());
        }
        return list;
    }

    @Override
    public List<HistoriqueStock> getHistoriquePt(PointDeVente pt, Date date) {
        List<HistoriqueStock> historiquestocks = new ArrayList<HistoriqueStock>();

        String req="SELECT * FROM historiquestock where id_pointdevente = "+pt.getReference()+" AND MONTH(date) = MONTH('"+date+"') AND YEAR(date) = YEAR('"+date+"')";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                historiquestocks.add(new HistoriqueStock(rs.getInt("reference"),interfaceStock.retrieveStock(rs.getInt("id_produit"), rs.getInt("id_pointdevente")),rs.getDate("date"), rs.getInt("quantite"), rs.getString("reason")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return historiquestocks;
    }
    
    
    
}
