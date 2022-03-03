/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author SOULAYMA
 */
public class Rate {
    private int Rate_Id;
    private int Event_Id;
    private int Client_Id;
    private double Sum;
    public Rate(){
        }
    
        public Rate(int Rate_Id , int Event_Id, int Client_Id, double sum) {
        this.Rate_Id= Rate_Id ; 
        this.Event_Id = Event_Id ;
        this.Client_Id = Client_Id; 
        this.Sum = sum;
    
    }

    public Rate(int Event_Id,int Client_Id,  double Sum) {
        this.Event_Id = Event_Id ;
        this.Client_Id = Client_Id; 
        this.Sum = Sum;
    }

    public int getClient_Id() {
        return Client_Id;
    }

    public void setClient_Id(int Client_Id) {
        this.Client_Id = Client_Id;
    }

    public int getRate_Id() {
        return Rate_Id;
    }

    public void setRate_Id(int Rate_Id) {
        this.Rate_Id = Rate_Id;
    }

    public int getEvent_Id() {
        return Event_Id;
    }

    public void setEvent_Id(int Event_Id) {
        this.Event_Id = Event_Id;
    }

    public double getSum() {
        return Sum;
    }

    public void setSum(double Sum) {
        this.Sum = Sum;
    }

    @Override
    public String toString() {
        return "Rate{" + "Rate_Id=" + Rate_Id + ", Event_Id=" + Event_Id + ", Client_Id=" + Client_Id + ", Sum=" + Sum + '}';
    }

    }
    
