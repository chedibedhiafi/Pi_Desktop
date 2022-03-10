/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Event;
import models.Reservation;
import utils.MaConnexion;

/**
 *
 * @author SOULAYMA
 */
public class ServiceEvent implements IService<Event> {

 Connection cnx;

    public ServiceEvent() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajout(Event t) {
        try {
            String req = "insert into event (Date_Event,Titre,Prix,Description) values"
                    + " ( '" + t.getDate_Event() + "', '" + t.getTitre() + "','" + t.getPrix() + "','" + t.getDescription() + "')";
            Statement st = cnx.createStatement();
            if(st.executeUpdate(req)==1)
                System.out.println("aaaa");
                    
        } catch (SQLException ex) {
            ex.printStackTrace();       
        }
        
    }

    @Override
    public void modifier(Event t) {
        try {
            String req = "update event set Date_Event = ? ,Titre  = ? ,Prix  = ? ,Image = ?   "
                    + ",Description = ? where Event_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1, t.getDate_Event());
            ps.setString(2, t.getTitre());
            ps.setString(3, t.getPrix());
            ps.setString(4, t.getImage());
            ps.setString(5, t.getDescription());
            ps.setInt(6, t.getEvent_Id ());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
       public void supprimer(int Client_Id) {
        try {
            String req = "delete from Event where Event_Id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Client_Id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
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
                e.setPrix(rs.getString("Prix"));
                e.setImage(rs.getString("Image"));
                e.setDescription(rs.getString("Description"));


                list.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public List<Event> afficherListView() {
        List<Event> list = new ArrayList<>();
        try {
            String req ="select * from Event";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
               Event a = new Event();
               
                a.setTitre(rs.getString("Titre"));
                a.setDescription(rs.getString("Description"));
                                a.setPrix(rs.getString("Prix"));
                a.setDate_Event(rs.getDate("Date_Event"));

             
                list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
    
    
    @Override
    public Event retrieve(int id) {
         Event e = new Event();
        try {
            String req ="select * from event WHERE Event_Id ="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            if(rs.next()){
                e.setEvent_Id(rs.getInt(1));
                e.setDate_Event(rs.getDate("Date_Event"));
                e.setTitre(rs.getString("Titre"));
                e.setPrix(rs.getString("Prix"));
                e.setDescription(rs.getString("Image"));
                e.setDescription(rs.getString("Description"));

                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }
    
     
    


    public void supprimerEvent(Event c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
 
    