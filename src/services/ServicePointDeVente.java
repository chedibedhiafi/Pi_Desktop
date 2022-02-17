/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IpointDeVente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import models.PointDeVente;
import utils.MaConnexion;

/**
 *
 * @author 21694
 */
public class ServicePointDeVente implements IpointDeVente{
    
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterPointDeVente(PointDeVente p) {       
        String request = "INSERT INTO `pointdevente`(`name`, `proprietaire`, `adresse`, `date_ouverture`) VALUES ('"+p.getName()+"','"+p.getProprietaire()+"','"+p.getAdresse()+"','"+p.getDate_ouverture()+"')";
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
    public List<PointDeVente> afficherPointDeVentes() {
        List<PointDeVente> pointdeventes = new ArrayList<PointDeVente>();

        String req="SELECT * FROM pointdevente";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                pointdeventes.add(new PointDeVente(rs.getInt("reference"),rs.getString("name"),rs.getString("proprietaire"),rs.getString("adresse"),rs.getString("date_ouverture"),"yyyy-M-d"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return pointdeventes;
    }

    @Override
    public boolean modifierPointDeVente(PointDeVente p) {
        String req = "UPDATE `pointdevente` SET `name`='"+p.getName()+"',`proprietaire`='"+p.getProprietaire()+"',`adresse`='"+p.getAdresse()+"',`date_ouverture`='"+p.getDate_ouverture()+"' WHERE `reference` = "+p.getReference()+" ";
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
    public boolean supprimerPointDeVente(int reference) {
        String req = "DELETE FROM `pointdevente` WHERE `reference` = "+reference+" ";

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
