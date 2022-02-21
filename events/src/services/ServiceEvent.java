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
import utils.MyDB;

/**
 *
 * @author SOULAYMA
 */
public class ServiceEvent implements IService<Event> {

 Connection cnx;

    public ServiceEvent() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajout(Event t) {
        try {
            String req = "insert into event (Date_Event,Titre,Prix,Image,Description) values"
                    + " ( '" + t.getDate_Event() + "', '" + t.getTitre() + "','" + t.getPrix() + "','" + t.getImage() + "','" + t.getDescription() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();       
        }
        
    }

    @Override
    public void modifier(Event t) {
        try {
            String req = "update event set Date_Event = ? ,Titre  = ? ,Prix  = ? ,Image = ? "
                    + ",Description  = ? where Event_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1, t.getDate_Event());
            ps.setString(2, t.getTitre());
            ps.setDouble(3, t.getPrix());
            ps.setString(4, t.getImage());
            ps.setString(5, t.getDescription());
            ps.setInt(6, t.getEvent_Id ());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void supprimer(int Event_Id) {
        try {
            String req = "delete from event where event_id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Event_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Event> afficher() {
        List<Event> list = new ArrayList<>();
        try {
            String req ="select * from event";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Event e = new Event();
                e.setEvent_Id(rs.getInt(1));
                e.setDate_Event(rs.getDate("Date_Event"));
                e.setTitre(rs.getString("Titre"));
                e.setPrix(rs.getDouble("Prix"));
               e.setDescription(rs.getString("Image"));

                e.setDescription(rs.getString("Description"));

                list.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    
}