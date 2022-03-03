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
 private Double Prix;
 private String Image;
 private String Description;
 private int Fk_Reserv;

    public Event() {
    }

    public Event(int Event_Id, Date Date_Event, String Titre, Double Prix, String Image, String Description) {
        this.Event_Id = Event_Id;
        this.Date_Event = Date_Event;
        this.Titre = Titre;
        this.Prix = Prix;
        this.Image = Image;
        this.Description = Description;
    }

    public Event(Date Date_Event, String Titre, Double Prix, String Image, String Description) {
        this.Date_Event = Date_Event;
        this.Titre = Titre;
        this.Prix = Prix;
        this.Image = Image;
        this.Description = Description;
    }

    public Event(int Event_Id, Date Date_Event, String Titre, Double Prix, String Image, String Description, int Fk_Reserv) {
        this.Event_Id = Event_Id;
        this.Date_Event = Date_Event;
        this.Titre = Titre;
        this.Prix = Prix;
        this.Image = Image;
        this.Description = Description;
        this.Fk_Reserv = Fk_Reserv;
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

    public Double getPrix() {
        return Prix;
    }

    public void setPrix(Double Prix) {
        this.Prix = Prix;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public Event(Date Date_Event, String Titre, Double Prix, String Image, String Description, int Fk_Reserv) {
        this.Date_Event = Date_Event;
        this.Titre = Titre;
        this.Prix = Prix;
        this.Image = Image;
        this.Description = Description;
        this.Fk_Reserv = Fk_Reserv;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getFk_Reserv() {
        return Fk_Reserv;
    }

    public void setFk_Reserv(int Fk_Reserv) {
        this.Fk_Reserv = Fk_Reserv;
    }

    @Override
    public String toString() {
        return "Event{" + "Event_Id=" + Event_Id + ", Date_Event=" + Date_Event + ", Titre=" + Titre + ", Prix=" + Prix + ", Image=" + Image + ", Description=" + Description + ", Fk_Reserv=" + Fk_Reserv + '}';
    }
    
    
}
