/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IpointDeVente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import models.PointDeVente;
import utils.MaConnexion;

/**
 *
 * @author 21694
 */

public class ServicePointDeVente implements IpointDeVente{
    
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public PointDeVente ajouterPointDeVente(PointDeVente p) {       
        String request = "INSERT INTO `pointdevente`(`name`, `proprietaire`, `adresse`, `date_ouverture`) VALUES ('"+p.getName()+"','"+p.getProprietaire()+"','"+p.getAdresse()+"','"+p.getDate_ouverture()+"')";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request, Statement.RETURN_GENERATED_KEYS) == 1){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next())
                    p.setReference(rs.getInt(1));
            }
                
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return p;
        }
        return p;
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
                pointdeventes.add(new PointDeVente(rs.getInt("reference"),rs.getString("name"),rs.getString("proprietaire"),rs.getString("adresse"),rs.getDate("date_ouverture")));
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
    public boolean supprimerPointDeVente(PointDeVente p) {
        String req = "DELETE FROM `pointdevente` WHERE `reference` = "+p.getReference()+" ";

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
    public List<PointDeVente> chercherPointDeVente(List<PointDeVente> initialList, String input) {
        List<PointDeVente> strList = initialList.stream()
                           .map( PointDeVente::concat )
                           .filter(pt -> pt.toLowerCase().contains(input.toLowerCase()))
                           .map(pt -> new PointDeVente(Integer.parseInt(pt.split(".@.")[0]),pt.split(".@.")[1],pt.split(".@.")[2],pt.split(".@.")[3],Date.valueOf(pt.split(".@.")[4])))
                           .collect( Collectors.toList() );
        
        return strList;
    }

    @Override
    public PointDeVente retrievePointDeVente(int reference) {
        PointDeVente pointdevente = null;

        String req="SELECT * FROM pointdevente WHERE reference = "+reference+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if(rs.next()){
                pointdevente = new PointDeVente(rs.getInt("reference"),rs.getString("name"),rs.getString("proprietaire"),rs.getString("adresse"),rs.getDate("date_ouverture"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return pointdevente;
    }   

    @Override
    public PointDeVente retrievePointDeVente(String name) {
        PointDeVente pointdevente = null;

        String req="SELECT * FROM pointdevente WHERE name = "+name+"";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            if(rs.next()){
                pointdevente = new PointDeVente(rs.getInt("reference"),rs.getString("name"),rs.getString("proprietaire"),rs.getString("adresse"),rs.getDate("date_ouverture"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return pointdevente;
    }
}
