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
public class Reservation {
    
   private int Reserv_Id;
   private int       Nb_Places;
    private Date Date_Achat;
    private Double        Total;
    private int        FK_Event;

    public Reservation() {
    }

    public Reservation(int Reserv_Id, int Nb_Places, Date Date_Achat, Double Total, int FK_Event) {
        this.Reserv_Id = Reserv_Id;
        this.Nb_Places = Nb_Places;
        this.Date_Achat = Date_Achat;
        this.Total = Total;
        this.FK_Event = FK_Event;
    }

    public Reservation(int Nb_Places, Date Date_Achat, Double Total, int FK_Event) {
        this.Nb_Places = Nb_Places;
        this.Date_Achat = Date_Achat;
        this.Total = Total;
        this.FK_Event = FK_Event;
    }

    public int getReserv_Id() {
        return Reserv_Id;
    }

    public void setReserv_Id(int Reserv_Id) {
        this.Reserv_Id = Reserv_Id;
    }

    public int getNb_Places() {
        return Nb_Places;
    }

    public void setNb_Places(int Nb_Places) {
        this.Nb_Places = Nb_Places;
    }

    public Date getDate_Achat() {
        return Date_Achat;
    }

    public void setDate_Achat(Date Date_Achat) {
        this.Date_Achat = Date_Achat;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public int getFK_Event() {
        return FK_Event;
    }

    public void setFK_Event(int FK_Event) {
        this.FK_Event = FK_Event;
    }

    @Override
    public String toString() {
        return "Reservation{" + "Reserv_Id=" + Reserv_Id + ", Nb_Places=" + Nb_Places + ", Date_Achat=" + Date_Achat + ", Total=" + Total + ", FK_Event=" + FK_Event + '}';
    }
    
    
    
    
}
