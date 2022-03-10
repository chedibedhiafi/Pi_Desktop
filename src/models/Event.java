/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author SOULAYMA
 */
  public class Event {
 private int Event_Id;
 private Date Date_Event;
 private String Titre;
 private String Prix;
 private String Image;
 private String Description;

    public Event(int Event_Id, Date Date_Event, String Titre, String Prix, String Description) {
        this.Event_Id = Event_Id;
        this.Date_Event = Date_Event;
        this.Titre = Titre;
        this.Prix = Prix;
        this.Description = Description;
    }

    public Event(int Event_Id, Date Date_Event, String Titre, String Prix) {
        this.Event_Id = Event_Id;
        this.Date_Event = Date_Event;
        this.Titre = Titre;
        this.Prix = Prix;
    }



    public Event(int Event_Id, Date Date_Event, String Titre, String Prix, String Image, String Description) {
        this.Event_Id = Event_Id;
        this.Date_Event = Date_Event;
        this.Titre = Titre;
        this.Prix = Prix;
        this.Image = Image;
        this.Description = Description;
    }

    public Event(Date Date_Event, String Titre, String Prix, String Image, String Description) {
        this.Date_Event = Date_Event;
        this.Titre = Titre;
        this.Prix = Prix;
        this.Image = Image;
        this.Description = Description;
    }

 

    public Event() {
    }

  
    

    public int getEvent_Id() {
        return Event_Id;
    }

    public void setEvent_Id(int Event_Id) {
        this.Event_Id = Event_Id;
    }

    public Date getDate_Event() {
        return Date_Event;
    }

    public void setDate_Event(Date Date_Event) {
        this.Date_Event = Date_Event;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getPrix() {
        return Prix;
    }

    public void setPrix(String Prix) {
        this.Prix = Prix;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

  

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

   

    @Override
    public String toString() {
        return "Event{" + "Event_Id=" + Event_Id + ", Date_Event=" + Date_Event + ", Titre=" + Titre + ", Prix=" + Prix + ", Image=" + Image + ", Description=" + Description + '}';
    }

    public void setNom_Event(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getNom_Event() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNom_Organisateur(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getNom_Organisateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPrenom_Organisateur(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getPrenom_Organisateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRegion(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getRegion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTel_Portable(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getTel_Portable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTel_Fix(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getTel_Fix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDate_Evenement(Date valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getDate_Evenement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
