/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import models.Event;
import services.ServiceEvent;
import utils.MyDB;
import java.sql.Date;
import models.Reservation;
import services.ServiceReservation;

/**
 *
 * @author SOULAYMA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection cnx = MyDB.getInstance().getCnx();
        // Event
        Event e = new Event ();

        // SERVICE
        ServiceEvent se = new ServiceEvent();
         // se.ajout(new Event(new Date(-1900+2021,1+9,22),"efe",5.2,"fe","fe"));
      
  
        // se.modifier(new Event(13,new Date(-1900+2021,1+9,22),"ouuh",5.2,"ouh","ouh"));
        // AFFICHER
        //System.out.println(se.afficher());
        //se.supprimer(13);
        
        //reservation
         Reservation r = new Reservation(10, new Date(-1900+2021,1+9,22), 20.0, 19);
        Reservation r1 = new Reservation(4,10, new Date(-1900+2021,1+9,22), 25.0, 17);
        //service
        ServiceReservation sr = new ServiceReservation();
        //sr.ajout(r);
        //sr.modifier(r1);
        //sr.supprimer(4);
        // AFFICHER
        System.out.println(sr.afficher());

    }
    
}
