/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Event;
import models.Reservation;
import utils.MaConnexion;

/**
 *
 * @author SOULAYMA
 */
public class ServiceReservation implements IService<Reservation> {

 Connection cnx;
 IService se = new ServiceEvent();

    public ServiceReservation() {
        cnx = MaConnexion.getInstance().getCnx();
        
    }

    @Override
    public void ajout(Reservation t) {
        try {
            String req = "insert into Reservation (Nb_Places , Date_Achat , Total , FK_Event) values"
                    + " ( '" + t.getNb_Places() + "', '" + t.getDate_Achat() + "','" + t.getTotal() + "','" + t.getE().getEvent_Id()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void modifier(Reservation t) {
        try {
            String req = "update reservation set Nb_Places = ? , Date_Achat = ?  , Total = ? , FK_Event = ?  where Reserv_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getNb_Places());
            ps.setDate(2, t.getDate_Achat());
            ps.setDouble(3, t.getTotal());
            ps.setInt(5, t.getReserv_Id ());
            ps.setInt(4, ((Event)t.getE()).getEvent_Id());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void supprimer(Reservation r) {
        try {
            String req = "delete from reservation where Reserv_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, r.getReserv_Id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Reservation> afficher() {
        List<Reservation> list = new ArrayList<>();
        try {
            String req ="select * from Reservation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Reservation e = new Reservation();
                e.setReserv_Id(rs.getInt(1));
                e.setDate_Achat(rs.getDate("Date_Achat"));
                e.setNb_Places(rs.getInt("Nb_Places"));
                e.setTotal(rs.getDouble("Total"));
                e.setE((Event)se.retrieve(rs.getInt("FK_Event")));

                list.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Reservation retrieve(int id) {
        Reservation r = new Reservation();
        try {
            String req ="select * from Reservation where Reserv_Id = "+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            if(rs.next()){
                Reservation e = new Reservation();
                e.setReserv_Id(rs.getInt(1));
                e.setDate_Achat(rs.getDate("Date_Achat"));
                e.setNb_Places(rs.getInt("Nb_Places"));
                e.setTotal(rs.getDouble("Total"));
                e.setE((Event)se.retrieve(rs.getInt("FK_Event")));

                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return r;
    }
 
    
}
