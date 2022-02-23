/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import interfaces.IService;
import java.sql.Connection;
import models.Event;
import services.ServiceEvent;
import utils.MyDB;
import java.sql.Date;
import models.Rate;
import models.Reservation;
import services.ServiceRate;
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
        IService se = new ServiceEvent();
        // se.ajout(new Event(new Date(-1900+2021,1+9,22),"efe",5.2,"fe","fe"));
        // se.modifier(new Event(13,new Date(-1900+2021,1+9,22),"ouuh",5.2,"ouh","ouh"));
        // AFFICHER
        //System.out.println(se.afficher());
       // se.supprimer(se.retrieve(14));
        
        //reservation
        Reservation r = new Reservation(10, new Date(-1900+2021,1+9,22), 20.0,(Event)se.retrieve(17));
        //Reservation r1 = new Reservation(4,10, new Date(-1900+2021,1+9,22), 25.0, 17);
        //service
        IService sr = new ServiceReservation();
        //sr.ajout(r);
        //sr.modifier(r);
        //sr.supprimer(r);
        // AFFICHER
        //System.out.println(sr.afficher());
        
        
       //rate
       Rate r2 = new Rate();
       //service
       ServiceRate sr1 = new ServiceRate();
       //sr1.ajouter (new Rate( 15 ,1, 40.0));
     // boolean Ok ;
      //Ok = sr1.isRated(9, 15);
      //afficher
      //System.out.println(Ok);
    }
    
}
