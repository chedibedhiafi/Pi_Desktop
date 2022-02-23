/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IhistoriqueStock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.HistoriqueStock;
import utils.MaConnexion;

/**
 *
 * @author 21624
 */
public class ServiceHistoriqueStock implements IhistoriqueStock{
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterHistoriqueStock(HistoriqueStock h) {
        String request = "INSERT INTO `historiquestock`(`id_produit`, `id_pointdevente`, `id_employe`, `date`, `quantite`) VALUES ("+h.getId_produit()+","+h.getId_pointdevente()+","+h.getId_employe()+",'"+h.getDate()+"',"+h.getQuantite()+")";
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
    public List<HistoriqueStock> afficherHistoriqueStocks() {
        List<HistoriqueStock> historiquestocks = new ArrayList<HistoriqueStock>();

        String req="SELECT * FROM historiquestock";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                historiquestocks.add(new HistoriqueStock(rs.getInt("reference"),rs.getInt("id_produit"),rs.getInt("id_pointdevente"),rs.getInt("id_employe"),rs.getString("date"), rs.getInt("quantite"), "yyyy-M-d"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return historiquestocks;
    }

    @Override
    public boolean modifierHistoriqueStock(HistoriqueStock h) {
        String req = "UPDATE `historiquestock` SET `id_produit`="+h.getId_produit()+",`id_pointdevente`="+h.getId_pointdevente()+",`id_employe`="+h.getId_employe()+",`date`='"+h.getDate()+"',`quantite`="+h.getQuantite()+" WHERE reference = "+h.getReference()+"";
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
    public boolean supprimerHistoriqueStock(int reference) {
        String req = "DELETE FROM `historiquestock` WHERE `reference` = "+reference+"";

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
